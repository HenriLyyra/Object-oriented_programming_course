public class Henkilo{
  protected final String nimi;
  
  public Henkilo(String nimi){
    this.nimi = nimi;
  }
 
}

class Opiskelija extends Henkilo{
  private final String opiskelijaTunnus;
  
  public Opiskelija(String nimi, String opiskelijaTunnus){
    super(nimi);
    this.opiskelijaTunnus = opiskelijaTunnus;
  }
  
  public String toString(){
    return "Nimi: " + super.nimi + ", Opiskelijatunnus: " + opiskelijaTunnus;
  }
  
}

class Opettaja extends Henkilo{
  private final int palkka;
  
  public Opettaja(String nimi, int palkka){
    super(nimi);
    this.palkka = palkka;
  }
  
  public String toString(){
    return "Nimi: " + super.nimi + ", Palkka: " + palkka;
  }
  
}