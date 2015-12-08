/**
 /**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 3 ("Simulation")
 */
package aufgabenblatt3;

import java.util.Observable;

/**
 * Die Klasse führt eine Simulation des Rangierbahnhofs aus. Deswegen ist keine
 * TestKlasse von nöten.
 * 
 * @author AlexLoeffel und kafawi
 *
 */
public class Simulation extends Observable implements Runnable {

	/**
	 * Der Bahnhof, der simuliert wird.
	 */
	private Rangierbahnhof	rbf;

	/**
	 * KONSTRUKTOR default
	 */
	public Simulation() {
		this(10);
	}

	/**
	 * KONSTRUKTOR
	 * 
	 * @param gleisAnzahl
	 *          Anzahl der Abstellgleise
	 */
	public Simulation(int gleisAnzahl) {
		rbf = new Rangierbahnhof(gleisAnzahl);
	}

	/**
	 * MAIN
	 * 
	 * @param args
	 *          Kommandozeileneingaben.
	 */
	public static void main(String[] args) {
		Thread simulation = new Thread(new Simulation());
		simulation.start();
	}

	@Override
	public void run() {
		int i;
		int gleis;
		// alle 500s ein neuer Lokführer
		while (!Thread.interrupted()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			i = (int) (Math.random() * 2);
			gleis = (int) (Math.random() * rbf.getGleisAnzahl());
			boolean richtung = true;
			if ((i % 2) == 0) {
				richtung = false;
			}
			new Lokfuehrer(rbf, gleis, richtung);

			// Aufgabe 3.4
			setChanged();
			notifyObservers();
		}

	}

	/**
	 * GETTER
	 * 
	 * @return der simulierte Rangierbahnhof.
	 */
	public Rangierbahnhof getRangierbahnhof() {
		return rbf;
	}

}
