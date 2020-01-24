package problem1;

/**
 * KKProtocolException handles the incorrect format errors according to this chat room protocol.
 */
public class KKProtocolException extends Exception {

    private String message;

    /**
     * KKProtocolException class constructor.
     *
     * @param message a string describes the detailed error that causes this exception.
     */
    public KKProtocolException(String message) {
        super(message);
    }
}
