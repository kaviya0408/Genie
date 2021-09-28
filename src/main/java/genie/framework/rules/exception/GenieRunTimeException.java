package genie.framework.rules.exception;

public class GenieRunTimeException extends RuntimeException{
    public GenieRunTimeException(String message){
        super(message);
    }

    public GenieRunTimeException(){
        super();
    }

    public GenieRunTimeException(Throwable throwable){
        super(throwable);
    }

    public GenieRunTimeException(String message, Throwable throwable){
        super(message, throwable);
    }
}
