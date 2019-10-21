public class Laiva {

 private static double SOLMUTKILOMETREINATUNNISSA = 1.852;
 
 private String nimi;
 private double pituus;
 private double syvays; 
 private double nopeus;
 
 /**
  * Laivan konstruktori.
  * @param nimi Laivan nimi
  * @param pituus Laivan pituus metrein�
  * @param syvays Laivan syv�ys metrein�
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
  * @param matka Kuljettava matka kilometrein�.
  * @return matkaan kuluva aika tunteina. ��ret�n, 
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
   * Ottaa argumentteina ensin Laiva:lle asetettavat attribuutit ja sen j�lkeen Rahtilaivalle asetettavat (sy�tteen itseisarvoina).
   * 
   * Jos kapasiteetti ylittyy, ylij��v�� m��r�� ei lis�t� ja tulostetaan ilmoitus.
   * 
   * Laiva:n nopeus annetaan tapauksessa, jossa rahtia ei ole ja rahdin lis��minen muuttaa nopeutta.
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
      System.out.println("Kapasiteetti t�ytetty. Kuormaamatta j�i " + ( Math.abs(rahti) - Math.abs(kapasiteetti) ) + " yksikk��.");
    }
    super.setNopeus( nopeus*(1 - rahti/kapasiteetti) );
  }
  
  /* poistetaan rahtia d yksikk��, jos d >= 0 ja rahtia riitt��.
   * rahdin loppuessa tyhjennet��n koko laiva ja tulostetaan ilmoitusviesti rahdin loppumisesta.
   * jos d < 0, tulostetaan ilmoitus, ett� negatiivist� ei poistettu.
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
      System.out.println("Negatiivista m��r�� ei voitu poistaa.");
    }
    super.setNopeus( super.getNopeus()*(1 - rahti/kapasiteetti) );
    if( rahti == kapasiteetti ){
      super.setNopeus(0);
    }
  }  
  
  /* lis�t��n rahtia d yksikk��, jos d >= 0 ja kapasiteetti riitt��.
   * kapasiteetin t�yttyess� t�ytet��n koko laiva ja tulostetaan ilmoitusviesti t�yttymisest�.
   * jos d < 0, tulostetaan ilmoitus, ett� negatiivist� ei lis�tty.
   */
  public void lisaaRahtia(double d){
    super.setNopeus( super.getNopeus()/(1 - rahti/kapasiteetti) );
    if ( d >= 0 && d + rahti <= this.kapasiteetti){
      this.rahti = d + rahti;
    }
    else if( d >= 0 && d + rahti > this.kapasiteetti ){
      this.rahti = kapasiteetti;
      System.out.println("Kapasiteetti t�ytetty. Kuormaamatta j�i " + ( d + rahti - Math.abs(kapasiteetti) ) + " yksikk��.");
    }
    else{
      System.out.println("Negatiivista m��r�� ei voitu lis�t�.");
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
   * Ottaa argumentteina ensin Laiva:lle asetettavat attribuutit ja sen j�lkeen Autolautta:lle asetettavat (sy�tteen itseisarvoina).
   * 
   * Jos kapasiteetti ylittyy, ylij��v�� m��r�� ei lis�t� ja tulostetaan ilmoitus.
   * 
   * Laiva:n nopeus annetaan tapauksessa, jossa rahtia ei ole ja rahdin lis��minen muuttaa nopeutta.
   * 
   */
  public Autolautta(String nimi, double pituus, double syvays, double nopeus, int kapasiteetti, int matkustajaMaara, int autojenMaara){
    super(nimi, pituus, syvays, nopeus);
    this.kapasiteetti = Math.abs(kapasiteetti);
    if ( Math.abs(matkustajaMaara) <= Math.abs(kapasiteetti) ){
      this.matkustajaMaara = Math.abs(matkustajaMaara);
    }
    else{
      System.out.println("Kapasiteetti t�ytetty. Laivasta j�i " + ( Math.abs(matkustajaMaara) - Math.abs(kapasiteetti) ) + " matkustajaa.");
      this.matkustajaMaara = Math.abs(kapasiteetti);
    }
    if ( Math.abs(autojenMaara)*10 <= Math.abs(kapasiteetti) - matkustajaMaara ){
      this.autojenMaara = Math.abs(autojenMaara);
    }
    else{
      System.out.println("Kapasiteetti t�ytetty. Laivasta j�i " + ( Math.abs(autojenMaara) - (int)(Math.abs(kapasiteetti) - matkustajaMaara )/10) + " autoa.");
      this.autojenMaara = (int)( (Math.abs(kapasiteetti) - matkustajaMaara )/10 );
    }
    super.setNopeus( nopeus*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
  }
  
  // AUTOJEN LIS�YS- JA POISTOMETODIT
  
  /* poistetaan autoja d kappaletta, jos d >= 0 ja autoja riitt��.
   * autojen loppuessa tulostetaan ilmoitusviesti autojen loppumisesta.
   * jos d < 0, tulostetaan ilmoitus, ett� negatiivista ei poistettu.
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
      System.out.println("Negatiivista m��r�� ei voitu poistaa.");
    }
    super.setNopeus( super.getNopeus()*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti)) );
  }  
  
  /* lis�t��n autoja d kappaletta, jos d >= 0 ja kapasiteetti riitt��.
   * kapasiteetin t�yttyess� t�ytet��n koko laiva ja tulostetaan ilmoitusviesti t�yttymisest�.
   * jos d < 0, tulostetaan ilmoitus, ett� negatiivist� ei lis�tty.
   */
  public void lisaaAutoja(int d){
    super.setNopeus( super.getNopeus()/(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
    if ( d >= 0 && 10*d + 10*autojenMaara + matkustajaMaara <= kapasiteetti){
      this.autojenMaara = d + this.autojenMaara;
    }
    else if( d >= 0 && 10*d + 10*autojenMaara + matkustajaMaara > kapasiteetti ){
      System.out.println("Kapasiteetti t�ytetty. Laivasta j�i " + ( d - autojenMaara - (int)( (Math.abs(kapasiteetti) - matkustajaMaara )/10.0) ) + " autoa.");
      this.autojenMaara = (int)( (Math.abs(kapasiteetti) - matkustajaMaara )/10.0 );
    }
    else{
      System.out.println("Negatiivista m��r�� ei voitu lis�t�.");
    }
    super.setNopeus( super.getNopeus()*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti)) );
  }
  
  // MATKUSTAJIEN LIS�YS- JA POISTOMETODIT
  
  /* poistetaan matkustajia d kappaletta, jos d >= 0 ja matkustajia riitt��.
   * matkustajien loppuessa tulostetaan ilmoitusviesti.
   * jos d < 0, tulostetaan ilmoitus, ett� negatiivista ei poistettu.
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
      System.out.println("Negatiivista m��r�� ei voitu poistaa.");
    }
    super.setNopeus( super.getNopeus()*(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti)) );
  }  
  
  /* lis�t��n autoja d kappaletta, jos d >= 0 ja kapasiteetti riitt��.
   * kapasiteetin t�yttyess� t�ytet��n koko laiva ja tulostetaan ilmoitusviesti t�yttymisest�.
   * jos d < 0, tulostetaan ilmoitus, ett� negatiivist� ei lis�tty.
   */
  public void lisaaMatkustajia(int d){
    super.setNopeus( super.getNopeus()/(1 - ( (10*autojenMaara + matkustajaMaara)/kapasiteetti) ) );
    if ( d >= 0 && d + 10*autojenMaara + matkustajaMaara <= kapasiteetti){
      this.matkustajaMaara = d + this.matkustajaMaara;
    }
    else if( d >= 0 && d + 10*autojenMaara + matkustajaMaara > kapasiteetti ){
      System.out.println("Kapasiteetti t�ytetty. Laivasta j�i " + ( d - (kapasiteetti - matkustajaMaara - 10*autojenMaara) ) + " matkustajaa.");
      this.matkustajaMaara = kapasiteetti - 10*autojenMaara;
    }
    else{
      System.out.println("Negatiivista m��r�� ei voitu lis�t�.");
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
