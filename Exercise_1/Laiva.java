/*
Toteuta luokka Laiva. 
Luokan tulee sis�lt�� ainakin attribuutit: 
nimi, pituus, syv�ys ja nopeus solmuina. (Syv�ys tarkoittaa laivan tai veneen rungon alimpien kiinteiden rakenteiden (yleens� k�lin tai per�simen) et�isyytt� tyynest� vesirajasta.)
Toteuta lis�ksi metodi, jolla voidaan laskea kuinka nopeasti laiva kulkee annetun matkan.
*/
public class Laiva{
  // Attribuutit
  private String nimi;
  private double pituus;
  private double syvays;
  private double[] nopeus;
  
  /*
  Luokan "Laiva" konstruktori
  nimi = laivan nimi
  pituus = laivan pituus metrein�
  syvays = laivan syv�ys metrein�
  nopeus = laivan nopeus solmuina kiinnitetyss� koordinaatistossa
  */
  public Laiva(String nimi, double pituus, double syvays, double[] nopeus){
    this.nimi = nimi;
    this.pituus = pituus;
    this.syvays = syvays;
    this.nopeus = nopeus;
  }
  public double[] annaNopeus(){
    return nopeus;
  } 
  public String annaNimi(){
    return nimi;
  } 
  /*
   Palauttaa olion laiva vauhdin muodossa metri� sekuntissa (1 solmu = 0.5144 m/s)
  */
  public double laskeVauhti(){
    double vauhti = 0;
    for (int i = 0; i < nopeus.length; i++){
      vauhti = vauhti + Math.pow(( nopeus[i] )*0.5144, 2);
    }
    return Math.sqrt(vauhti);
  }
  /*
   Ottaa sy�tteen� Laiva-tyyppisen olion laiva ja kuljettavan matkan m (metrein�)
   Palauttaa laivan nopeudella matkan kulkemiseen kuluvan ajan sekunteina
  */
  // HUOM!!! SIISTIMPI, JOS VIITTAA SUORAAN OLION ATTRIBUUTTIIN NOPEUS (Nyt k�yt�nn�ss� luokkametodi, eik� esiintym�metodi)
  public static double laskeAika(Laiva laiva, double m){
    return m/( laiva.laskeVauhti() );
  }
}