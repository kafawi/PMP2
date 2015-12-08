/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 1 ("Rangierbahnhof")
 */
package aufgabenblatt3;

/**
 * Diese Klasse beschreibt ein Rangierbahnhof.
 * @author AlexLoeffel und kafawi
 *
 */
public class Rangierbahnhof {

  /**
   * Beschreibt die Abstellgleise.
   */
  private Zug gleise[];

  /**
   * KONSTRUKTOR
   * 
   * @param gleisAnzahl
   *          Anzahl der Abstellgleise
   */
  public Rangierbahnhof(int gleisAnzahl) {
    gleise = new Zug[gleisAnzahl];
  }

  /**
   * Ein Zug wird auf eine bestimmtes Gleis abgestellt.
   * @param zug Ein Zugobjelk, welcher auf das Gleis abgestellt wird.
   * @param gleis Position, auf die der Zug geparkt wird.
   * @throws IllegalArgumentException 
   */
  public synchronized void zugAbstellen(Zug zug, int gleis)
      throws IllegalArgumentException {
    while (gleise[gleis] != null){
      try {
        wait();
        // damit es schöner wird, könnte man hier eine Thread.sleep(500); 
      } catch (InterruptedException e) {
      }
    }
    if (gleis < 0) {
      throw new IllegalArgumentException("" + gleis
          + "ist zu kleine Gleisnummer");
    } else if (gleis >= gleise.length) {
      throw new IllegalArgumentException("" + gleis + "zu grosse Gleisnummer");
    } 
    gleise[gleis] = zug;
    this.notifyAll();
  }

  /**
   * Ein Zug wird auf von bestimmtes Gleis entfernt.
   * @param gleis Position, von der der Zug rausgefahren werden soll.
   * @throws IllegalArgumentException
   */
	public synchronized void zugAusfahren(int gleis)
      throws IllegalArgumentException {
    while (gleise[gleis] == null){
      try {
        wait();
        // damit es schöner wird, könnte man hier eine Thread.sleep(500); 
      } catch (InterruptedException e) {
      }
    }
    if (gleis < 0) {
      throw new IllegalArgumentException("" + gleis
          + "ist zu kleine Gleisnummer");
    } else if (gleis >= gleise.length) {
      throw new IllegalArgumentException("" + gleis + "zu grosse Gleisnummer");
    } 
    gleise[gleis] = null;
    this.notifyAll();
  }

  /**
   * GETTER
   * 
   * @return Array der Züge auf dem Abstellgleisen.
   */
  public Zug[] getGleise() {
    return gleise;
  }

  /**
   * GETTER
   * 
   * @return Anzahl der Abstellgleise.
   */
  public int getGleisAnzahl() {
    return gleise.length;
  }

}
