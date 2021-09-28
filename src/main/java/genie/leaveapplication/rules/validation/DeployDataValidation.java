package genie.leaveapplication.rules.validation;

import genie.framework.rules.dataobject.AbstractRule;
import genie.leaveapplication.dataobject.LeaveApplication;

public class DeployDataValidation  extends AbstractRule<LeaveApplication> {

    public DeployDataValidation(){
        super((leaveApp)->leaveApp.getLeaveStartDate().getDay()==2,null,null);
    }
}