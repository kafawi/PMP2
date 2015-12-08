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
public class RechnerTest {
  final private int LEN      = 10;
  private Double[]  x        = new Double[LEN];
  private Double[]  y        = new Double[LEN];
  private Rechner   calculon = new Rechner();

  @Test
  public void TestBerechnePlus() {
    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }

    for (int i = 0; i < LEN; i++) {
      assertEquals(calculon.berechne(Operation.PLUS, x[i], y[i]), 
          x[i] + y[i],
          1E-5);
    }
  }

  @Test
  public void TestBerechneMinus() {
    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }
    for (int i = 0; i < LEN; i++) {
      assertEquals(calculon.berechne(Operation.MINUS, x[i], y[i]), 
          x[i] - y[i],
          1E-5);
    }

  }

  @Test
  public void TestBerechneMal() {
    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }
    for (int i = 0; i < LEN; i++) {
      assertEquals(calculon.berechne(Operation.MAL, x[i], y[i]), 
          x[i] * y[i],
          1E-5);
    }

  }

  @Test
  public void TestBerechneDurch() {
    for (int i = 0; i < LEN; i++) {
      x[i] = 100 * Math.random();
      y[i] = 100 * Math.random();
    }
    for (int i = 0; i < LEN; i++) {
      assertEquals(calculon.berechne(Operation.DURCH, x[i], y[i]), 
          x[i] / y[i],
          1E-5);
    }

  }

}
