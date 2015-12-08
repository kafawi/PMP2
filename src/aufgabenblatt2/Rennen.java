/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 3 ("Threads")
 */

package aufgabenblatt2;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Hier findet das Rennen statt
 * @author Alexander Mendel und Karl-Fabian Witte
 *
 */
public class Rennen {
  /**
   * Main
   * @param args
   */
  public static void main(String[] args){
    
    double rennstrecke = 100;
    List<Rennauto> autos = new ArrayList<Rennauto>();
 
    // erstelle autoinstanzen
    autos.add(new Rennauto(10.0, rennstrecke));
    autos.add(new Rennauto(10.0, rennstrecke));
    autos.add(new Rennauto(10.0, rennstrecke));
    
    Rennabbruch abbruch = new Rennabbruch(autos);
    System.out.println("START!");
    abbruch.start();
    // Start
    //Hier und bei allen anderen for-schleifen könnte man for each nehmen
    //// ForEach Schleife
    //for( int k: array )
    //dann ist das immer um das .get(i) kürzer
    for(int i=0; i < autos.size(); i++){
      autos.get(i).start();
    }
    
    //Warten aufs ende
    for(int i=0; i < autos.size(); i++){
      try {
        autos.get(i).join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // Rennen geschafft
    System.err.println("FINISH!");
    // abbruchthread muss beendet werden.
    abbruch.interrupt();
    // Sortieren nach den Plätzen
    Collections.sort(autos);
    System.out.println("Ergebnis:");
    for(int i=0; i < autos.size(); i++){
      System.out.printf("Platz %d: " + autos.get(i).printErgebnis() + "\n", i+1);
    }
  }
}
