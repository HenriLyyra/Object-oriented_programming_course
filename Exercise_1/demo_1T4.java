/*
Testataan luokkia Pelaaja ja Joukkue. 
*/
public class demo_1T4 {
    public static void main(String[] args) {
      // alustetaan ja asetetaan int-tyyppinen lista "numeroita"
      int[] numeroita = {100,11,22,33,44,55};
      
      // luodaan uusi tyhj‰ linkitetty lista
      Linkitettylista numeroitaLL = new Linkitettylista();
      
      // lis‰t‰‰n luotuun joukkueeseen pelaajat
      numeroitaLL.lisaaAlkiot(numeroita);
      
      // Tulostetaan linkitetty lista
      numeroitaLL.tulostaLinkitettylista();
      
      numeroitaLL.lisaaAlkio(122,3);
      
      // Tulostetaan linkitetty lista
      numeroitaLL.tulostaLinkitettylista();
      
      numeroitaLL.poistaAlkio(3);
      
      // Tulostetaan linkitetty lista
      numeroitaLL.tulostaLinkitettylista();

    }
}
