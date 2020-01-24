package assignment7;

/**
 * assignment7.TerminalExpression class representing the Terminal expression in interpreter pattern.
 */
public class TerminalExpression implements Expression {

    private String production;

    /**
     * assignment7.TerminalExpression class constructor.
     *
     * @param production a string being interpreted.
     */
    public TerminalExpression(String production) {
        this.production = production;
    }

    /**
     * Returns this production as a base case in the recursive calls.
     *
     * @param grammar assignment7.Grammar class representing the context.
     * @return this production.
     */
    @Override
    public String interpreter(Grammar grammar) {
        return production;
    }
}
