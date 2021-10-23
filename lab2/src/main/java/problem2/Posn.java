package problem2;

import java.util.Objects;

public class Posn {
  private Integer x;
  private Integer y;

  /**
   * Represents a Cartesian coordinate.
   * @param x - value x, expressed as an Integer
   * @param y - value y, expressed as an Integer
   */
  public Posn(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter for property 'x'.
   * @return value for property 'x'.
   */
  public Integer getX() {
    return x;
  }

  /**
   * Getter for property 'y'.
   * @return value for property 'y'.
   */
  public Integer getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Posn posn = (Posn) o;

    if(!Objects.equals(this.x, posn.x)) return false;
    return Objects.equals(this.y, posn.y);
  }

  @Override
  public int hashCode() {
    int result = this.x != null ? this.x.hashCode(): 0;
    result = 31 * result + (this.y != null ? this.y.hashCode(): 0);
    return result;
  }

  @Override
  public String toString() {
    return "Posn{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
