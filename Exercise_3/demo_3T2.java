/*
Testataan luokkia Jalkapallojoukkue ja Jalkapalloppelaaja. 
*/
public class demo_3T2 {
    public static void main(String[] args) {
      
      // Jalkapallojoukkue(String nimi, /*Stadion kotistadioni */ String kotistadioni)
      // lisaaPelaaja(Pelaaja p)
      Jalkapallojoukkue j = new Jalkapallojoukkue("Geneerinen joukkueen nimi", "Stadioni 1");
      
      // Jalkapallopelaaja(String nimi, int pelinumero, int pelipaikka, int jalkaisuus, int viikkopalkka)
      Jalkapallopelaaja jp0 = new Jalkapallopelaaja("Puo Lustaja", 00, 0,1,100);
      Jalkapallopelaaja jp1 = new Jalkapallopelaaja("Hyök Kääjä", 11, 1,1,200);
      Jalkapallopelaaja jp2 = new Jalkapallopelaaja("Maa Livahti", 22, 2,1,300);
      
      System.out.println( j.maalivahteja() );
      System.out.println( j.kenttapelaajia() );
      
      for (int i = 1; i <= 10; i++){
        j.lisaaPelaaja(jp0);
        j.lisaaPelaaja(jp1);
      }
      
      System.out.println( j.maalivahteja() );
      System.out.println( j.kenttapelaajia() );
      
      for (int i = 1; i <= 2; i++){
        j.lisaaPelaaja(jp2);
      }
      
      j.tulostaJoukkue();

      System.out.println("Tulostetaan joukkueen pelaajat palkkajärjestyksessä:");
      j.tulostaJoukkueJarjestyksessa();
      
      System.out.println("Tulostetaan joukkueen pelaajat lisäysjärjestyksessä:");
      j.tulostaJoukkue();
      
      // Tulostetaan joukkueen 3 korkeapalkkaisinta pelaajaa
      j.tulostaKalleimpia(3);
      
    }
    
}
