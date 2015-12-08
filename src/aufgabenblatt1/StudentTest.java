package aufgabenblatt1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Testklasse für die Studentenaufgabe.
 * 
 * @author abx932
 *
 */
public class StudentTest {
	Student stu1 = new Student("ernst", "august");
	Student stu2 = new Student("Ernesto", "august");
	Student stu3 = new Student("Bruno", "Bart");
	Student stu4 = new Student("Niels", "Ägebrecht");
	ArrayList<Pruefungsleistung> stu1List = new ArrayList<Pruefungsleistung>();

	@Test
	public void testCompareTo() {
		// gleicher Nachname
		assertEquals(-1, stu1.compareTo(stu2));
		assertEquals(1, stu2.compareTo(stu1));
		assertEquals(0, stu3.compareTo(stu3));
		assertEquals(-1, stu4.compareTo(null));
	}

	@Test
	public void testStudentComparator() {
		StudentComparator comparator = new StudentComparator();
		assertTrue(0 < comparator.compare(stu1, stu2)); // Ernst > Ernesto
		assertTrue(0 < comparator.compare(stu4, stu1)); // Ä > B
		assertTrue(0 > comparator.compare(stu2, stu4)); // Ä > A
		assertTrue(0 == comparator.compare(stu3, stu3)); // Bruno == Bruno
		try {
			comparator.compare(stu3, null);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (IllegalArgumentException e) {
			// everthing all rigth
		}
	}

	@Test
	public void testPruefungsleitung() {
		stu1List.add(new Pruefungsleistung("Informatik", 3.));
		assertEquals("Informatik", stu1List.get(0).getModulName());
		stu1.setPruefungsleistungsListe(stu1List);
		double testNote = stu1.getPruefungsleistungsListe().get(0).getNote();
		assertTrue(Math.abs(testNote - 3.) < 10e-5);
		
		// Test mit den Fehl_Noten.
		stu1List.get(0).setModulName("");
		testNote = stu1.getPruefungsleistungsListe().get(0).getNote();
		assertTrue(Math.abs(testNote - (-1.0)) < 10e-5);
		stu1List.get(0).setNote(9000.0);
		testNote = stu1.getPruefungsleistungsListe().get(0).getNote();
		assertTrue(Math.abs(testNote - (-1.0)) < 10e-5);
	}
}
