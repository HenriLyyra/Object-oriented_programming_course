import java.util.Scanner;// Otetaan Scanner-luokka käyttöön
import java.util.Random;// Otetaan Random-luokka käyttöön

// PELAAJA
public class Pelaaja implements java.io.Serializable{
  protected String nimi; 
  protected int pisteet = 0; 
  protected Pelilauta lautaOma; 
  protected Pelaaja vastus;// HENRI LISÄSI (vastustajan pelilauta poistettiin)
  protected Laivasto laivasto = new Laivasto();
  
  public Pelaaja(String nimi){
    this.nimi = nimi;
    lautaOma = new Pelilauta(); 
  }
  
  public String annaNimi(){//HENRI LISÄSI
    return nimi;
  }
  
  public Laivasto annaLaivasto(){
    return laivasto;
  }
  
  public Pelilauta annaLautaOma(){
    return lautaOma;
  }
  
  public void asetaLaivasto(Laivasto laivasto){
    this.laivasto = laivasto;
  }
  
  public void asetaVastus(Pelaaja vastus){// HENRI LISÄSI
    this.vastus = vastus;
  }
  
  
  // LAIVAN ASETUS (Peli-luokassa ajetaan muodossa "for (Laiva5 laiva: pelaaja.getLaivasto() { pelaaja.asetaLaiva(laiva);  }" )
  public void asetaLaiva(Laiva5 laiva){
    
    laivasto.tulostaLaivat();
    System.out.println("");
    lautaOma.tulostaLauta2();
    System.out.println("");
    
    int x1 = -1;
    int y1 = -1;
    int x2 = -1;
    int y2 = -1;
    
    
    // ALKUPÄÄN KOORDINAATIT
    do{
      do { 
        x1 = -1;
        y1 = -1;
        while ( x1 < 0 || x1 > 9 ){
          System.out.print("Anna laivan " + laiva.annaTyyppi() + " alkupään vaakakoordinaatti: "); // Tulostetaan kysymys
          x1 = kysyKoordinaatti();
          if ( x1 < 0 || x1 > 9 ){
            System.out.println("Koordinaatin pitää olla kokonaisluku välillä [0,9].");
            System.out.println("");
          }
        }
        
        while ( ( y1 < 0 || y1 > 9 ) ){
          System.out.print("Anna laivan " + laiva.annaTyyppi() + " alkupään pystykoordinaatti: "); // Tulostetaan kysymys
          y1 = kysyKoordinaatti();
          if ( y1 < 0 || y1 > 9 ){
            System.out.println("Koordinaatin pitää olla välillä [0,9].");
            System.out.println("");
          }
        }
        if ( laivasto.onkoLaivojaPaikassa(x1, y1) ){ 
          System.out.println("Laivat eivät saa olla päällekäin."); 
          System.out.println("");
        }
      }while ( laivasto.onkoLaivojaPaikassa(x1, y1) );
      
      // LOPPUPÄÄN KOORDINAATIT
      
      do{
        x2 = -1;
        y2 = -1;
        while ( x2 < 0 || x2 > 9 ){
          System.out.print("Anna laivan " + laiva.annaTyyppi() + " loppupään vaakakoordinaatti: "); // Tulostetaan kysymys
          x2 = kysyKoordinaatti();
          if ( x2 < 0 || x2 > 9 ){
            System.out.println("Koordinaatin pitää olla välillä [0,9].");
          }
        }
        
        while ( y2 < 0 || y2 > 9 ){
          System.out.print("Anna laivan " + laiva.annaTyyppi() + " loppupään pystykoordinaatti: "); // Tulostetaan kysymys
          y2 = kysyKoordinaatti();
          if ( y2 < 0 || y2 > 9 ){
            System.out.println("Koordinaatin pitää olla välillä [0,9].");
          }
        }
        if ( ( x1 != x2 ) && ( y1 != y2 ) ){
          System.out.println("Laivan pitää olla joko pysty- tai vaakasuorassa.");
        }
        if ( ( ( laiva.annaPituus() != ( 1 + Math.abs( x1 - x2 ) ) ) && ( y1 == y2 ) ) || ( ( laiva.annaPituus() != ( 1 + Math.abs( y1 - y2 ) ) ) && ( x1 == x2 ) ) ){ 
          System.out.println("Annetut koordinaatit eivät ole yhteensopivat laivan " + laiva.annaTyyppi() + " pituuden kanssa."); 
        }
      }while( ( ( x1 != x2 ) && ( y1 != y2 ) ) || ( ( laiva.annaPituus() != ( 1 + Math.abs( x1 - x2 ) ) ) && ( y1 == y2 ) ) || ( ( laiva.annaPituus() != ( 1 + Math.abs( y1 - y2 ) ) ) && ( x1 == x2 ) ) || ( ( x1 != x2 ) && ( y1 != y2 ) ) );
      if( laivasto.onkoLaivojaValilla(x1, y1, x2, y2) ){
        System.out.println("Laivat eivät saa olla päällekäin.");
      }
    }while( laivasto.onkoLaivojaValilla(x1, y1, x2, y2) );
    laiva.asetaSijainti(x1,y1,x2,y2);
    System.out.println("Laiva " + laiva.annaTyyppi() + " asetettu onnistuneesti pelilaudalle.");
    System.out.println("");
    lautaOma.tallennaLaivastoKoordinaatit(laivasto);
  }
  
