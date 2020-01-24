package assignment7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * assignment7.NonTerminalExpression representing NonTerminal class in interpreter pattern.
 */
public class NonTerminalExpression implements Expression {

    private String production;

    /**
     * assignment7.NonTerminalExpression class constructor.
     *
     * @param production a string being interpreted.
     */
    public NonTerminalExpression(String production) {
        this.production = production;
    }

    /**
     * Using DFS recursive calls to randomly generate a sentence.
     *
     * @param grammar a assignment7.Grammar class representing the context.
     * @return a randomly generated assignment7.TerminalExpression.
     * @throws UndefinedNonTerminalException error when given definition is not found in grammar.
     */
    @Override
    public String interpreter(Grammar grammar) throws UndefinedNonTerminalException {
        Pattern pattern = Pattern.compile("<(.+?)>");
        Matcher matcher = pattern.matcher(production);
        if (matcher.find()) {
            String definition = matcher.group(1).toLowerCase();
            String production = grammar.getProduction(definition);
            String newProduction = this.production.replace(matcher.group(), production);
            return new NonTerminalExpression(newProduction).interpreter(grammar);
        } else {
            return new TerminalExpression(production).interpreter(grammar);
        }
    }
}
