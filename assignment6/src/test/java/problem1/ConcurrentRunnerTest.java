package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcurrentRunnerTest {

    private String[] args = null;

    @Before
    public void setUp() throws Exception {
        args = new String[]{"--dir", "data", "--numThreads", "4", "--threshold", "11000"};
    }

    @Test
    public void main() {
        ConcurrentRunner.main(args);
    }
}