  // AMPUU PAIKKAAN (x,y)
  public void ammuPaikkaan(){
    
    
    ( vastus.annaLautaOma() ).tulostaVastustajanLauta2();
    //System.out.println("- - (HUOM: nyt tulostetaan oikeasti vastustajan lauta testaamisen helpottamiseksi. Pelaaja-luokan ammuPaikkaan-medodin täytyy vaihtaa metodin tulostaLauta2 paikalle metodi tulostaVastustajanLauta2 ) - -");
    
    int uponneita = ( vastus.annaLaivasto() ).yhteensaUpotettu();// LUETAAN JOKA KERTA ENNEN AMPUMISTA, JOTTA VOIDAAN VERRATA UPPOSIKO UUSI LAIVA AMPUMISEN JÄLKEEN
    
    int x = -1;
    int y = -1;
    
    // LUETAAN VAAKAKOORDINAATTI
    while ( x < 0 || x > 9  ){
      System.out.print("Anna ammuttava vaakakoordinaatti: "); // Tulostetaan kysymys
      x = kysyKoordinaatti();
      if ( x < 0 || x > 9 ){
        System.out.println("Koordinaatin pitää olla välillä [0,9].");
      }
    }
    
    // LUETAAN PYSTYKOORDINAATTI
    while ( ( y < 0 || y > 9 ) ){
      System.out.print("Anna ammuttava pystykoordinaatti: "); // Tulostetaan kysymys
      y = kysyKoordinaatti();
      if ( y < 0 || y > 9 ){
        System.out.println("Koordinaatin pitää olla välillä [0,9].");
      }
    }
    System.out.println("");
    
    System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
    System.out.println("");
    System.out.println("Pelaaja ampui koordinaattiin (" + x + "," + y + ")");
    System.out.println("");
    
    if ( ( vastus.annaLaivasto() ).osuikoLaivastoon(x,y) ){
      System.out.println("Osuit vihollisen laivaan!");
      System.out.println("");
      ( vastus.annaLautaOma() ).tallennaOsumaKoordinaatit( vastus.annaLaivasto() );
      pisteet += 1;
      
    }
    else{
      ( vastus.annaLautaOma() ).tallennaHutienKoordinaatit( vastus.annaLaivasto() );
      //( vastus.annaLautaOma() ).hutienKoordinaatit.addAll(piste);
      System.out.println("Huti!");
      System.out.println("");
    }
    //}while( ( x < 0 || x > 9 ) || ( y < 0 || y > 9 ) /*|| (x,y) on listassa ( vastus.annaLautaOma() ).annaHutienKoordinaatit || (x,y) on listassa ( vastus.annaLautaOma() ).OsumienKoordinaatit  */ );
    if ( uponneita != ( vastus.annaLaivasto() ).yhteensaUpotettu() ){
      System.out.println("Upotit vihollisen laivan!!!");
      System.out.println("");
    }
  }
  
