package problem1.structure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentVTest {

    private StudentV s1, s2;
    private Course course1 = new Course("AAA", "S17", 155);
    private Course course2 = new Course("BBB", "S18", 128);

    @Before
    public void setUp() throws Exception {
        s1 = new StudentV(course1, 10, 100);
        s2 = new StudentV(course2, 20, 200);
    }

    @Test
    public void getDate() {
        Assert.assertEquals(10, s1.getDate(), 0);
        Assert.assertEquals(20, s2.getDate(), 0);
    }

    @Test
    public void setDate() {
        s2.setDate(10);
        Assert.assertEquals(10, s2.getDate(), 0);
    }

    @Test
    public void getClick() {
        Assert.assertEquals(100, s1.getClick(), 0);
        Assert.assertEquals(200, s2.getClick(), 0);
    }

    @Test
    public void setClick() {
        s2.setClick(100);
        Assert.assertEquals(100, s2.getClick(), 0);
    }

    @Test
    public void getCourse() {
        Assert.assertEquals(course1, s1.getCourse());
        Assert.assertEquals(course2, s2.getCourse());
    }

    @Test
    public void merge() {
        StudentV s3 = new StudentV("AAA", "S17", 10, 100);
        s1.merge(s3);
        Assert.assertEquals(200, s1.getClick(), 0);
    }

    @Test
    public void testEquals() {
        Assert.assertNotEquals(s1, "string");
        Assert.assertNotEquals(s1, s2);
        Assert.assertEquals(s1, s1);
        StudentV s3 = new StudentV(course1, 10, 100);
        Assert.assertEquals(s1, s3);
    }

    @Test
    public void testHashCode() {
        Assert.assertNotEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void testToString() {
        System.out.println(s1);
        System.out.println(s2);
    }
}