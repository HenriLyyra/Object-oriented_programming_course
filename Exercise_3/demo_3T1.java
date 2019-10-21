/* http://bit.ly/2o0DmcZ
Testataan luokkaa Kuutio ja rajapintaa Kappale. 
*/
public class demo_3T1 {
    public static void main(String[] args) {
      
      double[] kp = {0,0,0};
      
      Kuutio k = new Kuutio(kp, 2);
      
      System.out.print("Kuution keskipisteen koordinaatit ovat ");
      k.tulostaKeskipiste();
      System.out.println("Kuution pinta-ala on " +  k.annaAla() );
      
    }
    
}
