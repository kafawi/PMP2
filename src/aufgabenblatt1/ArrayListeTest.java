/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 4 ("Generics")
 */

package aufgabenblatt1;


import static org.junit.Assert.*;

import org.junit.Test;


/**
 * TestKlasse zum Testen der ArrayListe<T>
 * 
 * Es wird nut mir dem Typ T = Integer gearbeitet.
 * 
 * @author Alexander Mendel Und Karl-Fabian Witte
 *
 */

public class ArrayListeTest {
  
  @Test
  public void testHinzufuegen(){
    ArrayListe<Integer> test = new ArrayListe<Integer>();
    test.hinzufuegen(new Integer(2));
    assertEquals(1, test.getAnzahlElemente());
    test.hinzufuegen(new Integer(1));
    assertEquals(2, test.getAnzahlElemente());
    
    // ist da was drin?
    assertEquals(1, test.get(1).intValue());
  }

  @Test
  public void testEntfernen(){
    ArrayListe<Integer> test = new ArrayListe<Integer>();
    Integer zahl1 = 6;
    Integer zahl2 = 7;
    test.hinzufuegen(9);
    test.hinzufuegen(zahl1);
    test.hinzufuegen(1);
    test.hinzufuegen(zahl2);
    assertEquals(4, test.getAnzahlElemente());
    test.entfernen(zahl1);
    assertEquals(3, test.getAnzahlElemente());
    test.entfernen(zahl2);
    assertEquals(2, test.getAnzahlElemente());  
  }

  @Test
  public void testEntfernenElementAnIndex(){
    ArrayListe<Integer> test = new ArrayListe<Integer>();
    test.hinzufuegen(0);
    test.hinzufuegen(1);
    test.hinzufuegen(2);
    assertEquals(3, test.getAnzahlElemente());
    assertEquals(1, test.get(1).intValue());
    test.entferneElementAnIndex(1);
    assertEquals(2, test.getAnzahlElemente());
    assertEquals(2, test.get(1).intValue());
  }

  @Test
  public void testGet(){
    ArrayListe<Integer> test = new ArrayListe<Integer>();
    test.hinzufuegen(1);
    assertEquals(1, test.get(0).intValue());
  }

  @Test
  public void testGetAnzahlElemente(){
    ArrayListe<Integer> test = new ArrayListe<Integer>();
    for(int i = 0; i < 100; i++){
      test.hinzufuegen(i);
    }
    assertEquals(100, test.getAnzahlElemente());
  }
  
  @Test
  public void testGetKleinstesElement(){
    ArrayListe<Integer> test = new ArrayListe<Integer>();
    test.hinzufuegen(999);
    test.hinzufuegen(666);
    test.hinzufuegen(-42);
    assertEquals((Integer)(-42), test.getKleinstesElement());
    /* // String
    ArrayListe<String> test2 = 
        new ArrayListe<String>();
    test2.hinzufuegen("Bier");
    test2.hinzufuegen("Bier");
    test2.hinzufuegen("und noch mehr Bier");
    test2.hinzufuegen("fish'n'chips");
    test2.hinzufuegen("und Bier");
    assertEquals("Bier", test2.getKleinstesElement());
    */
  }

  @Test
  public void testSumme(){
    ArrayListe<Integer> test = new ArrayListe<Integer>();
    test.hinzufuegen(10);
    test.hinzufuegen(-5);
    test.hinzufuegen(4);
    test.hinzufuegen(3);
    assertEquals(12, ArrayListe.summe(test));
    System.out.println(test);
  }
  
   @Test
   public void testIsNumber(){
     ArrayListe<Integer> test1 = new ArrayListe<Integer>();
     assertTrue(!Pruefung.isNumber(test1));
     test1.hinzufuegen(12);
     assertTrue(Pruefung.isNumber(test1));
     ArrayListe<String> test2 = 
         new ArrayListe<String>();
     test2.hinzufuegen("Bier");
     test2.hinzufuegen("Bier");
     test2.hinzufuegen("und noch mehr Bier");
     test2.hinzufuegen("fish'n'chips");
     test2.hinzufuegen("und Bier");
     assertTrue(!Pruefung.isNumber(test2));
   }
}
