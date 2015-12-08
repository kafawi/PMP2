/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2 ("Streams")
 */

package aufgabenblatt2;

import java.util.stream.*;

import java.util.List;

/**
 * Diese Klasse enhält eine mehtode zum bearbeiten von Strings.
 * 
 * @author Alexander Mendel und Karl-Fabian Witte
 *
 */
public class XStream {
  
  /**
   * Diese Methode bearbeitet mit Hilfe von Streams Benutzereingaben.
   * Alle NULLs werden entfernt.
   * Leerzeichen am anfang und am Ende werden entfernt.
   * Alle Chars zu Großbuchstaben umwandeln.
   * Umlaute und ß wird umgewandelt in Kreuzworträtzelkonformation
   * Maximallänge wird auf 8 festgelegt.
   * @param text Menge von Benutzereingaben
   * @return Liste von Bearbeiteten Zeichenketten
   */
  public static List<String> bearbeite(String...text ){
    
    // Erstellen
    Stream<String> strStream = Stream.of(text);
    
    return strStream
        // Entfernen von null-Eingaben
        .filter(str->str!=null) 
        // Abschneiden der Leerzeichen am Anfang und Ende
        .map(str->str.trim()) 
        // Konvertierung von Klein- zu Großbuchstaben
        .map(str->str.toUpperCase()) 
        // Ersetzen Ä→AE, Ö→OE, Ü→UE, ß→SS
        .map(str->str.replace("ß","SS").replace("Ä","AE").replace("Ö","OE").replace("Ü","UE"))
        // Kürzen der Strings auf maximal 8 Zeichen
        .map(str->(str.length() > 8)? str.substring(0, 8): str)        
        // Terminieren
        .collect(Collectors.toList());
  }

}
