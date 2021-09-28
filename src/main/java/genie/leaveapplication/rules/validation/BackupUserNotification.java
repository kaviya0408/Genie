package genie.leaveapplication.rules.validation;

import genie.framework.rules.dataobject.AbstractRule;
import genie.leaveapplication.dataobject.LeaveApplication;

public class BackupUserNotification extends AbstractRule<LeaveApplication> {

    public BackupUserNotification(){
        super((leaveApp)->leaveApp.getBackup()!=null,(leaveApp)-> System.out.println("You should inform the Backup Employee about your leave."),null);
    }
}
