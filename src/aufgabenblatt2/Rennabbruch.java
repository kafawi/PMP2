/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 3 ("Threads")
 */

package aufgabenblatt2;

import java.util.List;
/**
 * Jede Sekunde soll geprüft werden, ob es zu einem 10% abbruch kommen soll.
 * Wenn ja , sollen alle RennautoThreads interruptet werden.
 * @author Alexander Mendel und Karl-Fabian Witte
 *
 */
public class Rennabbruch extends Thread {
  /**
   * Liste der Rennautos
   */
  private List<Rennauto> autoListe;
  
  //------------------------------------------ KONSTRUKTOR
  /**
   * Konstruktor
   * @param autoListe Liste der Rennautos
   */
  public Rennabbruch(List<Rennauto> autoListe){
    this.autoListe = autoListe;
  }
  
  
  @Override
  public void run(){
    while(!isInterrupted()){
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        interrupt();
      }
      if(Math.random() < 0.1){
        System.err.println("Rennen wurde abbgebrochen");
        for ( int i =0 ; i < autoListe.size(); i++ ){
          autoListe.get(i).interrupt();
        } 
        interrupt();
      } 
    }
  }
  
}
