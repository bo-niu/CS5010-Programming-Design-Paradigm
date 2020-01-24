package assignment7;

/**
 * assignment7.Expression interface representing the expression being interpreted in interpreter pattern.
 */
public interface Expression {
    String interpreter(Grammar grammar) throws UndefinedNonTerminalException;
}
