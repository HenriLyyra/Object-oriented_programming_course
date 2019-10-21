import java.util.ArrayList;

public class Lukuvuosi{
  
  protected ArrayList<Periodi> periodit = new ArrayList<Periodi>();
  private int vuosi;
  
  
  // KONSTRUKTORI
  public Lukuvuosi(int vuosi){ 
    this.vuosi = vuosi;
  }
  
  public void lisaaPeriodi(Periodi p){
    if (periodit.size() < 6){
      periodit.add(p);
    }
  }
  
  public void poistaPeriodi(Periodi p){
    periodit.remove(p);
  }
  
  public Periodi annaPeriodi(int i){
    return periodit.get(i);
  }
  
}