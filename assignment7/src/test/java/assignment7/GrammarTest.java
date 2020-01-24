package assignment7;

import assignment7.Grammar;
import assignment7.UndefinedNonTerminalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GrammarTest {

    private Grammar grammar;
    private HashMap<String, List<String>> map = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        map.put("a", Arrays.asList("Alice", "Bob", "Clara"));
        map.put("b", Arrays.asList("student", "worker", "player"));
        grammar = new Grammar(map);
    }

    @Test(expected = UndefinedNonTerminalException.class)
    public void getProduction() throws UndefinedNonTerminalException {
        String resultA = grammar.getProduction("a");
        Assert.assertTrue(Arrays.asList("Alice", "Bob", "Clara").contains(resultA));
        String resultB = grammar.getProduction("b");
        Assert.assertTrue(Arrays.asList("student", "worker", "player").contains(resultB));
        grammar.getProduction("non-exist");
    }

    @Test
    public void getMap() {
        HashMap<String, List<String>> map = grammar.getMap();
        Assert.assertTrue(map.containsKey("a"));
        Assert.assertTrue(map.containsKey("b"));
        List<String> listA = map.get("a");
        Assert.assertEquals(listA, Arrays.asList("Alice", "Bob", "Clara"));
        List<String > listB = map.get("b");
        Assert.assertEquals(listB, Arrays.asList("student", "worker", "player"));
    }

    @Test
    public void setMap() {
        Grammar test = new Grammar(null);
        test.setMap(map);
        Assert.assertEquals(this.map, map);
    }

    @Test
    public void testEquals() {
        Grammar test = new Grammar(null);
        test.setMap(map);
        Assert.assertEquals(test, grammar);
        Assert.assertEquals(grammar, grammar);
        Assert.assertNotEquals(grammar, "string");
    }

    @Test
    public void testHashCode() {
        HashMap<String, List<String>> testMap = new HashMap<>();
        testMap.put("test", Arrays.asList("foo", "bar"));
        Grammar test = new Grammar(testMap);
        Assert.assertNotEquals(test.hashCode(), grammar.hashCode());
    }
}