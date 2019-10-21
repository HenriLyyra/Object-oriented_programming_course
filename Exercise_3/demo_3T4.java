/*
Testataan luokkaa Binaaripuu. 
*/
public class demo_3T4 {
    public static void main(String[] args) {
      
      Solmu s = new Solmu<String>("Kantais‰");
      
      // 1. sukupolvi
      Solmu v1 = new Solmu<String>("1. Vasen lapsi");
      Solmu o1 = new Solmu<String>("1. Oikea lapsi");
      
      // 2. sukupolvi
      Solmu v11 = new Solmu<String>("1.1. Vasen lapsi");
      Solmu o11 = new Solmu<String>("1.1. Oikea lapsi");
      Solmu v12 = new Solmu<String>("1.2. Vasen lapsi");
      Solmu o12 = new Solmu<String>("1.2. Oikea lapsi");
      
      // 3. sukupolvi
      Solmu v111 = new Solmu<String>("1.1.1. Vasen lapsi");
      Solmu v112 = new Solmu<String>("1.1.1. Oikea lapsi");
      Solmu o111 = new Solmu<String>("1.1.2. Vasen lapsi");
      Solmu o112 = new Solmu<String>("1.1.2. Oikea lapsi");
      Solmu v121 = new Solmu<String>("1.2.1. Vasen lapsi");
      Solmu v122 = new Solmu<String>("1.2.1. Oikea lapsi");
      Solmu o121 = new Solmu<String>("1.2.2. Vasen lapsi");
      Solmu o122 = new Solmu<String>("1.2.2. Oikea lapsi");
      
      // lis‰t‰‰n solmuille perillisi‰
      s.addPerillinen(v1);
      s.addPerillinen(o1);
      
      v1.addPerillinen(v11);
      v1.addPerillinen(o11);
      
      o1.addPerillinen(v12);
      o1.addPerillinen(o12);
      
      // testataan, ett‰ k‰sin lis‰tyt on lis‰tty onnistuneesti
      System.out.println( s.getSisalto() );
      System.out.println( ( s.getVasen() ).getSisalto() );
      System.out.println( ( s.getOikea() ).getSisalto() );
      
      System.out.println( "- - - - VASEMMAN LAPSEN JƒLKIKASVU - - - - " );
      System.out.println( v1.getSisalto() );
      System.out.println( ( v1.getVasen() ).getSisalto() );
      System.out.println( ( v1.getOikea() ).getSisalto() );
      
      System.out.println( "- - - - OIKEAN LAPSEN JƒLKIKASVU - - - - " );
      System.out.println( o1.getSisalto() );
      System.out.println( ( o1.getVasen() ).getSisalto() );
      System.out.println( ( o1.getOikea() ).getSisalto() );
      
      
      // luodaan bin‰‰ripuu b
      Binaaripuu b = new Binaaripuu(s);
      
      // tulostetaan jo olemassa olevat sukupolvet
      System.out.println( "- - - - 1. SUKUPOLVI - - - - " );
      b.tulostaSukupolvi(1);
      
      System.out.println( "- - - - 2. SUKUPOLVI - - - - " );
      b.tulostaSukupolvi(2);
      
      /*
       * v111        * v112        * o111        * o112       
       * v121        * v122        * o121        * o122 
       * */
      
      // lis‰t‰‰n bin‰‰ripuuhun uusia alkioita
      b.add(v111);       b.add(v112);      b.add(o111);      b.add(o112);
      b.add(v121);       b.add(v122);      //b.add(o121);      b.add(o122);
      
      // tulostetaan bin‰‰ripuun uusi sukupolvi 3
      System.out.println( "- - - - 3. SUKUPOLVI - - - - " );
      b.tulostaSukupolvi(3);
      
      // lis‰t‰‰n bin‰‰ripuuhun uusia alkioita
      b.add(o121);      b.add(o122);
      
      // tulostetaan bin‰‰ripuun uusi sukupolvi 3
      System.out.println( "- - - - 3. SUKUPOLVI - - - - " );
      b.tulostaSukupolvi(3);
      
      // HUOM!!! HAKUKOMENTO EI JOSTAIN SYYSTƒ TOIMI: ANTAA OUTOFBOUNDS
      System.out.println( ( b.annaAlkio(3,7) ).getSisalto() );
      
    }
    
}
