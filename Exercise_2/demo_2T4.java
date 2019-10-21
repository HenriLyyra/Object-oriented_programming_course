/*
Testataan luokkaa LinkedList 
*/
public class demo_2T4 {
        public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Pelaaja jp0 = new Pelaaja("Puo Lustaja", 00, 0);
        Pelaaja jp1 = new Pelaaja("Hyˆk K‰‰j‰", 11, 1);
        Pelaaja jp2 = new Pelaaja("Maa Livahti", 22, 2);
        
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Lis‰t‰‰n alkiot listaan:");
        list.insert(jp0);
        list.insert(jp1);
        list.insert(jp2);
        
        list.printList();
        
        System.out.println("Poistetaan listan ensimm‰inen alkio:");
        list.delete();
        
        list.printList();
        
        /*
        System.out.println("Tyhjennet‰‰n lista:");
        while(!list.isEmpty()) {
            Link deletedLink = list.delete();
            System.out.print("deleted: ");
            deletedLink.printLink();
            System.out.println("");
        }
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Lista tyhjennetty");
        list.printList();*/
    }
    
}
