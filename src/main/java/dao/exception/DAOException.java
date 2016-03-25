package dao.exception;

/**
 * Created by Иван on 25.03.2016.
 */
public class DAOException extends Exception {
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
