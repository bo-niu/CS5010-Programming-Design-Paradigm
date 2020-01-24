package problem1.structure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    private Course course1, course2;

    @Before
    public void setUp() throws Exception {
        course1 = new Course("AAA", "S17", 155);
        course2 = new Course("BBB", "S18", 128);
    }

    @Test
    public void getModule() {
        Assert.assertEquals("AAA", course1.getModule());
        Assert.assertEquals("BBB", course2.getModule());
    }

    @Test
    public void setModule() {
        course2.setModule("AAA");
        Assert.assertEquals("AAA", course2.getModule());
    }

    @Test
    public void getPresentation() {
        Assert.assertEquals("S17", course1.getPresentation());
        Assert.assertEquals("S18", course2.getPresentation());
    }

    @Test
    public void setPresentation() {
        course2.setPresentation("S17");
        Assert.assertEquals("S17", course1.getPresentation());
    }

    @Test
    public void getLength() {
        Assert.assertEquals(155, course1.getLength(), 0);
        Assert.assertEquals(128, course2.getLength(), 0);
    }

    @Test
    public void setLength() {
        course2.setLength(155);
        Assert.assertEquals(155, course2.getLength(), 0);
    }

    @Test
    public void testEquals() {
        Assert.assertNotEquals(course1, "string");
        Assert.assertNotEquals(course1, course2);
        Assert.assertEquals(course1, course1);
        Course course3 = new Course("AAA", "S17", 155);
        Assert.assertEquals(course1, course3);
    }

    @Test
    public void testHashCode() {
        Assert.assertNotEquals(course1.hashCode(), course2.hashCode());
    }

    @Test
    public void testToString() {
        System.out.println(course1);
        System.out.println(course2);
    }
}