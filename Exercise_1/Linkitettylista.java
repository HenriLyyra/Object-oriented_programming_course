/*
Linkitetty lista on tietorakenne, jossa jokainen alkio tiet�� alkion, joka tulee listassa seuraavaksi. 
Toteuta yksisuuntainen linkitetty lista (eli listan alkio tiet�� seuraavan alkion, mutta ei edellist�), 
johon voi tallentaa kokonaislukuja. Toteuttaa tulee siis alkion lis�ys-, poisto- ja hakumetodit.
*/

// HUOM!!! IDEANA OLI TEHD� LISTA, JOSSA ALKIOLLA i ON SEK� OMA KOKONAISLUKUARVONSA JA VIITTAUS ALKIOON i+1. T�SS� RATKAISUSSA N�IN EI OLE
public class Linkitettylista{
  // attribuutit
  private static final int listanPituus = 4; // m��r�� listan koon
  private int[] alkio;
  private int[] seuraavaAlkio;
  
  // konstruktori
  public Linkitettylista(){
    this.alkio = new int[listanPituus + 1];
    this.alkio[listanPituus] = 0;
    this.seuraavaAlkio = new int[listanPituus];
  }
  
  // lis�� alkioita
  public void lisaaAlkiot(int[] n){
    for (int i = 0; i < listanPituus; i++){
     this.alkio[i] = n[i];
    }
    for (int i = 0; i < listanPituus - 1; i++){
     this.seuraavaAlkio[i] = n[i + 1];
    }
  }
  
  // lis�� alkion n paikkaan i
  public void lisaaAlkio(int n, int i){
    if ( i >=  0 && i < listanPituus){
      this.alkio[i] = n;
    }
    if ( i > 0 && i < listanPituus){
      this.seuraavaAlkio[i - 1] = n;
    }
  }

  // poistaa alkion paikkasta i
  public void poistaAlkio(int i){
    if ( i >=  0 && i < listanPituus){
      this.alkio[i] = 0;
    }
    if ( i > 0 && i < listanPituus){
      this.seuraavaAlkio[i - 1] = 0;
    }
  }
  
  public void tulostaLinkitettylista(){
    System.out.println( "TULOSTETAAN LINKITETTY LISTA:");
    for (int i = 0; i < listanPituus; i++){
      System.out.println( "Indeksi: " + i + ", Alkio: " + this.alkio[i] + ", Alkion seuraaja: " + this.seuraavaAlkio[i]);
    }
    System.out.println( "------------------------");
  }
}