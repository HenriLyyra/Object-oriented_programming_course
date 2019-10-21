/*
Testataan luokkaa Laiva. 
*/
public class demo_1T1 {
    public static void main(String[] args) {
      double[] nopeus = {3/0.5144, 2/0.5144};// Alustetaan laiva-olion nopeus n-ulotteisessa avaruudessa
      Laiva laiva1 = new Laiva( "Titani",10,800,nopeus );// Alustetaan laiva-olio
      double s = 120;// Alustetaan matkan pituus metrein‰
      System.out.println("Laivan " + laiva1.annaNimi() + " vauhti on " + laiva1.laskeVauhti() + " m/s.");
      System.out.println("T‰ll‰ vauhdilla laivan kest‰‰ kulkea " + s + " metrin matka " + Laiva.laskeAika(laiva1,s) + " sekuntia.");
    }
}
