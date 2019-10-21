/*
Linkitetty lista on tietorakenne, jossa jokainen alkio tietää alkion, joka tulee listassa seuraavaksi. 
Toteuta yksisuuntainen linkitetty lista (eli listan alkio tietää seuraavan alkion, mutta ei edellistä), 
johon voi tallentaa kokonaislukuja. Toteuttaa tulee siis alkion lisäys-, poisto- ja hakumetodit.
*/

// HUOM!!! IDEANA OLI TEHDÄ LISTA, JOSSA ALKIOLLA i ON SEKÄ OMA KOKONAISLUKUARVONSA JA VIITTAUS ALKIOON i+1. TÄSSÄ RATKAISUSSA NÄIN EI OLE
public class Linkitettylista{
  // attribuutit
  private static final int listanPituus = 4; // määrää listan koon
  private int[] alkio;
  private int[] seuraavaAlkio;
  
  // konstruktori
  public Linkitettylista(){
    this.alkio = new int[listanPituus + 1];
    this.alkio[listanPituus] = 0;
    this.seuraavaAlkio = new int[listanPituus];
  }
  
  // lisää alkioita
  public void lisaaAlkiot(int[] n){
    for (int i = 0; i < listanPituus; i++){
     this.alkio[i] = n[i];
    }
    for (int i = 0; i < listanPituus - 1; i++){
     this.seuraavaAlkio[i] = n[i + 1];
    }
  }
  
  // lisää alkion n paikkaan i
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