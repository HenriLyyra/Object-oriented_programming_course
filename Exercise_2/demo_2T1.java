/*
Testataan luokkia Rahtilaiva ja Autolautta. 
*/
public class demo_2T1 {
    public static void main(String[] args) {
      //Rahtilaiva(String nimi, double pituus, double syvays, double nopeus, double kapasiteetti, double rahti)
      Rahtilaiva rL = new Rahtilaiva("Anic", 10, 2, 100, 100, 0);
      // getRahti(); getNopeus(); lisaaRahtia(); poistaRahtia();
      
      /*
      System.out.println("- - - - - - - -");
      System.out.println("RAHTILAIVA");
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( rL.getNopeus() );
      
      rL.lisaaRahtia(20);
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( rL.getNopeus() );
      
      rL.poistaRahtia(10);
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( rL.getNopeus() );
      
      rL.lisaaRahtia(20);
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( rL.getNopeus() );
      
      rL.poistaRahtia(30);
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( rL.getNopeus() );
      
      rL.lisaaRahtia(100);
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( rL.getNopeus() );
      
      rL.poistaRahtia(30);
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( rL.getNopeus() );
      
      */
      
        System.out.println("- - - - - - - -");
        System.out.println("AUTOLAUTTA");
        
      //Autolautta(String nimi, double pituus, double syvays, double nopeus, int kapasiteetti, int matkustajaMaara, int autojenMaara)
      Autolautta aL = new Autolautta("Tit", 10, 2, 100, 100, 0, 0);
      // getNopeus(); poistaMatkustajia(); poistaAutoa(); lisaaMatkustajia(); lisaaAutoja(); getMatkustajat(); getAutot();
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( aL.getNopeus() );
      
      aL.lisaaMatkustajia(18);
      
      System.out.println("Tulostetaan nopeus:");
      System.out.println( aL.getNopeus() );
      
      aL.lisaaAutoja(1);
      
      System.out.println( aL.getMatkustajat() );
      System.out.println( aL.getAutot() );
      System.out.println("Tulostetaan nopeus:");
      System.out.println( aL.getNopeus() );
      
      
      aL.poistaMatkustajia(10);
      aL.poistaAutoja(7);
      System.out.println( aL.getMatkustajat() );
      System.out.println( aL.getAutot() );
      System.out.println("Tulostetaan nopeus:");
      System.out.println( aL.getNopeus() );

    }
}
