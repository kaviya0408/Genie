package genie.leaveapplication.dataobject;

import genie.framework.datamodel.bean.IBean;

import java.util.Date;

public class




LeaveApplication implements IBean {
    private Date leaveStartDate;
    private Date returnDate;
    private String reason;
    private Employee requester;
    private Employee backup;
    private Employee approver;

    public Date getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(Date leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getRequester() {
        return requester;
    }

    public void setRequester(Employee requester) {
        this.requester = requester;
    }

    public Employee getBackup() {
        return backup;
    }

    public void setBackup(Employee backup) {
        this.backup = backup;
    }

    public Employee getApprover() {
        return approver;
    }

    public void setApprover(Employee approver) {
        this.approver = approver;
    }
}
