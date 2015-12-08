/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 2 ("Lokfuehrer")
 */
package aufgabenblatt3;

/**
 * Diese Klasse beschreibt deinen Lokführer der die Züge für auf dem
 * Rangierbahnhof bedient.
 * 
 * @author AlexLoeffel und kafawi
 *
 */
public class Lokfuehrer extends Thread {

	/**
	 * Referenz zu einem Rangierbahnhof, auf dem der Lokfuehrer arbeitet.
	 */
	private Rangierbahnhof	rbf;

	/**
	 * Nummer eines Abstellgleises.
	 */
	private int	           gleis;

	/**
	 * Richtung aus oder in ein Abstellgleis true = einfahrt, false = ausfahrt
	 */
	private boolean	       richtung;

	/**
	 * KONSTRUKTOR
	 * 
	 * @param rbf
	 *          Arbeitsplatz des Lokfuehrers.
	 * @param gleis
	 *          Nummer seines Abstellgleises.
	 * @param richtung
	 *          Richtung aus oder in das Abstellgleis.
	 */
	public Lokfuehrer(Rangierbahnhof rbf, int gleis, boolean richtung) {
		this.rbf = rbf;
		this.gleis = gleis;
		this.richtung = richtung;
		start();
	}

	@Override
	public void run() {
		if (!isInterrupted()) {
			if (richtung == false) {
				try {
					rbf.zugAusfahren(gleis);
					System.err.println("Lockfuehrer " + Thread.currentThread().getId()
					    + " fährt Zug aus Gleis " + gleis + " heraus.");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}

			} else {
				try {
					rbf.zugAbstellen(new Zug(), gleis);
					System.err.println("Lockfuehrer " + Thread.currentThread().getId()
					    + " fährt Zug auf Gleis " + gleis + ".");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
	}
}