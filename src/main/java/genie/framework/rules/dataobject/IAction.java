package genie.framework.rules.dataobject;

import genie.framework.datamodel.bean.IBean;

public interface IAction<B extends IBean>{
    public void performAction(B bean);
}
