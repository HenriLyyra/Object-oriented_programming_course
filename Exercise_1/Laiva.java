/*
Toteuta luokka Laiva. 
Luokan tulee sisältää ainakin attribuutit: 
nimi, pituus, syväys ja nopeus solmuina. (Syväys tarkoittaa laivan tai veneen rungon alimpien kiinteiden rakenteiden (yleensä kölin tai peräsimen) etäisyyttä tyynestä vesirajasta.)
Toteuta lisäksi metodi, jolla voidaan laskea kuinka nopeasti laiva kulkee annetun matkan.
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
  pituus = laivan pituus metreinä
  syvays = laivan syväys metreinä
  nopeus = laivan nopeus solmuina kiinnitetyssä koordinaatistossa
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
   Palauttaa olion laiva vauhdin muodossa metriä sekuntissa (1 solmu = 0.5144 m/s)
  */
  public double laskeVauhti(){
    double vauhti = 0;
    for (int i = 0; i < nopeus.length; i++){
      vauhti = vauhti + Math.pow(( nopeus[i] )*0.5144, 2);
    }
    return Math.sqrt(vauhti);
  }
  /*
   Ottaa syötteenä Laiva-tyyppisen olion laiva ja kuljettavan matkan m (metreinä)
   Palauttaa laivan nopeudella matkan kulkemiseen kuluvan ajan sekunteina
  */
  // HUOM!!! SIISTIMPI, JOS VIITTAA SUORAAN OLION ATTRIBUUTTIIN NOPEUS (Nyt käytännössä luokkametodi, eikä esiintymämetodi)
  public static double laskeAika(Laiva laiva, double m){
    return m/( laiva.laskeVauhti() );
  }
}