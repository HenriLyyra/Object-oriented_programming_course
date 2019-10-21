import java.util.ArrayList;

public class Kurssi{
  
  private final String nimi;
  private final String aihe;
  
  private ArrayList<Henkilo> osallistujat = new ArrayList<Henkilo>();
  
  public Kurssi(String nimi, String aihe){
    this.nimi = nimi;
    this.aihe = aihe;
  }
  
  public void lisaaHenkilo(Henkilo h){
    osallistujat.add(h);
  }
  
  public void poistaHenkilo(Henkilo h){
    osallistujat.remove(h);
  }  
  
  public void poistaHenkilo(int i){
    osallistujat.remove(i);
  }
 
  public ArrayList<Henkilo> annaOsallistujat(){
    return osallistujat;
  }
  
}