package genie.leaveapplication.rules.validation;

import genie.framework.rules.dataobject.AbstractRule;
import genie.leaveapplication.dataobject.LeaveApplication;

public class WarningDepDay extends AbstractRule<LeaveApplication> {

    public WarningDepDay(){
        super((leaveApp)->true,(leaveApp)->System.out.println("WARNING: Please plan to take leave on non-deployment day"),null);
    }
}