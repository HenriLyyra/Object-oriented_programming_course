import java.util.ArrayList;

// BINƒƒRIPUU
public class Binaaripuu {
  
  private Solmu vanhin;
  
  public Binaaripuu(Solmu vanhin){
    this.vanhin = vanhin;
  }
  
  
  public void addOrd(Solmu s){
    addOrdRek( vanhin, s );
  }
  
  // rekursiivinen metodi, joka vertailun avulla lis‰‰ solmun s joko solmun t vasempaan tai oikeaan haaraan, kunnes p‰‰dyt‰‰n lehtiin
  public static void addOrdRek(Solmu t, Solmu s){
    if ( ( t.getSisalto() ).compareTo( s.getSisalto() ) != -1 ){
      if( t.getVasen() == null ){
        t.setVasen(s);
      }
      else {
        addOrdRek( t.getVasen(), s );
      }
    }
    else {
      if( t.getOikea() == null ){
        t.setOikea(s);
      }
      else {
        addOrdRek( t.getOikea(), s );
      }
    }
  }
  
  /* Lis‰t‰‰n Solmu ensimm‰iseen kerrokseen, joka ei ole jo t‰ynn‰. 
   * Lis‰t‰‰n vasemmanpuoleisimman lapsettoman Solmun lapseksi. 
   * lis‰t‰‰n vasemmanpuoleiseksi lapseksi. jos vasemmanpuoleinen on jo olemassa, lis‰t‰‰n oikeanpuoleiseksi
   * */
  public void add(Solmu solmu){
    int k = 1;
    while( this.onkoSukupolviTaysi(k) ){
      k += 1;
    }
    int i = 0;
    while( (this.annaSukupolvi(k) ).get(i) != null ){
      i += 1;
    }
    (( this.annaSukupolvi(k - 1) ).get(i/2) ).addPerillinen(solmu);
  }
  
  // palauttaa true, jos sukupolvi k on t‰ysi
  public boolean onkoSukupolviTaysi(int k){
    for (int i = 0; i <= Math.pow(k,2) - 1; i++){
      if ( (this.annaSukupolvi(k) ).get(i) == null){
        return false;
      }
    }
    return true;
  }
  
  // tulostaa sukupolven k
  public void tulostaSukupolvi(int k){
    for (Object s : this.annaSukupolvi(k)){
      if ( s != null){
        System.out.print(((Solmu)s ).getSisalto() + " ");// yleisess‰ tapauksessa: System.out.print( (((Solmu)s ).getSisalto() ).toString() + " ");
      }
    }
    System.out.println("");
  }
  
  // Palauttaa bin‰‰ripuun sukupolven k alkion i
  public Solmu annaAlkio(int k, int i){
    System.out.println(( this.annaSukupolvi(k) ).size());
    if ( ( this.annaSukupolvi(k) ).size() < i  ){
      return (Solmu)( ( this.annaSukupolvi(k) ).get(i) );
    }
    System.out.println("Kyseisess‰ paikassa ei alkiota, palautettiin vanhin.");
    return vanhin;
  }
  
  // Palauttaa bin‰‰ripuun sukupolven k
  public ArrayList<Solmu> annaSukupolvi(int k){
    ArrayList<Solmu> sukupolvi = new ArrayList<Solmu>();
    sukupolvi.add(vanhin);
    for (int i = 1; i <= k; i++){
      ArrayList<Solmu> temp = new ArrayList<Solmu>();
      for (Solmu s : sukupolvi){
        temp.add( (Solmu)s.getVasen() );
        temp.add( (Solmu)s.getOikea() );
        sukupolvi = temp;
      }
    }
    return sukupolvi;
  }
  
  
}

// SOLMU
class Solmu<T extends Comparable<T>> {
  
  private T sisalto;
  private Solmu lv;
  private Solmu lo;
  
  public Solmu(T sisalto){
    this.sisalto = sisalto;
  }
  
  public void addPerillinen(Solmu perillinen){
    if (lv == null){
      lv = perillinen;
    }
    else if (lo == null){
      lo = perillinen;
    }
  }
  
  public T getSisalto(){
    return sisalto;
  }
  
  public Solmu getVasen(){
    return lv;
  }
  
  public Solmu getOikea(){
    return lo;
  }
  
  public void setVasen(Solmu s){
    lv = s;
  }
  
  public void setOikea(Solmu s){
    lo = s;
  }
  
}