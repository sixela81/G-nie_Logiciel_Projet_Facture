/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facture;
import java.util.Date;

/**
 *
 * @author alexi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Article a = new Article("B80", "ballon", 80);
        Article b = new Article("B90", "ballon cdm", 90);
        Article c = new Article("KB9", "Maillot Karim", 9.5f);
        Article a1 = new Article("a1", "Disque 2To", 100);
        Article a2 = new Article("a2", "IPad 2", 700);
        Catalogue cat = new Catalogue();
        Client cl = new Client("Alexis", "Castres");
        Facture f = new Facture(cl, date("19/05/2011"), 5);
        cat.addArticle(a);
        cat.addArticle(b);
        cat.addArticle(c);
        System.out.println(cat.findByCode("KB9"));
        
        
    }

    private static Date date(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
