public class Tyokalu {
 
 protected String aani;
 
 public Tyokalu(String aani) {
  this.aani = aani;
 }
 
 public void kayta(){
   System.out.println(aani);
 }

  
}

// VASARA

class Vasara extends Tyokalu{
  
  public Vasara(){
    super("VASARAN KÄYTÖSTÄ JOHTUVAA ÄÄNTÄ!!!");
  }
  
  public String toString(){
    return "Vasara.";
  }
  
}


// HIOMAKONE

class Hiomakone extends Tyokalu implements Ladattava{
  
  boolean ladattu;
  
  public Hiomakone(){
    super("HIOMAKONEEN KÄYTÖSTÄ JOHTUVAA ÄÄNTÄ!!!");
  }
  
  public String toString(){
    String temp2 = "ei ladattu.";
    if (ladattu){
      temp2 = "ladattu.";
    }
    return "Hiomakone, " + temp2;
  }
  
  public void lataa(){
    ladattu = true;
  }
  
  public boolean onkoLadattu(){
    if (ladattu){
      System.out.println("On ladattu.");
      return true;
    }
    System.out.println("Ei ole ladattu.");
    return true;
  }
  
}


// KIRVES

class Kirves extends Tyokalu implements Teroitettava{
  
  boolean teroitettu;
  
  public Kirves(){
    super("KIRVEEN KÄYTÖSTÄ JOHTUVAA ÄÄNTÄ!!!");
  }
  
  public String toString(){
    String temp1 = "ei teroitettu.";
    if (teroitettu){
      temp1 = "teroitettu.";
    }
    return "Kirves, " + temp1;
  }
  
  public void teroita(){
    teroitettu = true;
  }
  
  public boolean onkoTeroitettu(){
    if (teroitettu){
      System.out.println("On teroitettu.");
      return true;
    }
    System.out.println("Ei ole teroitettu.");
    return true;
  }
  
}


// PUUKKO

class Puukko extends Tyokalu implements Teroitettava{
  
  boolean teroitettu;
  
  public Puukko(){
    super("PUUKON KÄYTÖSTÄ JOHTUVAA ÄÄNTÄ!!!");
  }
  
  public String toString(){
    String temp1 = "ei teroitettu.";
    if (teroitettu){
      temp1 = "teroitettu.";
    }
    return "Puukko, " + temp1;
  }
  
  public void teroita(){
    teroitettu = true;
  }
  
  public boolean onkoTeroitettu(){
    if (teroitettu){
      System.out.println("On teroitettu.");
      return true;
    }
    System.out.println("Ei ole teroitettu.");
    return true;
  }
  
}

// SÄHKÖSAHA
class Sahkosaha extends Tyokalu implements Teroitettava, Ladattava{
  
  boolean teroitettu;
  boolean ladattu;
  
  public Sahkosaha(){
    super("SÄHKÖSAHAN KÄYTÖSTÄ JOHTUVAA ÄÄNTÄ!!!");
  }
  
  public String toString(){
    String temp1 = "ei teroitettu, ";
    String temp2 = "ei ladattu.";
    if (teroitettu){
      temp1 = "teroitettu, ";
    }
    if (ladattu){
      temp2 = "ladattu.";
    }
    return "Sähkösaha, " + temp1 + temp2;
  }
  
  public void teroita(){
    teroitettu = true;
  }
  
  public void lataa(){
    ladattu = true;
  }
  
  public boolean onkoTeroitettu(){
    if (teroitettu){
      System.out.println("On teroitettu.");
      return true;
    }
    System.out.println("Ei ole teroitettu.");
    return true;
  }
  
  public boolean onkoLadattu(){
    if (ladattu){
      System.out.println("On ladattu.");
      return true;
    }
    System.out.println("Ei ole ladattu.");
    return true;
  }
  
}


// RAJAPINNAT
interface Teroitettava{
  
  void teroita();
  
  boolean onkoTeroitettu();
  
}

interface Ladattava{
  
  void lataa();
  
  boolean onkoLadattu();
   
}