  public static int kysyKoordinaatti(){// SCANNER KYSYY KOORDINAATTIA NIIN KAUAN KUNNES SE ON KOKONAISLUKU JA PALAUTTAA SEN
    
    Scanner lukija = new Scanner(System.in); // Luodaan uusi Scanner-olio    
    boolean virhe = true;
    
    int temp = -1;
    
    while ( virhe ){
      try{
        temp = Integer.parseInt( lukija.nextLine() ); // Luetaan käyttäjän vastaus
        virhe = false;
      }catch (NumberFormatException e){
        System.out.println("Koordinaatin pitää olla kokonaisluku.");
        System.out.println("");
      }
    }
    
    lukija.close();
    return temp;
    
  }
  
}

/////////////////////////////////////////////////////////////////////////////////////////////////////

// TEKOÄLY
class Tekoaly extends Pelaaja implements java.io.Serializable{
  
  // NÄIDEN ATTRIBUUTTIEN AVULLA Tekoaly PITÄÄ KIRJAA SIITÄ, OSUIKO ÄSKEN LAIVAAN JA ONKO LAIVA PYSTY- VAI VAAKASUUNNASSA
  private boolean osui1 = false;
  private int[] osuma1 = {-1,-1};
  
  private boolean osui2 = false;
  private int[] osuma2 = {-1,-1};
  
  private boolean osui3 = true;
  private boolean pakki3huti = false;
  private int[] osuma3 = {-1,-1};
  
  public Tekoaly(String nimi){
    super(nimi);
  }
  
  
  // LAIVAN ASETUS (Peli-luokassa ajetaan muodossa "for (Laiva5 laiva: pelaaja.getLaivasto() { pelaaja.asetaLaiva(laiva);  }" )
  public void asetaLaiva(Laiva5 laiva){
    
    /*
     laivasto.tulostaLaivat();
     lautaOma.tulostaLauta2();
     */
    int x1 = -1;
    int y1 = -1;
    int x2 = -1;
    int y2 = -1;
    
    Random r = new Random();
    
    // ALKUPÄÄN KOORDINAATIT
    do{
      do { 
        x1 = -1;
        y1 = -1;
        while ( x1 < 0 || x1 > 9  ){
          x1 = r.nextInt(10);
        }
        
        while ( ( y1 < 0 || y1 > 9 ) ){
          y1 = r.nextInt(10);
        }
      }while ( laivasto.onkoLaivojaPaikassa(x1, y1) );
      
      // LOPPUPÄÄN KOORDINAATIT
      
      do{
        x2 = -1;
        y2 = -1;
        while ( x2 < 0 || x2 > 9 ){
          x2 = r.nextInt(10);
        }
        
        while ( y2 < 0 || y2 > 9 ){
          y2 = r.nextInt(10);
        }
      }while( ( ( x1 != x2 ) && ( y1 != y2 ) ) || ( ( laiva.annaPituus() != ( 1 + Math.abs( x1 - x2 ) ) ) && ( y1 == y2 ) ) || ( ( laiva.annaPituus() != ( 1 + Math.abs( y1 - y2 ) ) ) && ( x1 == x2 ) ) || ( ( x1 != x2 ) && ( y1 != y2 ) ) );
    }while( laivasto.onkoLaivojaValilla(x1, y1, x2, y2) );
    laiva.asetaSijainti(x1,y1,x2,y2);
    //System.out.println("Laiva " + laiva.annaTyyppi() + " asetettu onnistuneesti pelilaudalle.");
    lautaOma.tallennaLaivastoKoordinaatit(laivasto);
  }
  
  
  // AMPUU PAIKKAAN (x,y)
  public void ammuPaikkaan(){
    
    int uponneita = ( vastus.annaLaivasto() ).yhteensaUpotettu();// LUETAAN JOKA KERTA ENNEN AMPUMISTA, JOTTA VOIDAAN VERRATA UPPOSIKO UUSI LAIVA AMPUMISEN JÄLKEEN
    Random r = new Random();
    
    int x = -1;
    int y = -1;
    int[] temp = {x,y};
    
    do{
      
      // GENEROIDAAN SATUNNAINEN VAAKAKOORDINAATTI
      x = r.nextInt(10); 
      
      // GENEROIDAAN PYSTYKOORDINAATTI
      y = r.nextInt(10);
      
      temp[0] = x;
      temp[1] = y;
      
    }while( ( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp ) );
    
    System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
    System.out.println("");
    System.out.println("Tekoäly ampui koordinaattiin (" + x + "," + y + ")");
    System.out.println("");
    
    if ( ( vastus.annaLaivasto() ).osuikoLaivastoon(x,y) ){
      System.out.println("Tekoäly osui laivaan!");
      System.out.println("");
      ( vastus.annaLautaOma() ).tallennaOsumaKoordinaatit( vastus.annaLaivasto() );
      osui1 = true;// TÄMÄN AVULLA PAREMPI AMPUMISMETODI OSAA ALKAA ETSIÄ OSUMAA ENSIMMÄISEN OSUMAN VIERESTÄ
      osuma1[0] = temp[0];
      osuma1[1] = temp[1];
      pisteet += 1;
      
    }
    else{
      System.out.println("Tekoäly ampui hudin!");
      System.out.println("");
      ( vastus.annaLautaOma() ).tallennaHutienKoordinaatit( vastus.annaLaivasto() );
    }
    if ( uponneita != ( vastus.annaLaivasto() ).yhteensaUpotettu() ){
      System.out.println("Tekoäly upotti laivan!!!");
      System.out.println("");
      osui1 = false;// TÄMÄN AVULLA PAREMPI AMPUMISMETODI TIETÄÄ JATKAA OSUMAN ETSIMISTÄ SATUNNAISESTI
      pakki3huti = false;
    }
    
    System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
    System.out.println("");
    ( vastus.annaLautaOma() ).tulostaLauta2();
    
  }
  
