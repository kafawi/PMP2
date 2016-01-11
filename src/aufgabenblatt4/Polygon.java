package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Polygon extends Observable {

  /**
   * Liste aller Punkte (Ecken) des Polygons.
   */
  private List<Punkt> punkte;

  /**
   * KONSTRUKTOR
   */
  public Polygon() {
    punkte = new ArrayList<Punkt>();
  }

  /**
   * Ein Punkt wird angehaengt.
   * 
   * @param punkt
   *          Ein Punkt der angehaengt werde soll
   */
  public void hinzufuegen(Punkt punkt) {
    punkte.add(punkt);
    setChanged();
    notifyObservers(punkt);
  }

  /**
   * Ein bestehender Punkt wird geaendert.
   * 
   * @param index
   *          Stelle an der der Punkt geändert werden soll
   * @param punkt
   *          Punkt mit neuen Koordinaten
   * @throws IndexOutOfBoundsException
   *           if the index is out of range (index < 0 || index >= size())
   */
  public void punktAendern(int index, Punkt punkt)
      throws IndexOutOfBoundsException {
    punkte.get(index).setX(punkt.getX());
    punkte.get(index).setY(punkt.getY());
    // alternativ, waere aber kein aendern sondern ersetzten
    // punkte.set(index, punkt);
    setChanged();
    notifyObservers(punkt);
  }

  @Override
  public String toString() {
    String anzPunkte = Integer.toString(punkte.size());
    if(punkte.size() > 1 || punkte.size() == 0) {
      anzPunkte += " Punkten";
    } else {
      anzPunkte += " Punkt";
    }
    return "Polygon w/ " + anzPunkte;
  }
}
