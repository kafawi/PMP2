/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 4 ("Generics")
 */

package aufgabenblatt1;

/**
 * Eine ContainerKlasse, um die Generics zu üben.
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 */
@SuppressWarnings("unchecked")
// Wenn Klasse die UpperBound verwedet:
 public class ArrayListe<T extends Comparable<T>> {
//public class ArrayListe<T> {
  //----------------------------------------------------------------- Variablen+
  
  /**
   * Anzahl der Elemente in der Liste
   */
  private int anzahlElemente;
  
  /**
   * Array, welches alle 
   */
  private Object[] elemente;
  
  //--------------------------------------------------------------- Konstruktor
  /**
   * Konstruktor leere Liste
   */
  public ArrayListe(){
    anzahlElemente=0;
    elemente=null;
  }
  
  //------------------------------------------------------------------ Methoden
  /**
   * Hängt an der Liste ein Element unten ran.
   * @param element anzuhängende Element.
   */
  public void hinzufuegen(T element){
    anzahlElemente++;
    Object[] elementeNeu = new Object[anzahlElemente];
    
    // flache Kopie da wir ja überschreiben wollen
    if(elemente!=null){
      System.arraycopy(elemente, 0, elementeNeu, 0, elemente.length);
    }
    // hänge neues element unten dran
    elementeNeu[ elementeNeu.length - 1 ]= element;
    
    elemente = elementeNeu;
  }
  
  /**
   * Holt ein Element aus der Liste.
   * 
   * @param index Stelle im Array, an der das gewünschte Element liegt
   * @return gewünschte Element
   * @throws IndexOutOfBoundsException
   */
  public T get(int index) throws IndexOutOfBoundsException{    
    if( elemente != null ){
      return (T)elemente[index];
    } 
    return null;
  }
  
  /**
   * Entfernt ein Element falls vorhanden aus der Liste.
   * @param elementWeg zu entfernende Element
   */
  public void entfernen(T elementWeg){
    if( elemente != null ){
      int index=anzahlElemente-1;
      for (index=anzahlElemente-1; index > 0; index-- ){    
        if ( elemente[index].equals(elementWeg) ){
          
          anzahlElemente--;
          // Wenn die Liste Leer ist, setze Array auf null
          if (anzahlElemente == 0){
            elemente = null;
            return;
          }
          
          //flache Kopie
          Object[] elementeNeu = new Object[anzahlElemente];
          // Vor elementWeg
          System.arraycopy(elemente, 0, elementeNeu, 0, index);
          // Hinter elementWeg
          System.arraycopy(elemente, index+1, elementeNeu, index,
              elemente.length - (index + 1) );
          elemente = elementeNeu;
          return;
        }
      }
    }
  }
  
  /**
   * Entfernt das Element an einer bestimmten Stelle.
   * @param indexWeg Stelle in der Liste, an der Das Element gelöscht wird.
   * @throws IndexOutOfBoundsException
   */
  public void entferneElementAnIndex(int indexWeg) 
      throws IndexOutOfBoundsException{
    
    if (elemente == null || indexWeg < 0 || indexWeg >= elemente.length){
      throw new IndexOutOfBoundsException(); 
    }
    
    anzahlElemente--;
    // Wenn die Liste Leer ist, setze Array auf null
    if (anzahlElemente == 0){
      elemente = null;
      return;
    }
    
    // flache Kopie
    Object[] elementeNeu = new Object[anzahlElemente];
    // Vor indexWeg
    System.arraycopy(elemente, 0, elementeNeu, 0, indexWeg);
    // Hinter indexWeg
    System.arraycopy(elemente, indexWeg+1, elementeNeu, indexWeg,
        elemente.length - (indexWeg + 1) );
    elemente = elementeNeu;
  }
  
  //-------------------------------------------------------- Getter und toSting
  /**
   * Getter anzahlElemente
   * @return Die Anzahl der Elemente, die im Array stehen.
   */
  public int getAnzahlElemente(){
    return anzahlElemente;
  }
  
  /**
   * toString
   * @return beschreibender text
   */
  public String toString(){
    String text = "";
    text += String.format("%d Elemente vom Typ ", anzahlElemente);
    text += get(0).getClass().getTypeName();
    
    return text;
  }
  
  
  
  //------------------------------------------------- Vergleich ohne Comparable
  /*
  /**
   * Gibt das kleinste Element aus der Liste wieder.
   * Dabei ist kleinste element hier der einfachhaltshalber weit gefasst.
   * Eigendlich müsse für die verscheidensten Typen ein Typcast und if-cond 
   * gesetzt werden, damit man das ohne comparable implementieren kann.
   * Comparable ist halt nunmal zum vergleichen da.
   * Deswegen dient der Hashcode, welcher gut funtioniert
   * @return kleinste Element der Liste
   */
  /*
  public T getKleinstesElement(){
    T kleinstesElement = null;  
    if( elemente != null ){
      int indexKlein = 0;
      for (int index = 0; index < anzahlElemente; index++ ){      	
        if( elemente[indexKlein].hashCode() > elemente[index].hashCode() ){
          indexKlein = index;
      	}
      }
      kleinstesElement = (T)elemente[indexKlein];
    }
    return kleinstesElement;     
  }     
  */  
  
  //--------------------------------------------------- UpperBounds in Methoden
  /**
   * Gibt das kleinste Element aus der Liste wieder.
   * Dafür wird eine Vergleichsmöglichkeit benötigt (Comparable).
   * @return kleinste Element der Liste
   */
  // Wenn Klasse die UpperBound verwedet:
  public T getKleinstesElement(){
  //public <T extends Comparable<T>> T getKleinestesElement(){
    T kleinstesElement = null;
    
    if( elemente != null ){
      int indexKlein = 0;
      for (int index = 0; index < anzahlElemente; index++){
        if (((T)elemente[indexKlein]).compareTo((T)elemente[index]) == 1){
          indexKlein = index;
        }
      }
      kleinstesElement = (T)elemente[indexKlein];
    }
    return kleinstesElement;
  }
  
  // ------------------------------------------------------------ Integer Summe
  /**
   * Summiert die Werte einer Liste von Ganzzahlen.
   * @param intListe Liste von Ganzzahlen
   * @return Summe aller Ganzzahlen der Liste
   */
  public static int summe(ArrayListe<Integer> intListe){
    int result = 0;
    for(int index = 0; index < intListe.getAnzahlElemente(); index++){
      result += intListe.get(index).intValue();
    }
    return result;
  }
 
}
