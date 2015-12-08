/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 2 ("Wiederholung")
 */

package aufgabenblatt1;

import java.util.Comparator;

/**
 * Vergleicht die Studenten über die Namen
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 */
public class StudentComparator implements Comparator<Student> {

	// ------------------------------------------------------------------ Override
	@Override
	public int compare(Student student1, Student student2){
		if(student1 == null || student2 == null){
			throw new IllegalArgumentException();
		}
		
		int compareResult;

		compareResult = student1.getNachname().compareToIgnoreCase(
		    student2.getNachname());

		// wenn nachname gleich sind, vergleiche Vornamen
		if (compareResult == 0) {
			compareResult = student1.getVorname().compareToIgnoreCase(
			    student2.getVorname());
		}
		return compareResult;
	}

}
// ------------------------------------------------------------------------- EOF