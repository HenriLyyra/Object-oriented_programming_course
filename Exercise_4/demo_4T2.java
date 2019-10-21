/*
Testataan luokkia Jalkapallojoukkue ja Jalkapalloppelaaja. 
*/
public class demo_4T2 {
  
    public static void main(String[] args) {
      
      Jalkapallojoukkue j = new Jalkapallojoukkue("Geneerinen joukkueen nimi", 1 + 22*400, "Stadioni 1");
      
      Jalkapallopelaaja jp0 = new Jalkapallopelaaja("Puo Lustaja", 00, 0,1,900);
      Jalkapallopelaaja jp1 = new Jalkapallopelaaja("Hyök Kääjä", 11, 1,1,400);
      Jalkapallopelaaja jp2 = new Jalkapallopelaaja("Maa Livahti", 22, 2,1,300);
      
      System.out.println( j.maalivahteja() );
      System.out.println( j.kenttapelaajia() );
      
      for (int i = 1; i <= 10; i++){
        try{
          j.lisaaPelaaja(jp0);
        } 
        catch (BudjettiYlitetty by){
          System.out.println("Budjetti ylitetty. Ei voida lisätä pelaajaa.");
        }
        try{
          j.lisaaPelaaja(jp1);
        } 
        catch (BudjettiYlitetty by){
          System.out.println("Budjetti ylitetty. Ei voida lisätä pelaajaa.");
        }
      }
      
      System.out.println("Tulostetaan joukkueen pelaajat lisäysjärjestyksessä:");
      j.tulostaJoukkue();
      
    }
    
}
