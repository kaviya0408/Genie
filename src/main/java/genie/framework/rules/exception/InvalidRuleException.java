package genie.framework.rules.exception;

public class InvalidRuleException extends GenieRunTimeException{
    // TODO Create different Param Constructor for the Exception. - Arun
    public InvalidRuleException(String message){
        super(message);
    }

    public InvalidRuleException(){
        super();
    }
}
