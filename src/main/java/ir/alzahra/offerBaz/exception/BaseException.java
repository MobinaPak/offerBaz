package ir.alzahra.offerBaz.exception;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/19/2019, Fri
 **/
public class BaseException extends Exception {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
