package genie.temp;

import java.util.ArrayList;

public class RuleConvert {
    public static TRuleCategory getRuleCategory(){
        TRuleCategory ruleCategory = new TRuleCategory();
        TRuleList ruleList= new TRuleList();
        ruleList.code = "LeaveApplicationRuleList";
        ruleList.name = "Leave Application Rules";
        ruleList.beanType = "genie.leaveapplication.dataobject.LeaveApplication";
        ruleList.ruleType = "validation";


        TRules rules1 = new TRules();
        rules1.name = "LAR0001-ValidateBackupUser";
        rules1.classPath = "genie.leaveapplication.rules.validation.BackupValidation";

        TRules rules2 = new TRules();
        rules2.name = "LAR0002-validate deployment day";
        rules2.classPath = "genie.leaveapplication.rules.validation.DeployDataValidation";


        TRules rules3 = new TRules();
        rules3.name = "LAR0002.1-WARNING message for deploy day";
        rules3.classPath = "genie.leaveapplication.rules.validation.WarningDepDay";


        TRules rules4 = new TRules();
        rules4.name = "LAR0002.2-informManager";
        rules4.classPath = "genie.leaveapplication.rules.validation.InformManager";

        if(ruleList.rules == null){
            ruleList.rules =  new ArrayList<TRules>();
        }

        ruleList.rules.add(rules1);
        ruleList.rules.add(rules2);
        if(rules2.childRules == null)
            rules2.childRules = new ArrayList<TRules>();
        rules2.childRules.add(rules3);
        rules2.childRules.add(rules4);
        ruleCategory.ruleLists = new ArrayList<TRuleList>();
        ruleCategory.ruleLists.add(ruleList);
        return ruleCategory;

    }
}
