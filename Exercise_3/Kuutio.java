public class Kuutio extends Sijaitseva implements Kappale {
  
  double sivunpituus;
 
  public Kuutio(double[] kp, double sivunpituus){
    super(kp);
    this.sivunpituus = sivunpituus;
  }
  
  public double annaAla(){
    return 6*Math.pow(sivunpituus,2);
  }
  //public double[] annaKeskipiste();

}