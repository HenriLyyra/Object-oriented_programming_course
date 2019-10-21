import java.io.*;
import java.util.Scanner;

public class Laivanupotus {
  
  public static void main(String[] args){
    
    boolean pelataanko = false;
    
    //System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    System.out.println("~ ~ TERVETULOA PELAAMAAN SARAN, MIRAN JA HENRIN LAIVANUPOTUSTA! ~ ~");
    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    //System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    System.out.println("");
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Haluatko pelata (p) vai ajaa simulaation (a) ? (p/a): ");
    String vastaus0 = scanner.nextLine();  
    System.out.println("");
    
    Pelaaja p1 = new Tekoaly("HAL 9000");
    
    if ( vastaus0 != null && !vastaus0.isEmpty() && vastaus0.charAt(0) == 'p' ){
      pelataanko = true;
      System.out.println("Mikä on nimesi? ");
      String nimi = scanner.nextLine(); 
      p1 = new Pelaaja("asd");
    }
    System.out.println("");
    
    Pelaaja p2 = new Tekoaly("Skynet");
    
    PelinTila pT = new PelinTila(p1,p2);
    
    System.out.println("Haluatko jatkaa tallennettua peliä? (k = Kyllä): ");
    String vastaus = scanner.nextLine();  
    scanner.close();
    System.out.println("");
    
    if ( vastaus != null && !vastaus.isEmpty() && vastaus.charAt(0) == 'k' ){
      pT = lataaPeli();
      p1 = pT.annaPelaaja1();
      p2 = pT.annaPelaaja2();
    }
    else{  
      pelaaAloitusvuoro(p1, p2);
    }
    
    pelaaPeli(pT, pelataanko);
    
  }
  
  public static void pelaaAloitusvuoro(Pelaaja p1, Pelaaja p2){
    
    p1.asetaVastus(p2);
    p2.asetaVastus(p1);
    
    
    for( Laiva5 laiva : ( p1.annaLaivasto() ).annaLaivat() ){
      p1.asetaLaiva(laiva);
    }
    
    for( Laiva5 laiva : ( p2.annaLaivasto() ).annaLaivat() ){
      p2.asetaLaiva(laiva);
    }
    
  }
  
  
  public static void pelaaPeli(PelinTila pT, boolean pelataanko){// ammutaan vuorotellen kunnes toinen voittaa. joka vuoron alussa kysytään, tallennetaanko peli
    
    Pelaaja p1 = pT.annaPelaaja1();
    Pelaaja p2 = pT.annaPelaaja2();
    
    int vuorojaMennyt = 0;
    
    while ( !( p1.annaLaivasto() ).onkoKaikkiUpotettu() && !( p2.annaLaivasto() ).onkoKaikkiUpotettu()  ){
      
      // KYSYTÄÄN, TALLENNETAANKO PELI
      Scanner scanner = new Scanner(System.in);
      System.out.println("Haluatko tallentaa nykyisen pelin? (k = Kyllä): ");
      String vastaus = scanner.nextLine();  
      scanner.close();
      System.out.println("");
      
      if ( vastaus != null && !vastaus.isEmpty() && vastaus.charAt(0) == 'k' ){
        tallennaPeli(pT);
      }
      
      if ( pelataanko ){
        p1.ammuPaikkaan();
        ( (Tekoaly)p2 ).ammuPaikkaanParemmin();
      }
      else{
        ( (Tekoaly)p1 ).ammuPaikkaanParemmin();
        ( (Tekoaly)p2 ).ammuPaikkaanParemmin();
      }
      vuorojaMennyt += 1;
      
    }
    
    System.out.println("-------------------------------------");
    System.out.println("-------------------------------------");
    System.out.println("-- ONNEKSI OLKOON! PELI PÄÄTTYI!!! --");
    System.out.println("-------------------------------------");
    System.out.println("-------------------------------------");
    System.out.println("");
    
    if ( ( p1.annaLaivasto() ).onkoKaikkiUpotettu() ){
      if ( ( p2.annaLaivasto() ).onkoKaikkiUpotettu() ){
        System.out.println("Tasapeli!!");
      }
      else{
        System.out.println("Voittaja on " + p2.annaNimi() + "!!!");
      }
    }
    else{
      System.out.println("Voittaja on " + p1.annaNimi() + "!!!");
    }
    
    System.out.println("");
    System.out.println("Peli kesti " + vuorojaMennyt + " vuoroa.");
    
  }
  
  
  public static void tallennaPeli(PelinTila pT){// Tallentaa pelitilanteen pelaajan syöttämän nimen mukaiseen .txt-tiedostoon
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Pelisi tallennetaan nimesi perusteella! Anna nimesi.");
    String tallennus = scanner.nextLine();
    scanner.close();
    System.out.println("");
    
    try {
      // create a new file with an ObjectOutputStream
      FileOutputStream out = new FileOutputStream(tallennus+".txt");
      ObjectOutputStream oout = new ObjectOutputStream(out);
      
      // write something in the file
      oout.writeObject(pT);
      oout.flush();
      
      oout.close();
    }       
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  
  public static PelinTila lataaPeli(){// Lataa pelitilanteen muodollisen muuttujen polku osoittamasta paikasta
    
    // KysytŠŠn pelaajan nimi, jonka avulla etsitŠŠn kyseisen pelaajan peli
    Scanner scanner = new Scanner(System.in);
    System.out.println("Anna nimi, jolla tallensit pelin!");
    String nimi = scanner.nextLine();
    scanner.close();
    System.out.println("");
    
    try {
      // create an ObjectInputStream for the file we created before
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nimi+".txt"));
      
      PelinTila temp = new PelinTila();
      temp = ( (PelinTila) ois.readObject() );// read an object
      ois.close();
      return temp;
    } catch (Exception ex) {
      ex.printStackTrace();
      return new PelinTila();
    }
    
  }
  
  static class PelinTila implements java.io.Serializable{
    
    private Pelaaja pelaaja1 = new Pelaaja("pelaaja1");
    private Pelaaja pelaaja2 = new Pelaaja("pelaaja2");
    
    public PelinTila(){
    }
    
    public PelinTila(Pelaaja pelaaja1, Pelaaja pelaaja2){
      this.pelaaja1 = pelaaja1;
      this.pelaaja2 = pelaaja2;
    }
    
    public Pelaaja annaPelaaja1(){
      return pelaaja1;
    }
    
    public Pelaaja annaPelaaja2(){
      return pelaaja2;
    }
    
  }
  
}










