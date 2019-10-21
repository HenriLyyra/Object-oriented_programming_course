/*
Testataan luokkia Jalkapallojoukkue ja Jalkapalloppelaaja. 
*/
public class demo_2T2 {
    public static void main(String[] args) {
      
      // Jalkapallojoukkue(String nimi, /*Stadion kotistadioni */ String kotistadioni)
      // lisaaPelaaja(Pelaaja p)
      Jalkapallojoukkue j = new Jalkapallojoukkue("Geneerinen joukkueen nimi", "Stadioni 1");
      
      // Pelaaja(String nimi, int pelinumero, int pelipaikka)
      Pelaaja p0 = new Pelaaja("Puo Lustaja", 00, 0);
      Pelaaja p1 = new Pelaaja("Hyök Kääjä", 11, 1);
      Pelaaja p2 = new Pelaaja("Maa Livahti", 22, 2);
      
      // Jalkapallopelaaja(String nimi, int pelinumero, int pelipaikka, int jalkaisuus, int viikkopalkka)
      Pelaaja jp0 = new Jalkapallopelaaja("Puo Lustaja", 00, 0,1,100);
      Pelaaja jp1 = new Jalkapallopelaaja("Hyök Kääjä", 11, 1,1,200);
      Pelaaja jp2 = new Jalkapallopelaaja("Maa Livahti", 22, 2,1,300);
      
      System.out.println( j.maalivahteja() );
      System.out.println( j.kenttapelaajia() );
      
      for (int i = 1; i <= 20; i++){
        j.lisaaPelaaja(jp0);
      }
      
      System.out.println( j.maalivahteja() );
      System.out.println( j.kenttapelaajia() );
      
      for (int i = 1; i <= 2; i++){
        j.lisaaPelaaja(p2);
      }
      
      j.tulostaJoukkue();

    }
    
}
