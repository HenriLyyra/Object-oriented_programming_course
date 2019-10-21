import java.util.ArrayList;

public class Joukkue {
 
 protected ArrayList<Pelaaja> pelaajat;
 protected String nimi;
 
 public Joukkue(String nimi){
  this.nimi = nimi;
  pelaajat = new ArrayList<Pelaaja>();
 }
 
 public void lisaaPelaaja(Pelaaja p){
  pelaajat.add(p);
 }
 
 public boolean poistaPelaaja(Pelaaja p){
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
     System.out.println("TULOSTETAAN JOUKKUEEN PELAAJATIEDOT");
     for (Pelaaja p : pelaajat){
       System.out.println(p.toString());
     }
     System.out.println("- - - - - - - - - - - - - - - - - -");
   }
 
}

class Jalkapallojoukkue extends Joukkue{
  //private Stadion kotistadioni;
  private String kotistadioni;
  
  public Jalkapallojoukkue(String nimi, /*Stadion kotistadioni */ String kotistadioni){
    super(nimi);
    this.kotistadioni = kotistadioni;
  }
  
   public void lisaaPelaaja(Pelaaja p){
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
     for (Pelaaja p : super.pelaajat){
       if (p.getPelipaikka() == 0 || p.getPelipaikka() == 1){
         summa += 1;
       }
     }
     return summa;
   }
   
   /*public void tulostaJoukkue(){
     System.out.println("- - - - - - - - - - - - - - - - - -");
     System.out.println("TULOSTETAAN JOUKKUEEN PELAAJATIEDOT");
     for (Pelaaja p : super.pelaajat){
       System.out.println(p.toString());
     }
     System.out.println("- - - - - - - - - - - - - - - - - -");
   }*/
   
}