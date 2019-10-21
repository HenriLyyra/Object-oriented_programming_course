/*
Suunnittele yliopiston kurssienhallintaa hoitava sovellus. 
*/
public class demo_1T3 {
    public static void main(String[] args) {
      
    }
    
public class Opiskelija{
  // Attribuutit
  private String nimi;
  private String opiskelijaNumero;
  private int aloitusVuosi;
  private String paaAine;
  Private Kurssi[] suoritetutKurssit;
  // Toiminnallisuudet
  public Opiskelija(String nimi,...){
    this.nimi = nimi;
    .
    .
    .
  }
  
  // getterit
  public String annaNimi/opiskelijaNumero/aloitusVuosi/...(){
    return nimi;
  }
  
}

public class Opintorekisteri{
  // Attribuutit
  private Opiskelija[] opiskelijat;
  
  // setterit
  public void lisaaOpiskelija(){
    
  }
  
  // Toiminnallisuudet
  /* palauttaa koko rekisterin
   */
  public String[][] annaRekisteri(){
  }
  
}

  public class Kurssi{
    // Attribuutit
    private String nimi;
    private String[] jarjestusAika;
    private int opintoPisteet;
    private String luennoitsija;
    private Opiskelija[] opiskelijat;
    private int[] suorituspisteet;
    private int[] poissaolot;
    private Harjoitus[] tehtavat;
  
    // Luokkamuuttujat
    /* 
     * kurssin arvosanoja 1-5 vastaavat minimisuorituspistem‰‰r‰t
     */ 
    Private static final double[] arvosanarajat = [...,...,];
  
    // Toiminnallisuudet
    // setterit
    public void lisaaOpiskelija(Opiskelija ...){

    }
    
    public void poistaOpiskelija(int ...){

    }
  
    public void lisaaTehtava(Harjoitus ...){
      
    }
    
    
    // muut
    /*
     * Palauttaa opiskelijan saaman arvosanan
     */
    public int[] annaArvosanat(){

    }
    /*
     *  Arvostelee kurssin opiskelijoiden suoritukset
     */
    public void arvosteleHarjoitus(int ...){
      
    }
    /*
     * Lis‰‰ opiskelijoiden harjoituksessa i saamat pisteet suorituspisteisiin
     */
    public void lisaaSuorituspisteet(int ...){
      
    }
    
  }
  
  public class Harjoitus{
    // Attribuutit
    private String[] tehtavanannot;
    private String[] oikeatVastaukset;
    private int[] pistemaarat;
    
    // Toiminnallisuudet
    // setterit
    public void asetaTehtavanannot(){
      
    }
    
    public void asetaOikeatVastaukset(){
      
    }
    
    public void asetaPistemaarat(){
      
    }
    
    public int[] arvosteleVastaukset(){
      
    }
    
    //getterit
    
    public String[] annaTehtavanannot(){
      
    }
    
    public String[] annaOikeatVastaukset(){
      
    }
    /*
    Vertaa anettuja vastauksia oikeisiin ja palauttaa harjoituksista saadun pistem‰‰r‰n teht‰vitt‰in.
     */
    public int[] annaPistemaarat(){
      
    }
  
}