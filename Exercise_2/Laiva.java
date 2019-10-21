public class Laiva {

 private static double SOLMUTKILOMETREINATUNNISSA = 1.852;
 
 private String nimi;
 private double pituus;
 private double syvays; 
 private double nopeus;
 
 /**
  * Laivan konstruktori.
  * @param nimi Laivan nimi
  * @param pituus Laivan pituus metreinä
  * @param syvays Laivan syväys metreinä
  * @param nopeus Laivan nopeus solmuina tunnissa
  */
 public Laiva(String nimi, double pituus, double syvays, double nopeus) {
  this.nimi = nimi;
  this.pituus = pituus;
  this.syvays = syvays;
  this.nopeus = nopeus;
 }
 
 /**
  * Laskee matkaan kuluvan ajan.
  * 
  * @param matka Kuljettava matka kilometreinä.
  * @return matkaan kuluva aika tunteina. Ääretön, 
  *    jos laiva seisoo tai matka on negatiivinen.
  */
 public double matkaanKuluvaAika(double matka){
  if(nopeus == 0.0 || matka < 0)
   return Double.POSITIVE_INFINITY;
  
  return matka/( Math.abs(nopeus)*SOLMUTKILOMETREINATUNNISSA );
 }

 public String getNimi() {
  return nimi;
 }

 public void setNimi(String nimi) {
  this.nimi = nimi;
 }

 //Huom, laivan pituuden muutosmetodi puuttuu. 
 //Laivan pituus harvoin muuttuu.
 
 public double getPituus() {
  return pituus;
 }

 public double getSyvays() {
  return syvays;
 }

 public void setSyvays(double syvays) {
  this.syvays = syvays;
 }

 public double getNopeus() {
  return nopeus;
 }

 public void setNopeus(double nopeus) {
  this.nopeus = nopeus;
 }
 
}

class Rahtilaiva extends Laiva{
  private final double kapasiteetti;
  private double rahti;
  
  /*
   * Ottaa argumentteina ensin Laiva:lle asetettavat attribuutit ja sen jälkeen Rahtilaivalle asetettavat (syötteen itseisarvoina).
   * 
   * Jos kapasiteetti ylittyy, ylijäävää määrää ei lisätä ja tulostetaan ilmoitus.
   * 
   * Laiva:n nopeus annetaan tapauksessa, jossa rahtia ei ole ja rahdin lisääminen muuttaa nopeutta.
   * 
   */
  public Rahtilaiva(String nimi, double pituus, double syvays, double nopeus, double kapasiteetti, double rahti){
    super(nimi, pituus, syvays, nopeus);
    this.kapasiteetti = Math.abs(kapasiteetti);
    if ( Math.abs(rahti) <= Math.abs(kapasiteetti) ){
      this.rahti = Math.abs(rahti);
    }
    else{
      this.rahti = Math.abs(kapasiteetti);
      System.out.println("Kapasiteetti täytetty. Kuormaamatta jäi " + ( Math.abs(rahti) - Math.abs(kapasiteetti) ) + " yksikköä.");
    }
    super.setNopeus( nopeus*(1 - rahti/kapasiteetti) );
  }
  
  /* poistetaan rahtia d yksikköä, jos d >= 0 ja rahtia riittää.
   * rahdin loppuessa tyhjennetään koko laiva ja tulostetaan ilmoitusviesti rahdin loppumisesta.
   * jos d < 0, tulostetaan ilmoitus, että negatiivistä ei poistettu.
   */
  public void poistaRahtia(double d){
    if( rahti == kapasiteetti ){
      super.setNopeus(0);
    }
    else{
      super.setNopeus( super.getNopeus()/(1 - rahti/kapasiteetti) );
    }
    if ( d >= 0 && d <= rahti){
      this.rahti = rahti - d;
    }
    else if( d > rahti ){
      this.rahti = 0;
    }
    else{
      System.out.println("Negatiivista määrää ei voitu poistaa.");
    }
    super.setNopeus( super.getNopeus()*(1 - rahti/kapasiteetti) );
    if( rahti == kapasiteetti ){
      super.setNopeus(0);
    }
  }  
  
  /* lisätään rahtia d yksikköä, jos d >= 0 ja kapasiteetti riittää.
   * kapasiteetin täyttyessä täytetään koko laiva ja tulostetaan ilmoitusviesti täyttymisestä.
   * jos d < 0, tulostetaan ilmoitus, että negatiivistä ei lisätty.
   */
  public void lisaaRahtia(double d){
    super.setNopeus( super.getNopeus()/(1 - rahti/kapasiteetti) );
    if ( d >= 0 && d + rahti <= this.kapasiteetti){
      this.rahti = d + rahti;
    }
    else if( d >= 0 && d + rahti > this.kapasiteetti ){
      this.rahti = kapasiteetti;
      System.out.println("Kapasiteetti täytetty. Kuormaamatta jäi " + ( d + rahti - Math.abs(kapasiteetti) ) + " yksikköä.");
    }
    else{
      System.out.println("Negatiivista määrää ei voitu lisätä.");
    }
    super.setNopeus( super.getNopeus()*(1 - rahti/kapasiteetti) );
  }
  
  public double getRahti(){
    return rahti;
  }
  
  
}

class Autolautta extends Laiva{
  private final int kapasiteetti;
  private int matkustajaMaara;
  private int autojenMaara;
  
