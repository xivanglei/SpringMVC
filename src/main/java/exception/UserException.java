package exception;

import utils.ExceptionPropertyUtil;

public class UserException extends Exception {
    private String message;
    public UserException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return new ExceptionPropertyUtil().getExceptionMsg(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
