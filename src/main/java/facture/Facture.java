package facture;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

public class Facture {
    ArrayList<LigneFacture> l = new ArrayList();
    protected Date emission;
    protected Client destinataire;
    protected int numero;
    
    public Facture(Client destinataire, Date emission, int numero) {
        this.destinataire = destinataire;
        this.emission = emission;
        this.numero = numero;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return emission;
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return destinataire;
    }


    
    public void ajouteLigne(Article a, int nombre, float remise) {
        LigneFacture ligne = new LigneFacture(nombre, this, a, remise);
        l.add(ligne);
        //System.out.println(l);
   }
    
   public float montantTTC(float tauxTVA) {
        float ttc =0;
        for (LigneFacture ligne : l){
           ttc+= (ligne.montantLigne()*(1+tauxTVA));
        }
        return ttc;
   }
   
   public void print(PrintStream out, float tva) {
       for (int i = 0; i<this.l.size(); i++){
           out.println(tva + l.toString());
       }
   }


   
}
