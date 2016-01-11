package aufgabenblatt4;

import java.util.Observable;
import java.util.Observer;

//import javafx.scene.control.Label;
//import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class PolygonDarstellung extends BorderPane implements Observer{
  
  private final PolygonModell modell;
  
  private Punkt altPunkt;
  
  private Path aktuellerPath;
  
  /**
   * KONSTRUKTOR
   */
  public PolygonDarstellung(PolygonModell modell){
    
    this.modell = modell;
    modell.addObserver(this);
    aktuellerPath = null;
    altPunkt = null;
    this.setPrefSize(800.0, 500.0);
    
    // Das zeichenen mit der Maus
    setOnMouseClicked(e->modell.getAktuellesPolygon().hinzufuegen(
        new Punkt(e.getX(),e.getY()))
      );
    
  }
  
  @Override
  public void update(Observable obs, Object o) {
    // TODO Auto-generated method stub
    
    if(o instanceof Punkt){
      Punkt neuPunkt = (Punkt) o;
      if(altPunkt == null){
        aktuellerPath = new Path();
        this.getChildren().add(aktuellerPath);
        aktuellerPath.setStroke(Color.RED);
        aktuellerPath.getElements().add(new MoveTo(neuPunkt.getX(), neuPunkt.getY()));
      }
      else
      {
        aktuellerPath.getElements().add(new LineTo(neuPunkt.getX(), neuPunkt.getY()));  
      }
      altPunkt = neuPunkt;
      Ellipse ellispe = new Ellipse( neuPunkt.getX(), neuPunkt.getY(), 2.0, 2.0);
      //ellispe.setFill(Color.RED);
      this.getChildren().add(ellispe);
    
    } else {
    aktuellerPath.setStroke(Color.BLUE);
    //listView.getItems().add(signal);
    altPunkt = null;
    
    }
    
  }

  public void addPolygon() {
    System.out.println("Polygon fertig!");
    modell.beendeBearbeitung();
    for(Polygon p : modell.getPolygone()){
      System.out.println(p);
    }
    
  }
  
  
}
