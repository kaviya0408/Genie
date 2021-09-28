package genie.framework.rules.engine;

import genie.framework.datamodel.bean.IBean;

/**
 * @author Sabarinath Raju
 * @param <T extends Bean> any object of type bean will go through the rules engine
 *                        and execute the rules defined for the specific event and BeanType.
 *
 */
public interface IRuleEngine<B extends IBean> {

    public void execute(B bean);
}
