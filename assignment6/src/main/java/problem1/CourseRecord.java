package problem1;

import java.util.Objects;

/**
 * This class represents a course record in the course.csv
 */
public class CourseRecord {
    private String module;
    private String presentation;
    private Integer length;

    /**
     * Course class constructor for course.csv.
     *
     * @param module       a string representing this Course's module.
     * @param presentation a string representing this Course's presentation.
     * @param length       an integer representing this Course's length.
     */
    public CourseRecord(String module, String presentation, Integer length) {
        this.module = module;
        this.presentation = presentation;
        this.length = length;
    }

    /**
     * Course class constructor for studentV.csv.
     *
     * @param module       a string representing this Course's module.
     * @param presentation a string representing this Course's presentation.
     */
    public CourseRecord(String module, String presentation) {
        this.module = module;
        this.presentation = presentation;
    }

    /**
     * Returns this Course's module.
     *
     * @return module.
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets this Course' module to input string.
     *
     * @param module a string representing this Course's module.
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * Returns this Course's presentation.
     *
     * @return presentation.
     */
    public String getPresentation() {
        return presentation;
    }

    /**
     * Sets this Course's presentation to input string.
     *
     * @param presentation a string representing this Course's presentation.
     */
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    /**
     * Returns this Course's length.
     *
     * @return length.
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Sets course's length to input integer.
     *
     * @param length an integer representing this Course's length.
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * Overrides equals in class java.lang.Object.
     *
     * @param o an object being passed to compare.
     * @return true if and only if o equals this Course.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseRecord)) return false;
        CourseRecord course = (CourseRecord) o;
        return Objects.equals(module, course.module) &&
                Objects.equals(presentation, course.presentation);
    }

    /**
     * Overrides hashcode in class java.lang.Object.
     *
     * @return the hashcode for this Course.
     */
    @Override
    public int hashCode() {
        return Objects.hash(module, presentation);
    }

    /**
     * Returns a string representation.
     *
     * @return this Course in a string.
     */
    @Override
    public String toString() {
        return "Course{" +
                "module='" + module + '\'' +
                ", presentation='" + presentation + '\'' +
                '}';
    }
}
