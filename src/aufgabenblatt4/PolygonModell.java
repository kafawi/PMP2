package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 * Diese Klasse Verwaltet die Polygone
 * @author Alex und Kalle
 *
 */
public class PolygonModell extends Observable implements Observer{
  //--------------------------------------------------------------- VARIABLEN -
  /**
   * Liste aller Fertigen Polygone
   */
  private List<Polygon> polygone;
  
  /**
   * aktuelles zu bearbeitendes Polygon
   */
  private Polygon aktuellesPolygon;
  // ------------------------------------------------------- STANDART METHODEN -
  /**
   * KONSTRUKTOR
   */
  public PolygonModell(){
    polygone = new ArrayList<Polygon>();
    polygone.add(new Polygon());
    aktuellesPolygon = new Polygon();
    aktuellesPolygon.addObserver(this);
  }
  
  //getter für polygon
  /**
   * GETTER 
   * @return
   */
  public Polygon getAktuellesPolygon() {
    return aktuellesPolygon;
  }
  //getter für liste polygoe
  public List<Polygon> getPolygone() {
    return polygone;
  }
  
  /**
   * 
   */
  @Override
  public String toString(){
    return "Anzahl von Polygonen in der Liste " + polygone.size() 
        + ", aktuelles " + aktuellesPolygon.toString();
  }
  
  // --------------------------------------------------------- ANDERE METHODEN -
  /**
   * Polygon wird konsertviert, wenn es fertig ist.
   */
  public void beendeBearbeitung(){
    polygone.add(aktuellesPolygon);
    aktuellesPolygon = new Polygon();
    aktuellesPolygon.addObserver(this);
    setChanged();
    notifyObservers();  
  }
  
  @Override
  public void update(Observable obs, Object punkt) {
    System.out.println("Punkt " + punkt + "wurde hinzugefuegt.");
    setChanged();
    notifyObservers(punkt);
  }
}
