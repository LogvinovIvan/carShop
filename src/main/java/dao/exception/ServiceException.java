package dao.exception;

/**
 * Created by evgen on 09.04.2016.
 */
public class ServiceException extends Exception {

    public ServiceException(){
        super();
    }

    public ServiceException(Throwable cause){
        super(cause);
    }

    public ServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
