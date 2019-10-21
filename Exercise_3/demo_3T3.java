/*
Testataan Tyokalupakkia ja työkaluja. 
*/
public class demo_3T3 {
    public static void main(String[] args) {
      
      Vasara v1 = new Vasara();
      Hiomakone h1 = new Hiomakone();
      Kirves k1 = new Kirves();
      Puukko p1 = new Puukko();
      Sahkosaha s1 = new Sahkosaha();
      
      /*// TESTATAAN TEROITUS-METODIA
      p1.onkoTeroitettu();
      
      p1.kayta();
      
      p1.teroita();
      
      p1.onkoTeroitettu();
      */
      
      Tyokalupakki t = new Tyokalupakki();
      
      t.lisaaTyokalu(v1);
      t.lisaaTyokalu(h1);
      t.lisaaTyokalu(k1);
      t.lisaaTyokalu(p1);
      t.lisaaTyokalu(s1);
      
      t.tulostaTyokalupakki();
      
      t.huollaTyokalut();
      
      t.tulostaTyokalupakki();
      
      t.kaytaKaikkia();
      
    }
    
}
