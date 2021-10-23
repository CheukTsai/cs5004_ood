package problem2;

import java.util.Objects;

/**
 * Represents an abstract class AbstractCuboid, including its width, height, and depth.
 *
 * @author - Zhuocai Li
 */
public abstract class AbstractCuboid implements Cuboid {
  protected Integer width;
  protected Integer height;
  protected Integer depth;

  /**
   * Constructs a new AbstractCuboid, with width, height and depth
   *
   * @param width - the width of cuboid, expressed as an Integer
   * @param height - the height of cuboid, expressed as an Integer
   * @param depth - the depth of cuboid, expressed as an Integer
   * @exception IllegalArgumentException is thrown when width, height, or length is invalid
   */
  public AbstractCuboid(Integer width, Integer height, Integer depth) {
    if (this.isValid(width, height, depth)) {
      this.width = width;
      this.height = height;
      this.depth = depth;
    } else {
      throw new IllegalArgumentException("The input length is invalid.");
    }
  }

  /**
   * returns the width of cuboid, expressed as an Integer
   *
   * @return Integer
   */
  public Integer getWidth() {
    return width;
  }

  /**
   * returns the height of cuboid, expressed as an Integer
   *
   * @return Integer
   */
  public Integer getHeight() {
    return height;
  }

  /**
   * returns the depth of cuboid, expressed as an Integer
   *
   * @return Integer
   */
  public Integer getDepth() {
    return depth;
  }

  /**
   * {@inheritDoc} returns if certain width, height and depth can form a practical cuboid
   *
   * @return Boolean
   */
  @Override
  public boolean isValid(Integer width, Integer height, Integer depth) {
    return width >= 1 && height >= 1 && depth >= 1;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
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
    AbstractCuboid that = (AbstractCuboid) o;
    return Objects.equals(width, that.width)
        && Objects.equals(height, that.height)
        && Objects.equals(depth, that.depth);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return Integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(width, height, depth);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return Integer
   */
  @Override
  public String toString() {
    return "AbstractCuboid{" + "width=" + width + ", height=" + height + ", depth=" + depth + '}';
  }
}
