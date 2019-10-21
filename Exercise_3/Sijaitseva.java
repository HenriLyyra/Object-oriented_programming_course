public class Sijaitseva{
  
  protected double[] keskipiste = new double[3];
  
  public Sijaitseva(double[] kp){
    this.keskipiste = kp;
  }
  
  public double[] annaKeskipiste(){
    return keskipiste;
  }
  
  public void tulostaKeskipiste(){
      System.out.println("x = " + keskipiste[0] + ", y = " + keskipiste[1] + ", z = " + keskipiste[2] + ".");
  }
  
}
  
// RAJAPINTA
interface Kappale{
  
  double annaAla();
  double[] annaKeskipiste();
  
}