package facture;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactureTest {

	Catalogue catalogue;
	Client bastide;
	Facture f;
	Article disk, iPad;

	@Before
	public void setUp() {
		catalogue = new Catalogue();
		/// "disk" : code de l'article
		disk = new Article("disk", "Disque 2To", 100f);
		iPad = new Article("ipad", "IPad 2", 700f);
		catalogue.addArticle(disk);
		catalogue.addArticle(iPad);

		bastide = new Client("Rémi Bastide", "Rue du Bac, Castres");
		int numeroFacture = 345;
		f = new Facture(bastide, new Date(2017,12,12), numeroFacture);
		f.ajouteLigne(iPad, 1, 0f); // 700€, 0% de remise
		f.ajouteLigne(disk, 5, 0.1f); //5*100€, 10% de remise

	}

	@Test
	public void testCatalogue() {
		assertSame(iPad, catalogue.findByCode("ipad"));
		assertSame(disk, catalogue.findByCode("disk"));		
	}
	
	@Test
	public void testTTC() {
		float tva = 0.2f;
		float expected = (1*iPad.getPrix() + 5*disk.getPrix()*(0.9f)) * (1+tva);
		assertEquals(expected, f.montantTTC(tva), 0.001f);
                
        }
        
        @Test
        public void testGetteur(){
            assertEquals(345, f.getNumero());
            assertEquals(new Date(2017,12,12), f.getEmission());
            assertEquals(bastide,f.getDestinataire());
            assertEquals("Rémi Bastide", bastide.getName());
            assertEquals("Rue du Bac, Castres", bastide.getAddress());
            assertEquals("Disque 2To",disk.getNom());
            assertEquals("disk", disk.getCode());
        }
        @Test
        public void testLigneFacture(){
            LigneFacture lf = new LigneFacture(10, f, disk, 0.2f);
            assertEquals(10, lf.getNombre());
            assertEquals(f, lf.getFigureDans());
            assertEquals(disk, lf.getArticleFacture());
            assertEquals(0.2, lf.getTauxRemise(), 0.1 );
            
            }
        

}
