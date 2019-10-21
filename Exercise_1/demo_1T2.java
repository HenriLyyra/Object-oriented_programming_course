/*
Testataan luokkia Pelaaja ja Joukkue. 
*/
public class demo_1T2 {
    public static void main(String[] args) {
      Pelaaja p0 = new Pelaaja("Pekko Hyˆkk‰‰j‰", 17, "hyokkaaja");
      Pelaaja p1 = new Pelaaja("Maali Vahti", 21, "maalivahti");
      Pelaaja p2 = new Pelaaja("Risto Puolustaja", 58, "puolustaja");
      Pelaaja[] pelaajaLista = {p0,p1,p2};
      
      // luodaan uusi tyhj‰ joukkue
      Joukkue pelicans = new Joukkue();
      
      pelicans.tulostaJoukkuetiedot();
      
      // lis‰t‰‰n luotuun joukkueeseen pelaajat
      pelicans.lisaaPelaajia(pelaajaLista);
      
      pelicans.tulostaJoukkuetiedot();
      
      // lis‰t‰‰n indeksin 1 kohdalle pelaaja p2
      pelicans.lisaaPelaaja(p2,1);  
      
      pelicans.tulostaJoukkuetiedot();

      // poistetaan nykyinen pelaaja indeksin 1 kohdalta
      pelicans.poistaPelaaja(1);
      
      pelicans.tulostaJoukkuetiedot();

    }
}