  //////////////////    PAREMPI TEKOÄLYN AMPUMISMETODI //////////////////
  
  public void ammuPaikkaanParemmin(){
    
    int uponneita = ( vastus.annaLaivasto() ).yhteensaUpotettu();// LUETAAN JOKA KERTA ENNEN AMPUMISTA, JOTTA VOIDAAN VERRATA UPPOSIKO UUSI LAIVA AMPUMISEN JÄLKEEN
    
    int[] temp = {0,0};
    
    if ( !osui1 && !osui2 ){
      ammuPaikkaan();
    }
    else if( osui1 && !osui2 ){
      
      temp= tahtaaViereen();
      
      System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
      System.out.println("");
      System.out.println("Tekoäly ampui koordinaattiin (" + temp[0] + "," + temp[1] + ")");
      System.out.println("");
      
      if ( ( vastus.annaLaivasto() ).osuikoLaivastoon( temp[0], temp[1]) ){
        
        System.out.println("Tekoäly osui laivaan!");
        System.out.println("");
        ( vastus.annaLautaOma() ).tallennaOsumaKoordinaatit( vastus.annaLaivasto() );
        osui2 = true;// TÄMÄN AVULLA PAREMPI AMPUMISMETODI OSAA ALKAA ETSIÄ OSUMAA LAIVAN SUUNTAISESTI
        osuma2[0] = temp[0];
        osuma2[1] = temp[1];
        asetaOsuma3Max();
        pisteet += 1;
        
      }
      else{
        
        System.out.println("Tekoäly ampui hudin!");
        System.out.println("");
        ( vastus.annaLautaOma() ).tallennaHutienKoordinaatit( vastus.annaLaivasto() );
        
      }
      if ( uponneita != ( vastus.annaLaivasto() ).yhteensaUpotettu() ){
        
        System.out.println("Tekoäly upotti laivan!!!");
        System.out.println("");
        osui1 = false;// NÄIDEN AVULLA AMPUMISMETODI TIETÄÄ ALKAA HAKEA OSUMAA TAAS SATUNNAISESTI
        osui2 = false;//
        pakki3huti = false;
        
      }
      
      System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
      System.out.println("");
      ( vastus.annaLautaOma() ).tulostaLauta2();
    }
    else{
      temp = tahtaaLinjassa();
      
      System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
      System.out.println("");
      System.out.println("Tekoäly ampui koordinaattiin (" + temp[0] + "," + temp[1] + ")");
      System.out.println("");
      
      if ( ( vastus.annaLaivasto() ).osuikoLaivastoon( temp[0], temp[1]) ){
        
        System.out.println("Tekoäly osui laivaan!");
        System.out.println("");
        ( vastus.annaLautaOma() ).tallennaOsumaKoordinaatit( vastus.annaLaivasto() );
        osui2 = true;// TÄMÄN AVULLA PAREMPI AMPUMISMETODI OSAA ALKAA ETSIÄ OSUMAA LAIVAN SUUNTAISESTI
        //osui3 = true;//
        pisteet += 1;
        
      }
      else{
        
        System.out.println("Tekoäly ampui hudin!");
        System.out.println("");
        ( vastus.annaLautaOma() ).tallennaHutienKoordinaatit( vastus.annaLaivasto() );
        
      }
      if ( uponneita != ( vastus.annaLaivasto() ).yhteensaUpotettu() ){
        
        System.out.println("Tekoäly upotti laivan!!!");
        System.out.println("");
        osui1 = false;// NÄIDEN AVULLA AMPUMISMETODI TIETÄÄ ALKAA HAKEA OSUMAA TAAS SATUNNAISESTI
        osui2 = false;//
        osui3 = true;//
        pakki3huti = false;
        
      }
      
      System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
      System.out.println("");
      ( vastus.annaLautaOma() ).tulostaLauta2();
    }
    
    
  }
  
