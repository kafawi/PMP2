/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 1 ("Lamdas")
 */
package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testklasse zum SAM DoubleDoubleZuDouble
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 *
 */
public class DoubleDoubleZuDoubleTest {
  final private int    LEN = 10;
  private Double[]     x   = new Double[LEN];
  private Double[]     y   = new Double[LEN];

  DoubleDoubleZuDouble tester;

  @Test
  public void testWerteAusPlus() {

    tester = (x, y) -> x + y;

    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }

    for (int i = 0; i < LEN; i++) {
      assertEquals(tester.werteAus(x[i], y[i]), x[i] + y[i], 1E-5);
    }
  }

  @Test
  public void testWerteAusMinus() {

    tester = (x, y) -> x - y;

    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }

    for (int i = 0; i < LEN; i++) {
      assertEquals(tester.werteAus(x[i], y[i]), x[i] - y[i], 1E-5);
    }
  }

  @Test
  public void testWerteAusMal() {

    tester = (x, y) -> x * y;

    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }

    for (int i = 0; i < LEN; i++) {
      assertEquals(tester.werteAus(x[i], y[i]), x[i] * y[i], 1E-5);
    }
  }

  @Test
  public void testWerteAusDurch() {

    tester = (x, y) -> x / y;

    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }

    for (int i = 0; i < LEN; i++) {
      assertEquals(tester.werteAus(x[i], y[i]), x[i] / y[i], 1E-5);
    }
  }

  @Test
  public void testWerteAusNullstellen() {
    // gelichung ist y = a*x + b
    // Nulstellen bei y=0 -> x= -b/a
    tester = (a, b) -> -b / a;

    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }

    for (int i = 0; i < LEN; i++) {
      assertEquals(tester.werteAus(x[i], y[i]), -y[i] / x[i], 1E-5);
    }
  }

}
