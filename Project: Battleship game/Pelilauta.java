/* 
 ArrayList<int[]> laivastonKoordinaatit // tarvitsee metodin, joka ottaa Laivasto-oliosta kaikkien 
 laivojen koordinaatit ja tallentaa ne Arraylistiin laivastonKoordinaatit
 
 ArrayList<int[]> osumienKoordinaatit // tarvitsee metodin, joka ottaa Laivasto-oliosta kaikkiin 
 laivoihin osuneiden koordinaatit ja tallentaa ne Arraylistiin osumienKoordinaatit
 
 ArrayList<int[]> hutienKoordinaatit // tähän Pelaaja-olio lisää ammutut hudit */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Pelilauta implements java.io.Serializable{
  
  protected int[][] pelilauta;
  protected ArrayList<int[]> laivastonKoordinaatit;
  protected ArrayList<int[]> osumienKoordinaatit;
  protected ArrayList<int[]> hutienKoordinaatit;
  
  public Pelilauta(){// HUOM: NÄMÄ VOI PERIAATTEESSA SISÄLLYTTÄÄ JO ATTRIBUUTTIEMÄÄRITTELYISSÄ
    hutienKoordinaatit = new ArrayList<int[]>();
    osumienKoordinaatit = new ArrayList<int[]>();
    laivastonKoordinaatit = new ArrayList<int[]>();
  }
  
  public boolean onkoHudeissaTaiOsumissa( int[] n ){
    if ( onkoHudeissa( n ) || onkoOsumissa( n ) ){
      return true;
    }
    return false;
  }
  
  public boolean onkoHudeissa( int[] n ){
    for ( int[] k : hutienKoordinaatit ){
      if ( n[0] == k[0] && n[1] == k[1] ){
        return true;
      }
    }
    return false;
  }
  
  public boolean onkoOsumissa( int[] n ){
    for ( int[] k : osumienKoordinaatit ){
      if ( n[0] == k[0] && n[1] == k[1] ){
        return true;
      }
    }
    return false;
  }
  
  public ArrayList<int[]> annaOsumat(){
    return osumienKoordinaatit;
  }
  
  // Tehdään pelilautta 10 x 10 matriisi 
  public void tulostaLauta(){
    pelilauta = new int[10][10];
    for (int rivi=0; rivi < pelilauta.length; rivi++){
      for (int kolumni=0; kolumni<pelilauta[rivi].length; kolumni++){
        //Alustetaan tyhjä ruutu 0
        pelilauta[rivi][kolumni]=0;// HUOM: ARRAYLLE ALUSTAA (KAI) AUTOMAATTISESTI ARVOIKSI 0
        System.out.print(pelilauta[rivi][kolumni] + "");
      }
      System.out.println();
    }
  }
  
  public void tulostaLauta2(){// HENRI LISÄSI (tulostaa pelilaudan osumineen, laivoineen, ja huteineen )
    
    System.out.println("------- TULOSTETAAN OMA PELILAUTA -------");
    System.out.println("X = osuma, L = laiva, H = huti, 0 = tyhjä.");
    System.out.println("");
    
    
    System.out.print("   ");// tulostetaan sarakenumerot
    for (int kolumni=0; kolumni< 10; kolumni++){
      System.out.print(kolumni + " ");
    }
    
    System.out.println();
    
    System.out.print("  |");// tulostetaan rivinumerot
    for (int kolumni=0; kolumni< 10; kolumni++){
      System.out.print("--");
    }
    System.out.println();
    for (int rivi=0; rivi < 10; rivi++){
      System.out.print(rivi + " |");
      for (int kolumni=0; kolumni< 10; kolumni++){
        
        int[] n = {kolumni,rivi};
        
        if ( !osumienKoordinaatit.isEmpty() && onListassa( osumienKoordinaatit, n ) ) {
          System.out.print("X ");
        }
        else if ( onListassa( laivastonKoordinaatit, n ) ) {
          System.out.print("L ");
        }
        else if ( onListassa( hutienKoordinaatit, n ) ) {
          System.out.print("H ");
        }
        else {
          System.out.print("0 ");
        }
        
      }
      System.out.println();
    }
    System.out.println("");
  }
  
  public void tulostaVastustajanLauta2(){// HENRI LISÄSI (tulostaa vastustaja pelilaudan osumineen ja huteineen )
    
    System.out.println("---- TULOSTETAAN VASTUSTAJAN PELILAUTA ----");
    System.out.println("X = osuma, H = huti, 0 = tyhjä.");
    System.out.println("");
    
    
    System.out.print("   ");// tulostetaan sarakenumerot
    for (int kolumni=0; kolumni< 10; kolumni++){
      System.out.print(kolumni + " ");
    }
    
    System.out.println();
    
    System.out.print("  |");// tulostetaan rivinumerot
    for (int kolumni=0; kolumni< 10; kolumni++){
      System.out.print("--");
    }
    System.out.println();
    
    for (int rivi=0; rivi < 10; rivi++){
      System.out.print(rivi + " |");
      for (int kolumni=0; kolumni< 10; kolumni++){
        
        int[] n = {kolumni,rivi};
        
        if ( !osumienKoordinaatit.isEmpty() && onListassa( osumienKoordinaatit, n ) ) {
          System.out.print("X ");
        }
        else if ( onListassa( hutienKoordinaatit, n ) ) {
          System.out.print("H ");
        }
        else {
          System.out.print("0 ");
        }
        
      }
      System.out.println();
    }
    System.out.println("");
  }
  
  
  public static boolean onListassa( final ArrayList<int[]> lista, final int[] n){// HENRI LISÄSI
    for( final int[] alkio : lista ){
      if(Arrays.equals(alkio, n)){
        return true;
      }
    }
    return false;
  }
  
  
  // Tallennetaan laivojen koordinaatit laivastonKoordinaatit - listaan
  public void tallennaLaivastoKoordinaatit(Laivasto laivasto){
    
    //Käydään laiva -lista läpi ja käydään koordinaatit läpi ja lisätään 
    ArrayList<Laiva5> laivat = laivasto.annaLaivat();
    for (int i=0; i<laivat.size(); i++){
      laivastonKoordinaatit.addAll(laivat.get(i).annaKoordinaatit());// TARVITSEEKO addAll, VAI RIITTÄÄKÖ PELKKÄ add?
    }
    
    HashSet<int[]> hs = new HashSet<int[]>();// HENRI LISÄSIT (nämä rivit poistaa koordinaattien duplikaatit)
    hs.addAll(laivastonKoordinaatit);
    laivastonKoordinaatit.clear();
    laivastonKoordinaatit.addAll(hs);
    /*
     //Tulostetaan testausta varten
     for (int i=0; i<laivastonKoordinaatit.size(); i++){
     System.out.println("Laivaston koordinaatit: " + Arrays.toString(laivastonKoordinaatit.get(i)));
     }
     */
  }
  
  /////////////////////////////////////////////// NÄITÄ MUUTETTIIN SITEN, ETTÄ DUPLIKKATIT POISTETAAN ///////////////////////////////////////////////
  
  // Tallennetaan osumien koordinaatit osumienKoordinaatit - listaan
  public void tallennaOsumaKoordinaatit(Laivasto laivasto){// NYT LAIVASTO ON MUODOLLISENA PARAMETRINA. SEN VOISI (KAI) KAIVAA MYÖS ATTRIBUUTISTA
    
    //Käydään laiva -lista läpi ja käydään osumien koordinaatit läpi ja lisätään 
    ArrayList<Laiva5> laivat = laivasto.annaLaivat();
    for (int i=0; i<laivat.size(); i++){
      osumienKoordinaatit.addAll(laivat.get(i).annaOsumaKoordinaatit());
    }
    HashSet<int[]> hs = new HashSet<int[]>();// HENRI LISÄSIT (nämä rivit poistaa koordinaattien duplikaatit)
    hs.addAll(osumienKoordinaatit);
    osumienKoordinaatit.clear();
    osumienKoordinaatit.addAll(hs);
    
    //Tulostetaan testausta varten
    /*
     for (int i=0; i<osumienKoordinaatit.size(); i++){
     System.out.println("Osumien koordinaatit: " + Arrays.toString(osumienKoordinaatit.get(i)));
     }
     */
  }
  
  // Tallennetaan hutien koordinaatit hutienKoordinaatit - listaan
  public void tallennaHutienKoordinaatit(Laivasto laivasto){
    
    //Käydään laiva -lista läpi ja käydään hutien koordinaatit läpi ja lisätään 
    ArrayList<Laiva5> laivat = laivasto.annaLaivat();
    for (int i=0; i<laivat.size(); i++){
      hutienKoordinaatit.addAll(laivat.get(i).annaHutienKoordinaatit());
    }
    HashSet<int[]> hs = new HashSet<int[]>();// HENRI LISÄSI (nämä rivit poistaa koordinaattien duplikaatit)
    hs.addAll(hutienKoordinaatit);
    hutienKoordinaatit.clear();
    hutienKoordinaatit.addAll(hs);
    
    //Tulostetaan testausta varten
    /*
     for (int i=0; i<hutienKoordinaatit.size(); i++){
     System.out.println("Hutien koordinaatit: " + Arrays.toString(hutienKoordinaatit.get(i)));
     }
     */
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}






