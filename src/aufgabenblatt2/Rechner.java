/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 1 ("Lamdas")
 */
package aufgabenblatt2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Diese Klasse oragnisiert unsere Grundrechenarten zweier Doublewerte. 
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 */
public class Rechner {
  //------------------------------------------------------------------ VARIABLE
  /**
   * Vokabelheft für die Grundrechenarten 
   */
  private Map<Operation, BinaryOperator<Double>> OperationMap;

  
  //--------------------------------------------------------------- KONSTRUKTOR
  /**
   * KONSTRUKTOR
   */
  public Rechner() {
    OperationMap = new HashMap<Operation, BinaryOperator<Double>>();

    OperationMap.put(Operation.PLUS,  (x, y) -> x + y);
    OperationMap.put(Operation.MINUS, (x, y) -> x - y);
    OperationMap.put(Operation.MAL,   (x, y) -> x * y);
    OperationMap.put(Operation.DURCH, (x, y) -> x / y);
  }
  
  //------------------------------------------------------------------- METHODE
  /**
   * Das Ergebnis zweier miteinander operierter Zahlen wird zurückgegeben.
   * 
   * @param operation Gewünschte Grundrechenoperation.
   * @param x erste Zahl, die mathematisch mit der zweiten Zahl operiert wird.
   * @param y zweite Zahl, die mathematisch mit der ersten Zahl operiert wird.
   * @return Ergebnis der miteinander operierter Zahlen.
   */
  public double berechne(Operation operation, double x, double y) {
    BinaryOperator<Double> operator = OperationMap.get(operation);
    return operator.apply(x, y);
  }
}
