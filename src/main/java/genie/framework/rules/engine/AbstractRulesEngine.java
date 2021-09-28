package genie.framework.rules.engine;

import genie.framework.datamodel.bean.IBean;
import genie.framework.rules.dataobject.AbstractRule;
import genie.framework.rules.dataobject.IRule;
import genie.framework.rules.dataobject.RuleFactory;
import genie.framework.rules.dataobject.RuleList;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRulesEngine<B extends IBean> implements IRuleEngine<B>{
    //TODO Remove the below list once the design is completed.
    public RuleList<IRule<B>> ruleLists = RuleFactory.<B>createRuleList();

    @Override
    public void execute(B bean) {
        ruleLists.execute(bean);
    }
}
