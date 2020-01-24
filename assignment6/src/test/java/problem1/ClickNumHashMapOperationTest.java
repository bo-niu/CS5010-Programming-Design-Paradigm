package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

public class ClickNumHashMapOperationTest {

    private ClickNumHashMapOperation mapOperation;
    private ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    @Before
    public void setUp() throws Exception {
        map.put(12, 120);
        mapOperation = new ClickNumHashMapOperation(map);
    }

    @Test
    public void getMap() {
        ConcurrentHashMap<Integer, Integer> map1 = mapOperation.getMap();
        Assert.assertTrue(map1.containsKey(12));
        int value = map1.get(12);
        Assert.assertEquals(120, value, 0);
    }

    @Test
    public void changeMap() {
        mapOperation.changeMap(12, 110);
        mapOperation.changeMap(11, 100);
        ConcurrentHashMap<Integer, Integer> map1 = mapOperation.getMap();
        Assert.assertTrue(map1.containsKey(12));
        int value = map1.get(12);
        Assert.assertEquals(230, value, 0);
        Assert.assertTrue(map1.containsKey(11));
        int value2 = map1.get(11);
        Assert.assertEquals(100, value2, 0);
    }
}