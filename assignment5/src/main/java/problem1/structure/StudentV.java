package problem1.structure;

import java.util.Objects;

/**
 * StudentV class representing each student view in studentV.csv
 */
public class StudentV extends Course {

    private Integer date;
    private Integer click;

    /**
     * StudentV class constructor
     * @param module a string representing this studentV's module.
     * @param presentation a string representing this studentV's representation.
     * @param date an integer representing this studentV's date.
     * @param click an integer representing this studentV's click.
     */
    public StudentV(String module, String presentation, Integer date, Integer click) {
        super(module, presentation);
        this.date = date;
        this.click = click;
    }

    /**
     * Alternative StudentV class constructor
     * @param course a course representing this course.
     * @param date an integer representing this studentV's date.
     * @param click an integer representing this studentV's click.
     */
    public StudentV(Course course, Integer date, Integer click) {
        super(course.getModule(), course.getPresentation());
        this.date = date;
        this.click = click;
    }

    /**
     * Returns this StudentV's date.
     * @return date.
     */
    public Integer getDate() {
        return date;
    }

    /**
     * Sets this StudentV's date to input integer.
     * @param date an integer representing this studentV's date.
     */
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     * Returns this StudentV's click.
     * @return click.
     */
    public Integer getClick() {
        return click;
    }

    /**
     * Sets this StudentV's click to input integer.
     * @param click an integer representing this student's click.
     */
    public void setClick(Integer click) {
        this.click = click;
    }

    /**
     * Returns this StudentV's course.
     * @return course.
     */
    public synchronized Course getCourse() {
        return new Course(super.getModule(), super.getPresentation());
    }

    /**
     * Merges a new StudentV to this StudentV.
     * @param studentV a new StudentV.
     */
    public synchronized void merge(StudentV studentV) {
        if (super.equals(studentV) && studentV.date.equals(this.date)) {
            this.click += studentV.click;
        }
    }

    /**
     * Overrides equals in class java.lang.Object.
     *
     * @param o an object being passed to compare.
     * @return true if and only if o equals this StudentV.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentV)) return false;
        if (!super.equals(o)) return false;
        StudentV studentV = (StudentV) o;
        return Objects.equals(date, studentV.date) &&
                Objects.equals(click, studentV.click);
    }

    /**
     * Overrides hashcode in class java.lang.Object.
     *
     * @return the hashcode to this StudentV.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date, click);
    }

    /**
     * Returns a string representation.
     *
     * @return this StudentV in a string.
     */
    @Override
    public String toString() {
        return "Student{" +
                "from " + super.toString() +
                "date=" + date +
                ", click=" + click +
                '}';
    }
}
