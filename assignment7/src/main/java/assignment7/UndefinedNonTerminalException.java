package assignment7;

/**
 * assignment7.UndefinedNonTerminalException handles errors occurred when given definition is not found in grammar.
 */
public class UndefinedNonTerminalException extends Exception {

    private String msg;

    /**
     * assignment7.UndefinedNonTerminalException class constructor.
     *
     * @param msg a string representing the error message.
     */
    public UndefinedNonTerminalException(String msg) {
        this.msg = msg;
    }

    /**
     * Returns this assignment7.UndefinedNonTerminalException's msg.
     *
     * @return this msg.
     */
    public String getMsg() {
        return this.msg;
    }
}
