package assignment7;

import assignment7.Grammar;
import assignment7.TerminalExpression;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TerminalExpressionTest {

    private TerminalExpression terminalExpression;
    private Grammar grammar = null;

    @Before
    public void setUp() throws Exception {
        terminalExpression = new TerminalExpression("terminal test");
    }

    @Test
    public void interpreter() {
        Assert.assertEquals("terminal test", terminalExpression.interpreter(grammar));
    }
}