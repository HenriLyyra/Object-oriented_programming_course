import java.util.ArrayList;
import java.util.Collections;

// JOUKKUE
public class Joukkue {
 
 protected ArrayList<Jalkapallopelaaja> pelaajat;
 protected String nimi;
 
 public Joukkue(String nimi){
  this.nimi = nimi;
  pelaajat = new ArrayList<Jalkapallopelaaja>();
 }
 
 public void lisaaPelaaja(Jalkapallopelaaja p){
  pelaajat.add(p);
 }
 
 public boolean poistaPelaaja(Jalkapallopelaaja p){
  return pelaajat.remove(p);
 }
 
 public String toString(){
  String joukkue = "Pelaajia joukkueessa "+nimi+":\n";
  for(int i=0; i<pelaajat.size(); i++){
   joukkue += pelaajat.get(i).toString()+"\n";
  }
  return joukkue;
 }
 
 public void tulostaJoukkue(){
     System.out.println("- - - - - - - - - - - - - - - - - -");
     System.out.println("TULOSTETAAN JOUKKUEEN PELAAJATIEDOT:");
     for (Pelaaja p : pelaajat){
       System.out.println(p.toString());
     }
     System.out.println("- - - - - - - - - - - - - - - - - -");
   }
 
}

// JALKAPALLOJOUKKUE
class Jalkapallojoukkue extends Joukkue{
  //private Stadion kotistadioni;
  private String kotistadioni;
  
  public Jalkapallojoukkue(String nimi, /*Stadion kotistadioni */ String kotistadioni){
    super(nimi);
    this.kotistadioni = kotistadioni;
  }
  
   public void lisaaPelaaja(Jalkapallopelaaja p){
     if ( p.getPelipaikka() == 2 && this.maalivahteja() < 2 ){
       pelaajat.add(p);
     }
     else if ( (p.getPelipaikka() == 0 || p.getPelipaikka() == 1) && this.kenttapelaajia() < 20 ){
       pelaajat.add(p);
     }
 }
  
   // palauttaa jalkapallojoukkueessa olevien maalivahtien lukumäärän
   public int maalivahteja(){
     int summa = 0;
     for (Pelaaja p : super.pelaajat){
       if (p.getPelipaikka() == 2){
         summa += 1;
       }
     }
     return summa;
   }
  
   // palauttaa jalkapallojoukkueessa olevien kenttäpelaajien lukumäärän
   public int kenttapelaajia(){
     int summa = 0;
     for (Jalkapallopelaaja p : super.pelaajat){
       if (p.getPelipaikka() == 0 || p.getPelipaikka() == 1){
         summa += 1;
       }
     }
     return summa;
   }
   
   // järjestää joukkueen pelaajat palkkajärjestykseen
   public void lajitteleJoukkue(){
     Collections.sort(super.pelaajat);
   }
   
   // tulostaa joukkueen palkkajärjestyksessä
   public void tulostaJoukkueJarjestyksessa(){
     Jalkapallojoukkue temp = new Jalkapallojoukkue("","");
     for (Jalkapallopelaaja p : pelaajat){
       temp.lisaaPelaaja(p);
     }
     temp.lajitteleJoukkue();
     temp.tulostaJoukkue();
   }
   
   // tulostaa joukkueen n:n kalleimman pelaajan tiedot
   public void tulostaKalleimpia(int n){
     // luodaan väliaikainen joukkue, joka on alkuperäisen kopio palkkajärjestyksessä
     Jalkapallojoukkue temp = new Jalkapallojoukkue("","");
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