/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 4 ("Generics")
 */

package aufgabenblatt1;

/**
 * Testet Eigenschaften der ArrayListe durch. 
 * 
 * Besteht nur aus einer statischen Methode.
 * 
 * @author Alexander Mendel und Karl-Fabian Witte
 *
 */
public class Pruefung {
  
  /**
   * Prüft, ob die erste Zahl im Array eine Nummer ist
   * @param liste ArrayListe, die wir überprüfen wollen.
   * @return Wahrheitswert, ob Elemente Zahlen sind oder nicht.
   * @throws NullPointerException
   */
  public static boolean isNumber(ArrayListe<?> liste) {
    if ( liste.getAnzahlElemente() == 0 ){
      return false;
    }
    return (liste.get(0) instanceof Number)? true : false;
  }
  
}
