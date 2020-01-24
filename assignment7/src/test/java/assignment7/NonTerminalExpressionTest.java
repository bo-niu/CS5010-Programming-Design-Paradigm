package assignment7;

import assignment7.Grammar;
import assignment7.NonTerminalExpression;
import assignment7.UndefinedNonTerminalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NonTerminalExpressionTest {

    private NonTerminalExpression nonTerminalExpression1, nonTerminalExpression2;
    private Grammar grammar;

    @Before
    public void setUp() throws Exception {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("a", Arrays.asList("Alice", "Bob", "Clara"));
        map.put("b", Arrays.asList("student", "worker", "player"));
        grammar = new Grammar(map);
        nonTerminalExpression1 = new NonTerminalExpression("<a> is a good <b>");
        nonTerminalExpression2 = new NonTerminalExpression("skd");
    }

    @Test
    public void interpreter() throws UndefinedNonTerminalException {
        String result = nonTerminalExpression1.interpreter(grammar);
        System.out.println(result);
        String terminal = nonTerminalExpression2.interpreter(grammar);
        Assert.assertEquals("skd", terminal);
    }
}