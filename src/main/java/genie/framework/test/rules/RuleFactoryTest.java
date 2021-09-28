package genie.framework.test.rules;

import com.fasterxml.jackson.databind.ObjectMapper;
import genie.framework.datamodel.bean.IBean;
import genie.framework.rules.dataobject.AbstractRule;
import genie.framework.rules.dataobject.RuleFactory;
import genie.framework.rules.engine.RuleEngine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RuleFactoryTest {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RuleEngine<TestContactBean> rulesEngine = new RuleEngine<TestContactBean>();
        TestContactBean bean1 = new TestContactBean();

        bean1.firstName ="Sabarinath";
        bean1.lastName = "Raju";

        TestContactBean bean2 = new TestContactBean();
        bean2.lastName = "Rahul";

        TestContactBean bean3 = new TestContactBean();
        bean3.lastName = "Raj";

        TestContactBean bean4 = new TestContactBean();

        objectMapper.writeValue(new File("target/test.json"),bean1);
        objectMapper.writeValue(new File("target/test1.json"),bean2);
        objectMapper.writeValue(new File("target/test2.json"),bean3);
        //objectMapper.writeValue(new File("target/test.json"),bean4);

        rulesEngine.execute(bean1);
        System.out.println("____________________________________________________________________________");
        rulesEngine.execute(bean2);
        System.out.println("____________________________________________________________________________");
        rulesEngine.execute(bean3);
        System.out.println("____________________________________________________________________________");
        rulesEngine.execute(bean4);
        System.out.println("____________________________________________________________________________");

    }

    public static class TestContactBean implements IBean{
        public String firstName;
        public String lastName;
        public Date dateOfBirth;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public String toString() {
            return "TestContactBean{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    '}';
        }
    }

}
