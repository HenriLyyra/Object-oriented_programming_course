/*
Testataan luokkia Opiskelija, Opettaja, Kurssi, . 
*/
public class demo_2T3 {
    public static void main(String[] args) {
      
      Lukuvuosi l = new Lukuvuosi(2018);
      
      Periodi p1 = new Periodi();
      
      // Kurssi(String nimi, String aihe)
      Kurssi k1 = new Kurssi("Fysiikka 1", "Mekaniikka");
      Kurssi k2 = new Kurssi("Fysiikka 2", "Thermodynamiikka");
      Kurssi k3 = new Kurssi("Fysiikka 3", "Elektromadnetismi");
      
      // Opiskelija(String nimi, String opiskelijaTunnus)
      Opiskelija o1 = new Opiskelija("Olli", "123456");
      Opiskelija o2 = new Opiskelija("Ossi", "789123");
      Opiskelija o3 = new Opiskelija("Olga", "456789");
      
      // Opettaja(String nimi, int palkka)
      
      Opettaja op1 = new Opettaja("Kokko", 9000);
      Opettaja op2 = new Opettaja("Murtomaa", 4000);
      Opettaja op3 = new Opettaja("Pellonp‰‰", 4000);

      p1.lisaaKurssi(k1);
      
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opiskelijat");
      for ( Opiskelija o : p1.annaOpiskelijat(k1) ){
        System.out.println( o.toString() );
      }
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opettajat");
      for ( Opettaja o : p1.annaOpettajat(k1) ){
        System.out.println( o.toString() );
      }
      
      p1.lisaaHenkiloKurssille(k1, o1);
      
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opiskelijat");
      for ( Opiskelija o : p1.annaOpiskelijat(k1) ){
        System.out.println( o.toString() );
      }
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opettajat");
      for ( Opettaja o : p1.annaOpettajat(k1) ){
        System.out.println( o.toString() );
      }  
      
      p1.lisaaHenkiloKurssille(k1, op1);
      
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opiskelijat");
      for ( Opiskelija o : p1.annaOpiskelijat(k1) ){
        System.out.println( o.toString() );
      }
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opettajat");
      for ( Opettaja o : p1.annaOpettajat(k1) ){
        System.out.println( o.toString() );
      }
      
      p1.poistaHenkiloKurssilta(k1, op1);
      
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opiskelijat");
      for ( Opiskelija o : p1.annaOpiskelijat(k1) ){
        System.out.println( o.toString() );
      }
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opettajat");
      for ( Opettaja o : p1.annaOpettajat(k1) ){
        System.out.println( o.toString() );
      }
      
      p1.poistaHenkiloKurssilta(k1, o1);
      
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opiskelijat");
      for ( Opiskelija o : p1.annaOpiskelijat(k1) ){
        System.out.println( o.toString() );
      }
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opettajat");
      for ( Opettaja o : p1.annaOpettajat(k1) ){
        System.out.println( o.toString() );
      }
      
      
      // Lukuvuosi
      
      l.lisaaPeriodi(p1);
      
      p1.lisaaHenkiloKurssille(k1, op1);
      
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opiskelijat");
      for ( Opiskelija o : l.annaPeriodi(0).annaOpiskelijat(k1) ){
        System.out.println( o.toString() );
      }
      System.out.println("- - - - - - - - - - -");
      System.out.println("Tulostetaan opettajat");
      for ( Opettaja o : l.annaPeriodi(0).annaOpettajat(k1) ){
        System.out.println( o.toString() );
      }
      
     
      
    }
    
}
