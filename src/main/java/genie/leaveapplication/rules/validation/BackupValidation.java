package genie.leaveapplication.rules.validation;

import genie.framework.rules.dataobject.AbstractRule;
import genie.framework.rules.dataobject.IAction;
import genie.framework.rules.dataobject.ICondition;
import genie.leaveapplication.dataobject.Employee;
import genie.leaveapplication.dataobject.LeaveApplication;

public class BackupValidation extends AbstractRule<LeaveApplication> {

    public BackupValidation(){
        super((leaveApp)->leaveApp.getBackup()==null,(leaveApp)-> System.err.println("You should specify the Backup Employee name in your Leave Application."),null);
    }
}
