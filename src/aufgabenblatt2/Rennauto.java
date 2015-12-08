/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 3 ("Threads")
 */
package aufgabenblatt2;

/**
 * Diese Klasse ist ein Rennauto.
 * 
 * @author Alexander Mendel und Karl-Fabian Witte
 *
 */
public class Rennauto extends Thread implements Comparable<Rennauto> {
  // --------------------------------------------------------------- VARIABLEN
  /**
   * Durchschnitsgeschwindigkeit in m/s
   */
  private double     geschwindigkeit;

  /**
   * Länsge der Rennstrecke
   */
  private double     totalStrecke;

  /**
   * gefahrene Strecke
   */
  private double     gefahreneStrecke = 0;

  /**
   * Auto Identifikationsnummer
   */
  private int        autoNr;

  /**
   * Objektzähler
   */
  private static int autoNrCounter    = 0;

  /**
   * gesamt benötighte Zeit in sek
   */
  private double     endZeit          = -1;

  // --------------------------------------------------------------- KONSTRUKTOR
  /**
   * KONSTRUKTOR
   */
  public Rennauto(double geschwindigkeit, double totalStrecke) {
    this.geschwindigkeit = geschwindigkeit;
    this.totalStrecke = totalStrecke;
    autoNr = autoNrCounter;
    autoNrCounter++;
  }

  @Override
  public void run() {
    // zeit in sekunden
    double benoetigteZeit = 0;
    // systemzeit in Millisekunden
    long startZeit = System.currentTimeMillis();

    while ((totalStrecke - gefahreneStrecke) > 1e-5) {
      if (!isInterrupted()) {
        benoetigteZeit = 0.8 + 0.4 * Math.random();
        try {
          sleep((long) (benoetigteZeit * 1000));
        } catch (InterruptedException e) {
          endZeit = (double) (System.currentTimeMillis() - startZeit) / 1000;
          System.err.println(printAbbruch());
          interrupt();
          return;
        }
        
        gefahreneStrecke += geschwindigkeit;
        System.err.printf("Wagen %d: %.1f / %.1f \n", autoNr, gefahreneStrecke,
            totalStrecke);
      } else {
        return;
      }
    }
    
    endZeit = (double) (System.currentTimeMillis() - startZeit) / 1000;
  }

  public String printErgebnis() {
    return String.format("Wagen %d: %.1f sek", autoNr, endZeit);
  }

  /**
   * toString methode für einen Abbruchfall
   * 
   * @return Informationen für die Abbgebrochenen Fall
   */
  public String printAbbruch() {
    return String.format("Wagen %d: %.1f m in %.6f sek", autoNr,
        gefahreneStrecke, endZeit);
  }

  /**
   * Getter zum Sortieren.
   * 
   * @return Die gebrauchte Zeit.
   */
  public double getEndZeit() {
    return endZeit;
  }

  /**
   * Getter zum Sortieren.
   * 
   * @return Die gebrauchte Zeit.
   */
  public double getGefahreneStrecke() {
    return gefahreneStrecke;
  }

  @Override
  public int compareTo(Rennauto anderesAuto) {
    int zeitVergleich = (int) ((endZeit - anderesAuto.getEndZeit()) * 1000);
    if (Math.abs(zeitVergleich) == 0) {
      return (int) 
          ((gefahreneStrecke - anderesAuto.getGefahreneStrecke()) * 1000);
    }
    return zeitVergleich;
  }

}
