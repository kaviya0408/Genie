package genie.leaveapplication.dataobject;

import genie.framework.datamodel.bean.IBean;

import java.util.List;

public class Employee implements IBean {
    private String empId;
    private String firstName;
    private String lastName;
    private List<LeaveApplication> leaveApplicationList;

}
