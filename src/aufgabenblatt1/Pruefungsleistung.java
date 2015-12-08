/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 2 ("Wiederholung")
 */

package aufgabenblatt1;

/**
 * Erbrachte Leistung in einem Modul.
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 */
public class Pruefungsleistung {
  
  //----------------------------------------------------------------- Variablen
  /**
   * Name des Moduls
   */
  private String modulName;
  
  /**
   * erbrachte Leistung in der Modulprüfung
   * 
   * Wenn die Note Negativ (FEHL_NOTE) ist, bedeutet, sie ist nicht gesetzt.
   * Für jede Note muss auch ein Name existieren. 
   * Vorsicht: 
   * falls der Name geändert auf Empty oder null, erlischt auch die Note.
   */
  private double note;
  
  //---------------------------------------------------------------- Konstanten
  /**
   * Fehlwert für note.
   */
  private static final double FEHL_NOTE=-1.;
  
  //--------------------------------------------------------------- Konstruktor 
  /**
   *  Konstruktor
   * 
   * @param modulName Name des Moduls
   * @param note erbrachte Leistung in der Modulprüfung
   */
  public Pruefungsleistung(String modulName, double note){
    if(modulName.isEmpty() || modulName == null){
      this.note = FEHL_NOTE;
    }else{
      this.modulName = modulName;
      this.note = note;
    }
  }
  
  //-------------------------------------------------------------------- Setter  
  /**
   * Setter modulName
   * 
   * @param modulName Name des Moduls
   */
  public void setModulName(String modulName){
    this.modulName = modulName;
    if(modulName.isEmpty() || modulName == null){
      this.note = FEHL_NOTE;
    }
  }
  
  /**
   * Setter Note
   * 
   * @param erbrachte Leistung in der Modulprüfung
   */
  public void setNote(double note){
    if(modulName.isEmpty() || modulName == null){
      this.note = FEHL_NOTE;
    }else{
    this.note = note;
    }
  }
  
  //-------------------------------------------------------------------- Getter
  /**
   * Getter ModuleName
   * 
   * @return Name des Moduls
   */
  public String getModulName(){
    return modulName;
  }
  
  /**
   * Getter Note
   * 
   * @return erbrachte Leistung in der Modulprüfung
   */
  public double getNote(){
    return note;
  }
  
}
//------------------------------------------------------------------------- EOF
