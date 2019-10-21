import java.util.*;
import java.util.Arrays;

class Laivasto implements java.io.Serializable{
  
  private Laiva5 lentotukialus = new Laiva5(5, "Lentotukialus");
  private Laiva5 taistelulaiva = new Laiva5(4, "Taistelulaiva");
  private Laiva5 risteilija1 = new Laiva5(3, "RisteilijŠ");
  private Laiva5 risteilija2 = new Laiva5(3, "RisteilijŠ");
  private Laiva5 havittaja = new Laiva5(2, "HŠvittŠjŠ");
  private Laiva5 sukellusvene = new Laiva5(1, "Sukellusvene");
  private ArrayList<Laiva5> laivat = new  ArrayList<Laiva5>( Arrays.asList(lentotukialus,taistelulaiva,risteilija1,risteilija2,havittaja,sukellusvene) );
  
  public ArrayList<Laiva5> annaLaivat(){
    return laivat;
  }
  
  public boolean onkoLaivojaValilla(int x1, int y1, int x2, int y2){
    Laiva5 temp = new Laiva5(4,"taistelualus");
    temp.asetaSijainti(x1, y1, x2, y2);
    for (Laiva5 laiva : laivat){
      for (int[] k : temp.annaKoordinaatit() ){
        if ( laiva.onkoPaikassa(k[0], k[1]) ){
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onkoLaivojaPaikassa(int x, int y){
    for (Laiva5 laiva : laivat){
      if ( laiva.onkoPaikassa(x, y) == true ){
        return true;
      }
    }
    return false;
  }
  
  public void lisaaLaiva(Laiva5 laiva){
    laivat.add(laiva);
  }
  
  public void tulostaLaivat(){
    System.out.println("- - - - - - - - - - - - - - - -");
    System.out.println ( "Laivat: ");
    System.out.println("");
    for (Laiva5 laiva : laivat){
      System.out.println( laiva.annaTyyppi() + ", pituus: " + laiva.annaPituus() );
    }
  }  

  public int yhteensaUpotettu(){// HENRI LISÄSI (tarvitaan tekoälyn ampumismetodia varten)
    int summa = 0;
    for (Laiva5 laiva : laivat){
      if (laiva.uppoa() == true){
        summa += 1;
      }
    }
    return summa;
  }
  

  public boolean onkoKaikkiUpotettu(){
    boolean b = false;
    for (Laiva5 laiva : laivat){
      if (laiva.uppoa() == true){
        b = true;
      }
      else{
        b=false;
        break;
      }
    }
    return b;
  }
  
  public boolean osuikoLaivastoon(int x, int y){// HENRI LISÄSI
    for ( Laiva5 laiva : laivat ){
      if ( laiva.osuikoLaivaan(x, y) ){
        return true;
      }
    }
    return false;
  }
  
  
}

public class Laiva5 implements java.io.Serializable{
  protected int pituus;
  protected int[] sijainti = new int [4];
  protected ArrayList<Integer> osumatX = new  ArrayList<Integer>();
  protected ArrayList<Integer> osumatY = new  ArrayList<Integer>();
  protected boolean upotettu;
  protected String tyyppi = "tavallinen laiva";
  protected ArrayList<int[]> koordinaatit = new  ArrayList<int[]>();
  protected ArrayList<int[]> osumaKoordinaatit = new  ArrayList<int[]>();// MIRA LISÄSI
  protected ArrayList<int[]> hutienKoordinaatit = new  ArrayList<int[]>();// MIRA LISÄSI (HENRI: EHKÄ PAREMPI PELILAUDAN TAI PELAAJAN ATTRIBUUTIKSI)
  
  public Laiva5(int pituus, String tyyppi){
    this.pituus = pituus;
    this.tyyppi = tyyppi;
    int[] i = {-1,-1,-1,-1};
    sijainti = i;
  }
  
  public void asetaSijainti(int x1, int y1, int x2, int y2){
    sijainti[0] = x1;
    sijainti[1] = y1;
    sijainti[2] = x2;
    sijainti[3] = y2;
    asetaKoordinaatit();// sijainti-ATTRIBUUTIN KOORDINAATTIEN PERUSTEELLA ASETETAAN LAIVAN MUUT KOORDINAATIT
  }
  
  public void asetaKoordinaatit(){
    if ( onkoPystysuunnassa() ){
      for ( int i = Math.min( sijainti[1], sijainti[3]) ; i <= Math.max( sijainti[1], sijainti[3]); i++ ){
        int[] piste = {sijainti[0],i};
        koordinaatit.add(piste);
      }
    }
    else{
      for ( int i = Math.min( sijainti[0], sijainti[2]) ; i <= Math.max( sijainti[0], sijainti[2]); i++ ){
        int[] piste = {i,sijainti[1]};
        koordinaatit.add(piste);
      }
    }
  }
  
  public ArrayList<int[]> annaKoordinaatit(){
    return koordinaatit;
  }
  
  public void asetaPituus(int pituus){
    this.pituus = pituus;
  }
  
  public int annaPituus(){
    return pituus;
  }
  
  public String annaTyyppi(){
    return tyyppi;
  }
  
  //Tarkastaa onko c vŠlillŠ a-b
  public static boolean onkoValilla(int a, int b, int c) {
    if (c >= a && c <= b || c >= b && c <= a ) {
      return true;
    }
    else {
      return false;
    }
  }
  
  //Palauttaa true, jos laiva on pystysuunnassa
  public boolean onkoPystysuunnassa(){
    if (sijainti[0]==sijainti[2]) {
      return true;
    }
    else {
      return false;
    }
  }
  
  //Tarkastaa onko laiva paikassa 
  public boolean onkoPaikassa(int x, int y) {
    if (onkoPystysuunnassa() == true) {
      if (x == sijainti[0] && onkoValilla(sijainti[1], sijainti[3], y)) {
        return true;
      }
    }
    else if (onkoPystysuunnassa() == false) {
      if ( y == sijainti[1] && onkoValilla(sijainti[0], sijainti[2],x)) {
        return true;
      }
    }
    return false;
  }
  
  //Tarkistetaan onko laivaan osuttu (X) //Mira lisäsi HENRI MUOKKASI (alunperin for-luuppi kävi läpi ainoastaan ensimmäisen alkion koordinaatit-listasta)
  public boolean osuikoLaivaan(int x, int y){
    for (int i=0; i<koordinaatit.size(); i++){
      // System.out.println(Arrays.toString(koordinaatit.get(i))); (testi)
      if(koordinaatit.get(i)[0] == x && koordinaatit.get(i)[1] == y){
        osumatX.add(x);
        osumatY.add(y);
        int[] temp= {x,y};
        osumaKoordinaatit.add(temp);
        return true;
      }
    }
    int[] temp= {x,y};
    hutienKoordinaatit.add(temp);
    return false;
  }
  
  public ArrayList<int[]> annaOsumaKoordinaatit(){ //Mira lisäsi
    return osumaKoordinaatit;
  }
  
  public ArrayList<int[]> annaHutienKoordinaatit(){ //Mira lisäsi
    return hutienKoordinaatit;
  }
  
  //Tarkistaa onko kaikkiin laivan kohtiin osuttu, jonka jŠlkeen laiva uppoaa
  public boolean uppoa() {
    //Vertaa osumia laivan pituuteen
    int osuma=0;
    if (onkoPystysuunnassa() == true) {
      for (int i = 0; i < osumatX.size(); i++) {
        if (osumatX.get(i) == sijainti[0]) {
          if (onkoValilla(sijainti[1], sijainti[3], osumatY.get(i))){
            osuma += 1;
            if (osuma == pituus) {
              return true;
            }
          }
        }
      }
    }
    else {// HENRI MUOKKASI ( else oli ennen "if (onkoPystysuunnassa() == true)", joka ei jostain syystä toiminut )
      int osuma2 =0;
      for (int i = 0; i < osumatY.size(); i++) {
        if (osumatY.get(i) == sijainti[1]) {//HENRI MUOKKASI ( alunperin oli "if (osumatY.get(i) == sijainti[0]) {"  )
          if (onkoValilla(sijainti[0], sijainti[2], osumatX.get(i))){
            osuma2 += 1;
            if (osuma2 == pituus) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  
  
}
