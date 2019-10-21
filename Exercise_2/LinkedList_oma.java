public class LinkedList_oma {
 
 public static void main(String[] main){
  LinkedList lista = new LinkedList(); //tyhjä lista
  lista.printList();
  
  lista.lisaaSolmu(new Solmu(3));
  lista.lisaaSolmu(new Solmu(1));
  lista.lisaaSolmu(new Solmu(6));
  
  lista.tulostaLista();
  
  //tulostaa muistiosoitteen, josta solmu-olio löytyy; jos halutaan tulostaa solmun oikea arvo, täytyy Solmu-luokkaan toteuttaa toString-metodi
  System.out.println(lista.hae(3));
  System.out.println(lista.hae(7));
  System.out.println(lista.hae(6));
  
  System.out.println("\nPoistetaan kaikki paitsi solmu, jonka arvo on 1");
  
  lista.poista(3);
  lista.poista(6);
  
  System.out.println(lista.hae(3));
  System.out.println(lista.hae(6));
  
  System.out.println("\nKoko lista:");
  lista.tulostaLista();
 }
 
 Solmu alku = null;
 
 public void lisaaSolmu(Solmu s){
  //eka alkio
  if(alku == null){
   alku = s;
   return;
  }
  
  Solmu nykyinen = alku;
  //vain listan viimeinen solmu.annaSeuraava palauttaa null
  while(nykyinen.annaSeuraava() != null){
   nykyinen = nykyinen.annaSeuraava();
  }
  nykyinen.asetaSeuraava(s);
 }
 
 public void poista(int i){
  
  //lista tyhjä tai viimeinen alkio
  if(alku == null || alku.annaSeuraava() == null){
   alku = null;
   return;
  }
  
  if(alku.annaArvo() == i){
   alku = alku.annaSeuraava();
   return;
  }
  
  Solmu nykyinen = alku;
  while(nykyinen.annaSeuraava() != null){   
   Solmu seuraava = nykyinen.annaSeuraava();
   if(seuraava.onkoArvo(i)){
    //asetetaan nykyisen seuraavaksi seuraavan seuraava
    //hypätään siis yhden yli
    nykyinen.asetaSeuraava(seuraava.annaSeuraava());
   }else{
    nykyinen = seuraava;
   }
  }
 }
 
 public Solmu hae(int i){
  if(alku == null)
   return null;
  
  Solmu nykyinen = alku;
  
  while(nykyinen != null && !nykyinen.onkoArvo(i)){
   nykyinen = nykyinen.annaSeuraava();
  }
  
  return nykyinen;
 }
 
 public void tulostaLista(){
  Solmu nykyinen = alku;
  
  if(nykyinen == null){
   System.out.println("Lista on tyhjä.");
   return;
  }
  
  System.out.println(nykyinen.annaArvo());
  
  //vain listan viimeinen solmu.annaSeuraava palauttaa null
  while(nykyinen.annaSeuraava() != null){
   nykyinen = nykyinen.annaSeuraava();
   System.out.println(nykyinen.annaArvo());
  }
 }
}

class Solmu{
 //listan seuraava solmu; null, jos solmuinstanssi on listan viimeinen
 private Solmu seuraava = null;
 private final int arvo;
 
 public Solmu(int arvo){
  this.arvo = arvo;
 }
 
 public int annaArvo(){
  return arvo;
 }
 
 public boolean onkoArvo(int arvo){
  return this.arvo == arvo;
 }
 
 public void asetaSeuraava(Solmu s){
  seuraava = s;
 }
 
 public Solmu annaSeuraava(){
  return seuraava;
 }
}