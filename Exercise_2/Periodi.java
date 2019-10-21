import java.util.ArrayList;

public class Periodi{
  
  protected ArrayList<Kurssi> kurssit = new ArrayList<Kurssi>();
  
  
  // KONSTRUKTORI
  public Periodi(){  }
  
  public void lisaaKurssi(Kurssi k){
    kurssit.add(k);
  }
  
  public void poistaKurssi(Kurssi k){
    kurssit.remove(k);
  }
  
  public void lisaaHenkiloKurssille(Kurssi k, Henkilo h){
    k.lisaaHenkilo(h);
  }
  
  public void poistaHenkiloKurssilta(Kurssi k, Henkilo h){
    k.poistaHenkilo(h);
  }
 
  public void lisaaOpiskelijaKurssille(Kurssi k, Opiskelija o){
    k.poistaHenkilo(o);
  }
  
  public void lisaaOpettajaKurssille(Kurssi k, Opettaja o){
    k.poistaHenkilo(o);
  }
  
  public ArrayList<Opiskelija> annaOpiskelijat(Kurssi k){
    ArrayList<Opiskelija> lista = new ArrayList<Opiskelija>();
    for ( Henkilo h : k.annaOsallistujat() ){
      if (h instanceof Opiskelija){
        Opiskelija o = (Opiskelija)h;
        lista.add(o);
      }
    }
    return lista;
  }
  
  public ArrayList<Opettaja> annaOpettajat(Kurssi k){
    ArrayList<Opettaja> lista = new ArrayList<Opettaja>();
    for ( Henkilo h : k.annaOsallistujat() ){
      if (h instanceof Opettaja){
        Opettaja o = (Opettaja)h;
        lista.add(o);
      }
    }
    return lista;
  }
  
  
  
}