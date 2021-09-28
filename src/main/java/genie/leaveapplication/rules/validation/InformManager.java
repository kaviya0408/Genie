package genie.leaveapplication.rules.validation;

import genie.framework.rules.dataobject.AbstractRule;
import genie.leaveapplication.dataobject.LeaveApplication;

public class InformManager extends AbstractRule<LeaveApplication> {

    public InformManager(){
        super((leaveApp)->true,(leaveApp)->System.out.println("NOTE: Please inform your manager about the leave on deployment day. "),null);
    }
}