  // TÄHTÄÄ ENSIMMÄISEN OSUMAN VIEREISEEN RUUTUUN
  public int[] tahtaaViereen(){
    
    Random r = new Random();// Random-OLIOLLA GENEROIDAAN SATUNNAISESTI VIEREINEN RUUTU JOHON AMMUTAAN
    
    int[] temp1 = { osuma1[0] + 1, osuma1[1] };
    int[] temp2 = { osuma1[0] - 1, osuma1[1] };
    int[] temp3 = { osuma1[0], osuma1[1] + 1 };
    int[] temp4 = { osuma1[0], osuma1[1] - 1 };
    
    int[] temp = {osuma1[0],osuma1[1]};
    
    if( 
       
       ( ( !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp1 ) )&&( osuma1[0] + 1 < 10 ) ) || 
       ( ( !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp2 ) )&&( osuma1[0] - 1 > -1 ) ) || 
       ( ( !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp3 ) )&&( osuma1[1] + 1 < 10) ) || 
       ( ( !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp4 ) )&&( osuma1[1] - 1 > -1 ) )   
         
      ) {
      
      do{        
        int k = r.nextInt(4);
        
        temp[0] = osuma1[0];
        temp[1] = osuma1[1];
        
        if ( k == 0 ){
          temp[0] += 1;
        }
        else if ( k == 1 ){
          temp[0] += -1;
        }
        else if ( k == 2 ){
          temp[1] += 1;
        }
        else{
          temp[1] += -1;
        }
      }while( temp[0] < 0 || 9 < temp[0] || temp[1] < 0 || 9 < temp[1] || ( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp ) );// VARMISTETAAN ETTÄ RUUTU JOHON AMMUTAAN ON LAUDALLA EIKÄ SIIHEN OLE JO AMMUTTU
    }
    else{
      
      osui1 = false;
      
      do{
        
        // GENEROIDAAN SATUNNAINEN VAAKAKOORDINAATTI
        int x = r.nextInt(10); 
        // GENEROIDAAN PYSTYKOORDINAATTI
        int y = r.nextInt(10);
        
        temp[0] = x;
        temp[1] = y;
        
      }while( ( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp ) );
    }
    
    return temp;
    
  }
  
  public int[] tahtaaLinjassa(){
    
    int[] temp = {0,0};
    
    // TAPAUS: LAIVA PYSTYSUUNNASSA
    if ( osuma1[0] == osuma2[0] ){
      
      temp[0] = osuma3[0];
      temp[1] = osuma3[1] + 1;
      
      if( osuma3[1] < 9 &&  !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp ) && osui3 ){// HAETAAN OSUMAA KASVAVASTA SUUNNASTA
        osuma3[1] += 1;
        if ( !( ( vastus.annaLaivasto() ).onkoLaivojaPaikassa( osuma3[0], osuma3[1] ) ) ){
          osui3 = false;
          asetaOsuma3Min();
        }
        return temp;//osuma3;
      }
      if ( osui3 ){
        osui3 = false;
        asetaOsuma3Min();
      }
      if ( !pakki3huti ){// HAETAAN OSUMAA VASTAKKAISESTA SUUNNASTA
        temp[1] = osuma3[1] - 1;
        if ( osuma3[1] > 0 &&  !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp ) && osui2 ){
          osuma3[1] += -1;
          if ( !( ( vastus.annaLaivasto() ).onkoLaivojaPaikassa( osuma3[0], osuma3[1] ) ) ){
            pakki3huti = true;
          }
          return osuma3;
        }
      }
    }
    // TAPAUS: LAIVA VAAKASUUNNASSA
    if ( osuma1[1] == osuma2[1] ){
      
      temp[0] = osuma3[0] + 1;
      temp[1] = osuma3[1];
      
      if( osuma3[0] < 9 &&  !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp ) && osui3 ){// HAETAAN SUUNTAA KASVAVASTA SUUNNASTA
        osuma3[0] += 1;
        if ( !( ( vastus.annaLaivasto() ).onkoLaivojaPaikassa( osuma3[0], osuma3[1] ) ) ){
          osui3 = false;
          asetaOsuma3Min();
        }
        return temp;//osuma3;
      }
      if ( osui3 ){
        osui3 = false;
        asetaOsuma3Min();
      }
      if ( !pakki3huti ){// HAETAAN OSUMAA VASTAKKAISESTA SUUNNASTA
        temp[0] = osuma3[0] - 1; 
        if ( osuma3[0] > 0 &&  !( vastus.annaLautaOma() ).onkoHudeissaTaiOsumissa( temp ) && osui2 ){
          osuma3[0] += -1;
          if ( !( ( vastus.annaLaivasto() ).onkoLaivojaPaikassa( osuma3[0], osuma3[1] ) ) ){
            pakki3huti = true;
          }
          return osuma3;
        }
      }
    }
    // XX  XX  XX  XX  XX  XX  XX  XX  TÄSTÄ ETEENPÄIN KÄSITELLÄÄN TAPAUS, JOSSA KAKSI LAIVAA VIEREKKÄIN  XX  XX  XX  XX  XX  XX  XX 
    osui2 = false; 
    osui3 = true;
    temp = tahtaaViereen();
    
    if ( ( vastus.annaLaivasto() ).onkoLaivojaPaikassa( temp[0], temp[1] ) ){
      osui2 = true;
      pakki3huti = false;
      osuma2[0] = temp[0];
      osuma2[1] = temp[1];
      asetaOsuma3Max();
    }
    return temp;
    //  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX  XX
  }
  
  // ASETTAA AIEMPIEN OSUMIEN PERUSTEELLA KOLMANNEN TÄHTÄYSKOORDINAATIN LINJAAN, JOSSA LAIVAN ON OLTAVA
  public void asetaOsuma3Max(){
    
    if ( osuma1[0] == osuma2[0] ){
      osuma3[0] = osuma1[0];
      osuma3[1] = Math.max( osuma1[1],osuma2[1] );// HUOM! TÄSTÄ HAARASTA SAATAVALLA osuma3:LLA TÄHDÄTTÄVÄ + SUUNTAAN KOORDINAATIN 1 SUHTEEN 
    }
    else{
      osuma3[1] = osuma1[1];
      osuma3[0] = Math.max( osuma1[0],osuma2[0] );// HUOM! TÄSTÄ HAARASTA SAATAVALLA osuma3:LLA TÄHDÄTTÄVÄ + SUUNTAAN KOORDINAATIN 0 SUHTEEN 
    }
    
  }
  
  // ASETTAA AIEMPIEN OSUMIEN PERUSTEELLA KOLMANNEN TÄHTÄYSKOORDINAATIN LINJAAN, JOSSA LAIVAN ON OLTAVA
  public void asetaOsuma3Min(){
    
    if ( osuma1[0] == osuma2[0] ){
      osuma3[0] = osuma1[0];
      osuma3[1] = Math.min( osuma1[1],osuma2[1] );// HUOM! TÄSTÄ HAARASTA SAATAVALLA osuma3:LLA TÄHDÄTTÄVÄ + SUUNTAAN KOORDINAATIN 1 SUHTEEN 
    }
    else{
      osuma3[1] = osuma1[1];
      osuma3[0] = Math.min( osuma1[0],osuma2[0] );// HUOM! TÄSTÄ HAARASTA SAATAVALLA osuma3:LLA TÄHDÄTTÄVÄ + SUUNTAAN KOORDINAATIN 0 SUHTEEN 
    }
    
  }
  
}














