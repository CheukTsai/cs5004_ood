package problem1;

import java.util.Objects;

/**
 * Represents a concrete class Course, with name, prefix and number
 */
public class Course {
    private final String name;
    private final String prefix;
    private final int number;

    /**
     * Constructs a Course
     * @param name - String, name of the course
     * @param prefix - String, name of the prefix
     * @param number - String, number of the course
     */
    public Course(String name, String prefix, int number) {
        this.name = name;
        this.prefix = prefix;
        this.number = number;
    }

    /**
     * {@inheritDoc} returns an integer representation of the object memory address
     * @return Integer
     */
    @Override
    public String toString() {
        return prefix + number + ": " + name;
    }

    /**
     * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
     * current instance
     * @param o - an object to compare
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return number == course.number &&
                name.equals(course.name) &&
                prefix.equals(course.prefix);
    }

    /**
     * {@inheritDoc} returns an integer representation of the object memory address
     * @return Integer
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, prefix, number);
    }


}
