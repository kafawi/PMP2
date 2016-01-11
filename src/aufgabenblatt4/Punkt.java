package aufgabenblatt4;

/**
 * Diese Klasse repräsentiert einen Punkt auf einer Fläche.
 * 
 * @author Alex und Kalle
 *
 */
public class Punkt {

  /**
   * X koordinate (horizontal)
   */
  private double x;

  /**
   * y-Koordinate (vertikal)
   */
  private double y;

  /**
   * KONSTRUKTOR
   */
  public Punkt(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter
   * 
   * @return x-koordinate
   */
  public double getX() {
    return x;
  }

  /**
   * Getter
   * 
   * @return y-Koordinate
   */
  public double getY() {
    return y;
  }

  /**
   * Setter
   * 
   * @param x
   *          x-Koordinate
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Setter
   * 
   * @param y
   *          y-Koordinate
   */
  public void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

}