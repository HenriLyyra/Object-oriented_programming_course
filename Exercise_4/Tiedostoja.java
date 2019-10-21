import java.io.*;

public class Tiedostoja {
  
  public static void main(String args[])throws IOException {
    
    kirjoitaNumerot(2, "testi");
    
    lueNumerot("testi.txt");
    
  }
  
  public static int lueNumerot(String polku) throws IOException{
    
    // luo uuden FileReader olion
    FileReader fr = new FileReader(polku); 
    char [] a = new char[30];
    fr.read(a);   // lukee tiedoston sisällön
    fr.close();
    
    int summa = 0;
    for(char c : a){
      if ( Character.isDigit(c) ){
        summa += c;   // summaa tiedostosta luetut luvut
        summa = summa - 48;
      }
    }
    System.out.println("Tiedostoon tallenettujen alkioiden summa on " + summa);
    return summa;
  }
  
  /*
   for(char c : a){
   System.out.print(c);   // tiedoston luvut yksitellen
   }
   fr.close();
   }
   */
  public static void kirjoitaNumerot(int maara, String polku) throws IOException{  
    
    String nimi = polku + ".txt"; 
    File file = new File( nimi );
    
    // luo uuden tiedoston
    file.createNewFile();
    
    PrintWriter pwriter = new PrintWriter( nimi );
    
    // tallennetaan allekkain kokonaisluvut 1 - maara
    for(int i = 0; i <= maara; i++){
      String s = Integer.toString(i);
      pwriter.println(s); 
    }
    pwriter.flush();
    pwriter.close();
  }
  
}