/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 2 ("Wiederholung")
 */
package aufgabenblatt1;

import java.util.ArrayList;
import java.util.List;

/**
 * Informationen eines Studenten an einer Universität.
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 */
public class Student implements Comparable<Student> {

	// --------------------------------------------------------- Klassen-Variablen
	/**
	 * Objektzähler für die Matrikelnummer
	 */
	private static int matrikelnummerZaehler = 0;

	// ---------------------------------------------------------- Objekt-Variablen
	/**
	 * Vorname des Studenten
	 */
	private String vorname;

	/**
	 * Nachname des Studenten
	 */
	private String nachname;

	/**
	 * eindeutige Identifikationsnummer Matrikelnummer wird erstellt im
	 * Konstruktor mit MatrikelnummerZaehler.
	 */
	private final int matrikelnummer;

	/**
	 * Liste mit allen Prüfungen
	 */
	private List<Pruefungsleistung> pruefungsleistungsListe;

	// --------------------------------------------------------------- Konstruktor
	/**
	 * Konstruktor
	 * 
	 * @param modulName
	 *          Name des Moduls
	 * @param note
	 *          erbrachte Leistung in der Modulprüfung
	 */
	public Student(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
		matrikelnummer = matrikelnummerZaehler;
		pruefungsleistungsListe = new ArrayList<Pruefungsleistung>();

		matrikelnummerZaehler++;
	}

	// -------------------------------------------------------------------- Getter
	/**
	 * Getter vorname
	 * 
	 * @return Vorname des Studenten
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Getter nachname
	 * 
	 * @return Nachname des Studenten
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Getter matrikelnummer
	 * 
	 * @return eindeutige Identifikationsnummer
	 */
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	/**
	 * Getter pruefungsleistungsListe
	 * 
	 * @return Liste aller universitären erbrachten Leitungen
	 */
	public List<Pruefungsleistung> getPruefungsleistungsListe() {
		return pruefungsleistungsListe;
	}

	// -------------------------------------------------------------------- Setter
	/**
	 * Setter vorname
	 * 
	 * @param vorname
	 *          Vorname des Studenten
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Setter nachname
	 * 
	 * @param nachname
	 *          Nachname des Studenten
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Setter pruefungsleistungsListe
	 * 
	 * @param pruefungsleistungsListe
	 *          Liste aller Prüfungen
	 */
	public void setPruefungsleistungsListe(
	    ArrayList<Pruefungsleistung> pruefungsleistungsListe) {
		this.pruefungsleistungsListe = pruefungsleistungsListe;
	}

	// ----------------------------------------------------------------- Overrides
	@Override
	public int compareTo(Student student) {
		if (student != null) {
			if (matrikelnummer < student.getMatrikelnummer()) {
				return -1;
			} else if (matrikelnummer == student.getMatrikelnummer()) {
				return 0;
			} else if (matrikelnummer > student.getMatrikelnummer()) {
				return 1;
			}
		}
		return -1;
	}

}
// ------------------------------------------------------------------------- EOF
