/*
Toteuta luokka Joukkue. 
Joukkue sis‰lt‰‰ n pelaajaa ja sen tulee sis‰lt‰‰ toiminnallisuudet 
pelaajien lis‰‰minen 
pelaajan poistaminen
kaikkien joukkueen pelaajien tulostaminen tietoineen
*/
public class Joukkue{
  // attribuutit
  private static final int pelaajaMaara = 3; // m‰‰r‰‰ joukkueen koon
  private Pelaaja[] p;
  
  // konstruktori
  public Joukkue(){
    this.p = new Pelaaja[pelaajaMaara];
  }
  
  // lis‰‰ pelaajia
  public void lisaaPelaajia(Pelaaja[] pelaajia){
    for (int i = 0; i < pelaajaMaara; i++){
     this.p[i] = pelaajia[i];
    }
  }
    
  // lis‰‰ pelaajan paikalle "pelaaja" i
  public void lisaaPelaaja(Pelaaja pelaaja, int i){
      this.p[i] = pelaaja;
  }
         
  // poistaa pelaajan paikalta i
  public void poistaPelaaja(int i){
    this.p[i] = new Pelaaja();
  }  
  
  // palauttaa pelaajan paikalta i
  public Pelaaja annaPelaaja(int i){
    return this.p[i];
  }  
  
  // tulostaa pelaajan i tiedot
  public void tulostaPelaajatiedot(int i){
    if ( (this.p[i] == null) || ( (this.p[i]).annaNimi() == "eiNimea" ) ){
      System.out.println("Ei pelaajaa.");
    }
    else{
      System.out.println(
                         "Pelaajan nimi: " + ( this.p[i] ).annaNimi()
                           + ", Pelaajan numero: " + ( this.p[i] ).annaNumero()
                           + ", Pelaajan pelipaikka: " + ( this.p[i] ).annaPelipaikka()
                        );
    }
  }
  
  // tulostaa koko joukkueen tiedot
  public void tulostaJoukkuetiedot(){
    System.out.println("JOUKKUEEN KOKOONPANO:");
    for ( int i = 0; i < pelaajaMaara; i++){
      System.out.print("Pelaajan indeksi: " + i + " ");
      this.tulostaPelaajatiedot(i);
    }
    System.out.println("---------------------------------------------------------------");
  }
  
  // palauttaa listan pelaajista HUOM: EI TARVITTU
    public Pelaaja[] annaPelaajat(){
    return p;
  }
    
   // vaihtaa kaikki pelaajat HUOM: EI TARVITTU
        public void vaihdaPelaajat(Pelaaja[] pelaajat){
          p = pelaajat;
  }

}