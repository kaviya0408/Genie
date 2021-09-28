package genie.framework.rules.dataobject;

import genie.framework.datamodel.bean.IBean;

public interface ICondition<B extends IBean> {
    public boolean evaluate(B bean);
}

