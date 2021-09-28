package genie.framework.rules.dataobject;

import genie.framework.datamodel.bean.IBean;

public interface IRule<B extends IBean> {
    public void execute(B bean);
}
