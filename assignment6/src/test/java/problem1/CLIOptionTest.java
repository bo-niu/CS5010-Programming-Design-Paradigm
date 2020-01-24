package problem1;

import org.apache.commons.cli.Options;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CLIOptionTest {

    private CLIOption cliOption;

    @Before
    public void setUp() throws Exception {
        cliOption = new CLIOption();
    }

    @Test
    public void createOptions() {
        Options option = cliOption.createOptions();
        Assert.assertTrue(option.hasLongOption("dir"));
        Assert.assertTrue(option.hasLongOption("threshold"));
    }

    @Test
    public void printHelp() {
    }
}