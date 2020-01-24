package assignment7;

import assignment7.UndefinedNonTerminalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UndefinedNonTerminalExceptionTest {

    private UndefinedNonTerminalException undefinedNonTerminalException;

    @Before
    public void setUp() throws Exception {
        undefinedNonTerminalException = new UndefinedNonTerminalException("test string");
    }

    @Test
    public void getMsg() {
        Assert.assertEquals("test string", undefinedNonTerminalException.getMsg());
    }
}