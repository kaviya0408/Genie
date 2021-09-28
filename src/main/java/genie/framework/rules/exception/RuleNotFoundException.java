package genie.framework.rules.exception;

public class RuleNotFoundException extends GenieRunTimeException {
    // TODO Create different Param Constructor for the Exception. - Arun
    public RuleNotFoundException(String message){
        super(message);
    }

    public RuleNotFoundException(){
        super();
    }
    public RuleNotFoundException(Throwable throwable){
        super(throwable);
    }
    public RuleNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
