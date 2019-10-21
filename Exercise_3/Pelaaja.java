public class Pelaaja {

 public static final int PUOLUSTAJA = 0;
 public static final int HYOKKAAJA = 1;
 public static final int MAALIVAHTI = 2;
 
 protected String nimi;
 protected int pelinumero;
 protected int pelipaikka;
 
 public Pelaaja(String nimi, int pelinumero, int pelipaikka) {
  this.nimi = nimi;
  this.pelinumero = pelinumero;
  this.pelipaikka = pelipaikka;
 }
 
 public String toString() {
  return "Pelaaja [nimi = " + nimi + ", pelinumero = " + pelinumero
    + ", pelipaikka = " + pelipaikka + "]";
 }

 public int getPelipaikka(){
   return pelipaikka;
 }
 
}

class Jalkapallopelaaja extends Pelaaja implements Comparable<Jalkapallopelaaja>{
  
  public static final int VASEN = 0;
  public static final int OIKEA = 1;
  
  private int jalkaisuus;
  private int viikkopalkka;
  
  public Jalkapallopelaaja(String nimi, int pelinumero, int pelipaikka, int jalkaisuus, int viikkopalkka) {
    super(nimi, pelinumero, pelipaikka);
    this.jalkaisuus = jalkaisuus;
    this.viikkopalkka = viikkopalkka;
  }

 public int getJalkaisuus(){
   return jalkaisuus;
 }

 public int getViikkopalkka(){
   return viikkopalkka;
 }

 public void setJalkaisuus(int jalkaisuus){
   this.jalkaisuus = jalkaisuus;
 }

 public void setViikkopalkka(int viikkopalkka){
   this.viikkopalkka = viikkopalkka;
 }
  
  public String toString() {
  return "Jalkapallopelaaja [nimi = " + super.nimi + ", pelinumero = " + super.pelinumero
    + ", pelipaikka = " + super.pelipaikka + ", jalkaisuus = " + jalkaisuus + ", viikkopalkka = " +  viikkopalkka + "]";
 }
  
  public int compareTo(Jalkapallopelaaja jp){
    if ( viikkopalkka < jp.getViikkopalkka() ){
      return -1;
    }
    else if ( viikkopalkka > jp.getViikkopalkka() ){
      return 1;
    }
    return 0;
  }
  
  
}