  /*
   * AUTOLAUTTA-KONSTRUKTORI
   * 
   * Ottaa argumentteina ensin Laiva:lle asetettavat attribuutit ja sen jälkeen Autolautta:lle asetettavat (syötteen itseisarvoina).
   * 
   * Jos kapasiteetti ylittyy, ylijäävää määrää ei lisätä ja tulostetaan ilmoitus.
   * 
   * Laiva:n nopeus annetaan tapauksessa, jossa rahtia ei ole ja rahdin lisääminen muuttaa nopeutta.
   * 
   */
  public Autolautta(String nimi, double pituus, double syvays, double nopeus, int kapasiteetti, int matkustajaMaara, int autojenMaara){
    super(nimi, pituus, syvays, nopeus);
    this.kapasiteetti = Math.abs(kapasiteetti);
    if ( Math.abs(matkustajaMaara) <= Math.abs(kapasiteetti) ){
      this.matkustajaMaara = Math.abs(matkustajaMaara);
    }
    else{
      System.out.println("Kapasiteetti täytetty. Laivasta jäi " + ( Math.abs(matkustajaMaara) - Math.abs(kapasiteetti) ) + " matkustajaa.");
      this.matkustajaMaara = Math.abs(kapasiteetti);
    }
    if ( Math.abs(autojenMaara)*10 <= Math.abs(kapasiteetti) - matkustajaMaara ){
      this.autojenMaara = Math.abs(autojenMaara);
    }
    else{
      System.out.println("Kapasiteetti täytetty. Laivasta jäi " + ( Math.abs(autojenMaara) - (int)(Math.abs(kapasiteetti) - matkustajaMaara )/10) + " autoa.");
      this.autojenMaara = (int)( (Math.abs(kapasiteetti) - matkustajaMaara )/10 );
    }
    super.setNopeus( nopeus*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
  }
  
  // AUTOJEN LISÄYS- JA POISTOMETODIT
  
  /* poistetaan autoja d kappaletta, jos d >= 0 ja autoja riittää.
   * autojen loppuessa tulostetaan ilmoitusviesti autojen loppumisesta.
   * jos d < 0, tulostetaan ilmoitus, että negatiivista ei poistettu.
   */
  public void poistaAutoja(int d){
    super.setNopeus( super.getNopeus()/(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
    if ( d >= 0 && d <= autojenMaara){
      this.autojenMaara = autojenMaara - d;
    }
    else if( d > autojenMaara ){
      this.autojenMaara = 0;
    }
    else{
      System.out.println("Negatiivista määrää ei voitu poistaa.");
    }
    super.setNopeus( super.getNopeus()*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti)) );
  }  
  
  /* lisätään autoja d kappaletta, jos d >= 0 ja kapasiteetti riittää.
   * kapasiteetin täyttyessä täytetään koko laiva ja tulostetaan ilmoitusviesti täyttymisestä.
   * jos d < 0, tulostetaan ilmoitus, että negatiivistä ei lisätty.
   */
  public void lisaaAutoja(int d){
    super.setNopeus( super.getNopeus()/(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
    if ( d >= 0 && 10*d + 10*autojenMaara + matkustajaMaara <= kapasiteetti){
      this.autojenMaara = d + this.autojenMaara;
    }
    else if( d >= 0 && 10*d + 10*autojenMaara + matkustajaMaara > kapasiteetti ){
      System.out.println("Kapasiteetti täytetty. Laivasta jäi " + ( d - autojenMaara - (int)( (Math.abs(kapasiteetti) - matkustajaMaara )/10.0) ) + " autoa.");
      this.autojenMaara = (int)( (Math.abs(kapasiteetti) - matkustajaMaara )/10.0 );
    }
    else{
      System.out.println("Negatiivista määrää ei voitu lisätä.");
    }
    super.setNopeus( super.getNopeus()*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti)) );
  }
  
  // MATKUSTAJIEN LISÄYS- JA POISTOMETODIT
  
  /* poistetaan matkustajia d kappaletta, jos d >= 0 ja matkustajia riittää.
   * matkustajien loppuessa tulostetaan ilmoitusviesti.
   * jos d < 0, tulostetaan ilmoitus, että negatiivista ei poistettu.
   */
  public void poistaMatkustajia(int d){
    super.setNopeus( super.getNopeus()/(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
    if ( d >= 0 && d <= matkustajaMaara){
      this.matkustajaMaara = matkustajaMaara - d;
    }
    else if( d > autojenMaara ){
      this.matkustajaMaara = 0;
    }
    else{
      System.out.println("Negatiivista määrää ei voitu poistaa.");
    }
    super.setNopeus( super.getNopeus()*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti)) );
  }  
  
  /* lisätään autoja d kappaletta, jos d >= 0 ja kapasiteetti riittää.
   * kapasiteetin täyttyessä täytetään koko laiva ja tulostetaan ilmoitusviesti täyttymisestä.
   * jos d < 0, tulostetaan ilmoitus, että negatiivistä ei lisätty.
   */
  public void lisaaMatkustajia(int d){
    super.setNopeus( super.getNopeus()/(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
    if ( d >= 0 && d + 10*autojenMaara + matkustajaMaara <= kapasiteetti){
      this.matkustajaMaara = d + this.matkustajaMaara;
    }
    else if( d >= 0 && d + 10*autojenMaara + matkustajaMaara > kapasiteetti ){
      System.out.println("Kapasiteetti täytetty. Laivasta jäi " + ( d - (kapasiteetti - matkustajaMaara - 10*autojenMaara) ) + " matkustajaa.");
      this.matkustajaMaara = kapasiteetti - 10*autojenMaara;
    }
    else{
      System.out.println("Negatiivista määrää ei voitu lisätä.");
    }
    super.setNopeus( super.getNopeus()*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti)) );
  }
  
  public int getMatkustajat(){
    return matkustajaMaara;
  }
  
  public int getAutot(){
    return autojenMaara;
  }
  
}
