/*
Toteuta luokka Pelaaja. 
Luokan tulee sis‰lt‰‰ ainakin attribuutit: 
nimi, numero ja pelipaikka.
*/
import java.util.Arrays;
public class Pelaaja{
  // Attribuutit
  private String nimi;
  private int numero;
  private String pelipaikka;
  
  // kelvollinen konstruktori
  public Pelaaja(String nimi, int numero, String pelipaikka){
    this.nimi = nimi;
    this.numero = numero;
    if( Arrays.asList("hyokkaaja","puolustaja","maalivahti").contains(pelipaikka) ){
      this.pelipaikka = pelipaikka;
    }
    else{
      this.pelipaikka = "vilttiketju";
    }
  } 
  
  // geneerinen konstruktori
  public Pelaaja(){
  } 
  
  // palauttaa pelaajan nimen
  public String annaNimi(){
    if (this.nimi == null){
      return "eiNimea";
    }
    else{
      return nimi;
    }
  }  
  
  // palauttaa pelaajanumeron
  public int annaNumero(){
    return numero;
  }  
  
  // palauttaa pelipaikan
  public String annaPelipaikka(){
    return pelipaikka;
  }
  
}