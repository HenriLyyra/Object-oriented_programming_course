/*
Testataan luokkaa Binaaripuu. 
*/
public class demo_4T4 {
    public static void main(String[] args) {
      
      Solmu s01 = new Solmu<Integer>(7);
      Solmu s02 = new Solmu<Integer>(7);
      
      // luodaan bin‰‰ripuu b
      Binaaripuu b1 = new Binaaripuu(s01);
      Binaaripuu b2 = new Binaaripuu(s02);
      
      // lis‰tt‰v‰t alkiot
      Solmu s1 = new Solmu<Integer>(2);
      Solmu s2 = new Solmu<Integer>(12);
      Solmu s3 = new Solmu<Integer>(20);
      Solmu s4 = new Solmu<Integer>(6);
      Solmu s5 = new Solmu<Integer>(5);
      Solmu s6 = new Solmu<Integer>(0);
      Solmu s7 = new Solmu<Integer>(-6);
      Solmu s8 = new Solmu<Integer>(-600);
      
      Solmu[] lista1 = {s1,s2,s3,s4/*,s5,s6,s7,s8*/};
      Solmu[] lista2 = {s6,s3,s8,s4,s5,s1,s7,s2};
      
      for (int i = 0; i < lista1.length; i++){
        b1.addOrd( lista1[i] );
      }
      
      for (int i = 0; i < lista2.length; i++){
        b2.addOrd( lista2[i] );
      }
      
      
      // tulostetaan sukupolvet
      System.out.println( "- - - - 0. SUKUPOLVI - - - - " );
      b1.tulostaSukupolvi(0);
      b2.tulostaSukupolvi(0);
      
      System.out.println( "- - - - 1. SUKUPOLVI - - - - " );
      b1.tulostaSukupolvi(1);
      b2.tulostaSukupolvi(1);
      
      System.out.println( "- - - - 2. SUKUPOLVI - - - - " );
      b1.tulostaSukupolvi(2);
      b2.tulostaSukupolvi(2);
      
      
      
    }
    
}
