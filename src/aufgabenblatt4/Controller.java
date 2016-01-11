package aufgabenblatt4;


import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
//import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Controller extends Application{
  
  PolygonDarstellung darstellung;
  PolygonSkripting skripting;
  PolygonModell modell;
  
  /**
   * KONSTRUKTOR
   */
  public Controller(){
    modell = new PolygonModell();
    skripting = new PolygonSkripting(modell);
    
    // Tabelle
    ObservableList<Polygon> polygone = 
        FXCollections.<Polygon> observableArrayList();
    polygone.addAll(modell.getPolygone());
    TableView<Polygon> polyTab = new TableView<Polygon>();
    TableColumn<Polygon, String> columnName = new TableColumn<>("Polygon");
    columnName.setCellValueFactory(new Callback<CellDataFeatures<Polygon,String>, ObservableValue<String>>() {
      public ObservableValue<String> call(CellDataFeatures<Polygon,String> p) {
          return new ReadOnlyObjectWrapper(p.getValue().toString()); //returns the Person instance for a particular TableView row
          //return new ReadOnlyObjectWrapper(p.getValue().toString());
      }
    });
    polyTab.getColumns().add(columnName);
    polyTab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
    
    darstellung = new PolygonDarstellung(modell);
    
    //command = new Command(model);
    Button eingabe = new Button("Eingabe");
    Button setzenNeu = new Button("Setzen/Neu");
    
    TextField textField = new TextField();
    VBox vBox = new VBox(10);
    //topCorner = new HBox(new Label("Path Drawing"));
    vBox.getChildren().addAll(setzenNeu, polyTab,textField,eingabe);
    //view.setTop(topCorner);
    darstellung.setRight(vBox);
    
    PolygonDarstellung.setMargin(vBox, new Insets(12,12,12,12));    
    
    
    setzenNeu.setOnAction(e->darstellung.addPolygon());
    eingabe.setOnAction(e->skripting.werteTextAus(textField.getText()));
  }
  

  public static void main(String []args){
    Application.launch(args);
  }
  @Override
  public void start(Stage stage) throws Exception {
    
    
    
    Scene scene = new Scene(darstellung);
    stage.setScene(scene);
    stage.setTitle("Praktikum 4");
    stage.show();
    
  }

}
