import java.util.ArrayList;

// JOUKKUE
public class Tyokalupakki {
 
 protected ArrayList<Tyokalu> tyokalut;
 
 public Tyokalupakki(){
  tyokalut = new ArrayList<Tyokalu>();
 }
 
 public void lisaaTyokalu(Tyokalu t){
  tyokalut.add(t);
 }
 
 public boolean poistaTyokalu(Tyokalu t){
  return tyokalut.remove(t);
 }
 
 /*
 public String toString(){
  String temp = "Pakissa tökalut:\n";
   for(Tyokalu t : tyokalut){
   temp += t.toString()+"\n";
  }
  return temp;
 }
 */
 
 public void kaytaKaikkia(){
   for (Tyokalu t : tyokalut){
     t.kayta();
   }
 }
 
 public void huollaTyokalut(){
   this.teroitaTerotettavat();
   this.lataaLadattavat();
   System.out.println("KAIKKI TYÖKALUT HUOLLETTU");
   System.out.println("- - - - - - - - - - - - - - - - - -");
 }
 
 public void teroitaTerotettavat(){
   for (Tyokalu t : tyokalut){
     if (t instanceof Teroitettava){
       ((Teroitettava)t ).teroita();
     }
   }
   System.out.println("TEROITETTAVAT TEROITETTU");
   System.out.println("- - - - - - - - - - - - - - - - - -");
 }
 
 public void lataaLadattavat(){
   for (Tyokalu t : tyokalut){
     if (t instanceof Ladattava){
       ((Ladattava)t ).lataa();
     }
   }
   System.out.println("LADATTAVAT LADATTU");
   System.out.println("- - - - - - - - - - - - - - - - - -");
 }
 
 public void tulostaTyokalupakki(){
     System.out.println("- - - - - - - - - - - - - - - - - -");
     System.out.println("TULOSTETAAN PAKIN TYÖKALUT:");
     for (Tyokalu t : tyokalut){
       System.out.println(t.toString());
     }
     System.out.println("- - - - - - - - - - - - - - - - - -");
   }
 
}