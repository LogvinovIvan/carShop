package dao.exception;

/**
 * Created by Иван on 08.04.2016.
 */
public class PersistException extends Exception {
    public PersistException() {
    }

    public PersistException(String message) {
        super(message);
    }

    public PersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistException(Throwable cause) {
        super(cause);
    }

}
