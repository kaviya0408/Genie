package genie.framework.rules.dataobject;

import genie.framework.datamodel.bean.IBean;
import genie.framework.rules.exception.RuleNotFoundException;
import genie.temp.TRuleCategory;
import genie.temp.RuleConvert;
import genie.temp.TRuleList;
import genie.temp.TRules;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RuleFactory {
    public static <T extends IBean> AbstractRule<T>  createRule(ICondition<T> condition, IAction<T> action, AbstractRule<T> parentRule){
        return new AbstractRule<T>(condition,action,parentRule){};
    }

    public static <T extends IBean> RuleList<IRule<T>> createRuleList(){
        TRuleCategory ruleCategory = RuleConvert.getRuleCategory();
        RuleList<IRule<T>> finalRuleList =null;
        for(TRuleList ruleList : ruleCategory.ruleLists){
            finalRuleList= new RuleList<IRule<T>>(ruleList.code,ruleList.name,ruleList.beanType);
            for(TRules tRules : ruleList.rules){
                createAndAddRule(tRules,finalRuleList);
            }
        }
        return finalRuleList;
    }


    private static <T extends IBean> void createAndAddRule(TRules tRule, List<IRule<T>> rules){
        if(rules == null) throw new RuleNotFoundException("Rule List can not be Null");
        if(tRule.classPath!=null && !tRule.classPath.isEmpty()){
            //TODO handle the exceptions in a different catch - Arun
            try {
                AbstractRule<T> rule= (AbstractRule<T>)Class.forName(tRule.classPath).getConstructor().newInstance();
                rule.setActive(tRule.active);
                rule.setCode(tRule.name);//TODO Change the Code from JASON Object
                rule.setName(tRule.name);
                rules.add(rule);
                if(tRule.childRules != null) {
                    List<IRule<T>>  ruleList = new ArrayList<IRule<T>>();
                    rule.setChildRules(ruleList);
                    tRule.childRules.forEach((cRule) -> createAndAddRule(cRule, ruleList));
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuleNotFoundException("Rule Class not found:"+ tRule.classPath);
            }
        }else{
            throw new RuleNotFoundException("Rule Class path is either empty or null"+ tRule.name);
        }
    }
}


