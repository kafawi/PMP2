package aufgabenblatt4;

import java.util.regex.*;

public class PolygonSkripting {

  private PolygonModell modell;
  private static final String BEWEGE = "^bewege\\s->\\s\\d+.?\\d*,\\d+.?\\d*";
  Pattern               pattern;
  Matcher               matcher;

  public PolygonSkripting(PolygonModell modell) {
    this.modell = modell;
    pattern = Pattern.compile(BEWEGE);
  }

  public void werteTextAus(String text){
    matcher = pattern.matcher(text);
    if(matcher.matches())
    {
      modell.getAktuellesPolygon().hinzufuegen(getXY(text));
    }
    else 
    {
      System.out.println("Versuchen Sie es noch einmal so: bewege -> <x>,<y>");
    }
  }
  
  private Punkt getXY(String text){
    String split[] =  text.split("[^0-9.]");
    
    // entferne die Nulls 
    // (umständlich aber dafür eine Liste zu erstellen ist übertrieben)
    double xy[] = new double[2];
    int xyIndex = 0; 
    for(int i = 0;  i < split.length; i++){
      if(!split[i].isEmpty() && split[i].compareTo(".") != 0)
      {
        xy[xyIndex++] = Double.parseDouble(split[i]);
      }
    }
    return new Punkt(xy[0],xy[1]);
  }
}
