/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2 ("Streams")
 */

package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TestKlasse für die XStreammethode bearbeite().
 * @author Alexander Mendel und Karl-Fabian Witte
 *
 */
public class XStreamTest {

  @Test
  public void testBearbeite() {
    String[] text1 = { "Eingabe ", " Äußeres    ", null, " Strassen-Feger",
        "  ein Haus" };
    String[] erwartetArray = { "EINGABE", "AEUSSERE", "STRASSEN", "EIN HAUS" };
    List<String> erwartet = Arrays.asList(erwartetArray);

    assertTrue(erwartet.equals(XStream.bearbeite(text1)));
  }

  @Test
  public void testBearbeiteNull() {
    String[] text1 = { null };
    String[] erwartetArray = {};
    List<String> erwartet = Arrays.asList(erwartetArray);

    assertTrue(erwartet.equals(XStream.bearbeite(text1)));
  }

  @Test
  public void testBearbeitSkalar() {
    String text1 = "geschmeidig";
    String[] erwartetArray = { "GESCHMEI" };
    List<String> erwartet = Arrays.asList(erwartetArray);
    assertTrue(erwartet.equals(XStream.bearbeite(text1)));
  }
}
