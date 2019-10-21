import java.util.ArrayList;
import java.util.Collections;

// JOUKKUE
public class Jalkapallojoukkue {
  
  private ArrayList<Jalkapallopelaaja> pelaajat;
  private String nimi;
  private int budjetti;
  private String kotistadioni;
  
  static final int PALKKAKATTO = 400;
  
  
  public Jalkapallojoukkue(String nimi, int budjetti, String kotistadioni){
    this.nimi = nimi;
    if (budjetti <= PALKKAKATTO*22){
      this.budjetti = budjetti;
    }
    else{
      this.budjetti = PALKKAKATTO*22;
      System.out.println("Budjetti ei voi ylittää palkkakaton asettamaa määrää, eli 22x" + PALKKAKATTO + ". Budjetiksi asetetaan " + PALKKAKATTO*22 + "." );
    }
    pelaajat = new ArrayList<Jalkapallopelaaja>();
    this.kotistadioni = kotistadioni;
  }
  
  // poistaa pelaajan p ensimmäisen esiintymän joukkueesta
  public boolean poistaPelaaja(Jalkapallopelaaja p){
    return pelaajat.remove(p);
  }
  
  // laskee joukkueen pelaajien yhteispalkkakulut
  public int annaPalkkamenot(){
    int tulos = 0;
    for (Jalkapallopelaaja p : pelaajat){
      tulos += p.getViikkopalkka();
    }
    return tulos;
  }
  
  public void lisaaPelaaja(Jalkapallopelaaja p) throws BudjettiYlitetty{
    if ( this.annaPalkkamenot() <= PALKKAKATTO*22 ){
      if ( p.getPelipaikka() == 2 && this.maalivahteja() < 2 ){
        pelaajat.add(p);
      }
      else if ( (p.getPelipaikka() == 0 || p.getPelipaikka() == 1) && this.kenttapelaajia() < 20 ){
        pelaajat.add(p);
      }
    }
    else{
      throw new BudjettiYlitetty();
    }
  }
  
  // palauttaa jalkapallojoukkueessa olevien maalivahtien lukumäärän
  public int maalivahteja(){
    int summa = 0;
    for (Jalkapallopelaaja p : pelaajat){
      if (p.getPelipaikka() == 2){
        summa += 1;
      }
    }
    return summa;
  }
  
  // palauttaa jalkapallojoukkueessa olevien kenttäpelaajien lukumäärän
  public int kenttapelaajia(){
    int summa = 0;
    for (Jalkapallopelaaja p : pelaajat){
      if (p.getPelipaikka() == 0 || p.getPelipaikka() == 1){
        summa += 1;
      }
    }
    return summa;
  }
  
  // järjestää joukkueen pelaajat palkkajärjestykseen
  public void lajitteleJoukkue(){
    Collections.sort(pelaajat);
  }
  
  // palauttaa joukkueen pelaajien tiedot String-muodossa
  public String toString(){
    String joukkue = "Pelaajia joukkueessa "+nimi+":\n";
    for(int i=0; i<pelaajat.size(); i++){
      joukkue += pelaajat.get(i).toString()+"\n";
    }
    return joukkue;
  }
  
  // tulostaa joukkueen pelaajien tiedot
  public void tulostaJoukkue(){
    System.out.println("- - - - - - - - - - - - - - - - - -");
    System.out.println("TULOSTETAAN JOUKKUEEN PELAAJATIEDOT:");
    for (Pelaaja p : pelaajat){
      System.out.println(p.toString());
    }
    System.out.println("- - - - - - - - - - - - - - - - - -");
  }
  
  // tulostaa joukkueen palkkajärjestyksessä
  public void tulostaJoukkueJarjestyksessa() throws BudjettiYlitetty{
    Jalkapallojoukkue temp = new Jalkapallojoukkue("",PALKKAKATTO,"");
    for (Jalkapallopelaaja p : pelaajat){
      temp.lisaaPelaaja(p);
    }
    temp.lajitteleJoukkue();
    temp.tulostaJoukkue();
  }
  
  // tulostaa joukkueen n:n kalleimman pelaajan tiedot
  public void tulostaKalleimpia(int n) throws BudjettiYlitetty{
    // luodaan väliaikainen joukkue, joka on alkuperäisen kopio palkkajärjestyksessä
    Jalkapallojoukkue temp = new Jalkapallojoukkue("",PALKKAKATTO,"");
    for (Jalkapallopelaaja p : pelaajat){
      temp.lisaaPelaaja(p);
    }
    temp.lajitteleJoukkue();
    System.out.println("- - - - - - - - - - - - - - - - - -");
    System.out.println("TULOSTETAAN " + n + ":N KALLEIMMAN PELAAJAN TIEDOT:");
    for (int i = ( temp.pelaajat ).size() - 1 ; i >= ( temp.pelaajat ).size() - n;  i-- ){
      System.out.println( ( ( temp.pelaajat ).get(i) ).toString());
    }
    System.out.println("- - - - - - - - - - - - - - - - - -");
  }
  
}

class BudjettiYlitetty extends Exception{
  
  public BudjettiYlitetty(String viesti){
    super(viesti);
  }
  
  public BudjettiYlitetty(){
    super();
  }
  
}
