/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 1 ("Lamdas")
 */

package aufgabenblatt2;

/**
 * SAM für die Lamdas mit Doublewerten.
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 *
 */
@FunctionalInterface
public interface DoubleDoubleZuDouble {
  
  /**
   * Methode für die Lamdas.
   * @param x erste Zahl
   * @param y zweite Zahl
   * @return Ergebnis der miteinander operierten Zahlen.
   */
  public Double werteAus(Double x, Double y);

}
