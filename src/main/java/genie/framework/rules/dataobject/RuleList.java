package genie.framework.rules.dataobject;

import genie.framework.datamodel.bean.IBean;
import genie.framework.rules.exception.RuleNotFoundException;

import java.util.ArrayList;

//TODO Determine if we need to include the inactive Rule in this list or not
public class RuleList<R extends IRule> extends ArrayList<R> {
    private String code;
    private String name;
    private Class beanType;

    public RuleList(String code, String name, String beanType){
        this.code = code;
        this.name = name;
        try {
            this.beanType = Class.forName(beanType);
        } catch (ClassNotFoundException e) {
            throw new RuleNotFoundException("Rule class "+ beanType +"not found: ", e);
        }
    }

    public void execute(IBean bean){
        for (R rule: this){
            rule.execute(bean);
        }
    }



}
