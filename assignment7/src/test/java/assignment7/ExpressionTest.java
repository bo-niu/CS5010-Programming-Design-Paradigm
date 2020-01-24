package assignment7;

import assignment7.Expression;
import assignment7.Grammar;
import assignment7.NonTerminalExpression;
import assignment7.TerminalExpression;
import assignment7.UndefinedNonTerminalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ExpressionTest {

    private Expression expression1, expression2;
    private Grammar grammar;

    @Before
    public void setUp() throws Exception {
        expression1 = new TerminalExpression("terminal expression");
        expression2 = new NonTerminalExpression("<test>");
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("test", Collections.singletonList("terminal expression"));
        grammar = new Grammar(map);
    }

    @Test
    public void interpreter() throws UndefinedNonTerminalException {
        Assert.assertEquals(expression1.interpreter(grammar), "terminal expression");
        Assert.assertEquals(expression2.interpreter(grammar), "terminal expression");
    }
}