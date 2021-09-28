package genie.framework.rules.dataobject;

import genie.framework.datamodel.bean.IBean;
import genie.framework.rules.dataobject.results.Message;
import genie.framework.rules.dataobject.results.MessageLevel;
import genie.framework.rules.dataobject.results.MessageType;
import genie.framework.rules.exception.InvalidRuleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRule<B extends IBean> implements IRule<B>  {
    //TODO Should think about rules priority..
    //TODO Log Rule execution should be designed.
    private ICondition condition;
    private IAction action;
    private boolean active = true;
    private String code;
    private String name;
    private Map<MessageLevel, Map<MessageType, List<Message>>> messages ;
    private IRule<B> parentRule;
    private List<IRule<B>> childRules;

    public AbstractRule(ICondition<B> condition, IAction<B> action, AbstractRule<B> parentRule){
        this.initRule(condition,action,parentRule);
    }

    private void initRule(ICondition<B> condition, IAction<B> action, AbstractRule<B> parentRule){
        //TODO Remove the hard code string and move it to property file.
        if(condition == null)
            throw new InvalidRuleException("This rule is Invalid. ");
        this.condition = condition;
        this.action = action;
        if(parentRule != null)
            parentRule.addChildRule(this);
        this.parentRule = parentRule;
    }

    @Override
    public final void execute(B bean) {
        if (!this.active) return;
        if(!condition.evaluate(bean)) return;
        if(action !=null ) action.performAction(bean);
        if(childRules == null) return;

        childRules.forEach(rule -> rule.execute(bean));
    }

    private void addChildRule(IRule rule){
        if(this.childRules == null)
            this.childRules = new ArrayList<IRule<B>>();
        this.childRules.add(rule);
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IRule<B>> getChildRules() {
        return childRules;
    }

    public void setChildRules(List<IRule<B>> childRules) {
        this.childRules = childRules;
    }
}
