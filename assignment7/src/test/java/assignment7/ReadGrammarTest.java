package assignment7;

import assignment7.ReadGrammar;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class ReadGrammarTest {

    private ReadGrammar readGrammar;

    @Before
    public void setUp() throws Exception {
        readGrammar = new ReadGrammar("src/main/resources/grammars/poem.json");
    }

    @Test
    public void load() throws IOException, ParseException {
        HashMap map = readGrammar.load();
        Assert.assertTrue(map.containsKey("object"));
        Assert.assertTrue(map.containsKey("verb"));
        Assert.assertTrue(map.containsKey("adverb"));
    }

    @Test
    public void getFilePath() {
        Assert.assertEquals("src/main/resources/grammars/poem.json", readGrammar.getFilePath());
    }

    @Test
    public void setFilePath() {
        ReadGrammar test = new ReadGrammar(null);
        test.setFilePath("src/main/resources/grammars/poem.json");
        Assert.assertEquals("src/main/resources/grammars/poem.json", test.getFilePath());
    }

    @Test
    public void testEquals() {
        ReadGrammar test = new ReadGrammar(null);
        test.setFilePath("src/main/resources/grammars/poem.json");
        Assert.assertEquals(test, readGrammar);
        Assert.assertEquals(readGrammar, readGrammar);
        Assert.assertNotEquals(readGrammar, "string");
    }

    @Test
    public void testHashCode() {
        ReadGrammar test = new ReadGrammar(null);
        test.setFilePath("some filepath");
        Assert.assertNotEquals(readGrammar.hashCode(), test.hashCode());
        Assert.assertEquals(readGrammar.hashCode(), readGrammar.hashCode());
    }
}