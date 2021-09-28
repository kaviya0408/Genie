package genie.temp;

import com.fasterxml.jackson.databind.ObjectMapper;
import genie.framework.datamodel.bean.IBean;
import genie.framework.test.rules.RuleFactoryTest;
import genie.framework.test.rules.*;

import java.beans.beancontext.BeanContext;
import java.beans.beancontext.BeanContextChild;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConversionJava extends RuleFactoryTest{
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        RuleFactoryTest RuleFactoryTest=null;
        try {
            String configjson = "{\"firstName\":\"Sabarinath\",\"lastName\":\"Raju\",\"dateOfBirth\":null}";
            RuleFactoryTest = objectMapper.readValue(configjson,RuleFactoryTest.class);
            System.out.println(RuleFactoryTest.firstName+" "+RuleFactoryTest.lastName+" "+RuleFactoryTest.dateOfBirth);
            //System.out.println(RuleFactoryTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(RuleFactoryTest);
    }
}

