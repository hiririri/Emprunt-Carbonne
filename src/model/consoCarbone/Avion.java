package model.consoCarbone;

/**
 * A Alimentation objet is an AppEmpruntCarbonAvion
 * who calculates the carbon footprint of air travel.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 1.0
 */
public class Avion extends Transport{
    /**
     * Air travel or not
     */
    private boolean voyagerEnAvion;

    /**
     * Airplane's size
     */
    private TailleAvion tailleA;

    /**
     * Class constructor specifying possession, size, kilometer and amortization of Avion.
     *
     * @param tailleA    size of Avion
     * @param kilomAnnee kilometer of Avion
     */
    public Avion(TailleAvion tailleA, int kilomAnnee) {
        super();

        this.voyagerEnAvion = true;
        this.setKilomAnnee(kilomAnnee);
        this.tailleA = tailleA;
        this.calculImpact();
    }

    /**
     * Instantiates a new Avion.
     */
    public Avion() {
        super();
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbone of Avion.
     */
    @Override
    public void calculImpact() {
        this.impact = this.voyagerEnAvion ? this.tailleA.emet * this.getKilomAnnee() : 0;
    }


   /**
    * Methode used for viewing the necessary information of Empreinte Carbone of Avion.
    * @return information in string format.
    */
   @Override
   public String toString() {
       return String.format("%s, voyageEnAvion=%b, tailleAvion=%s : %.1f", super.toString(), this.voyagerEnAvion, this.tailleA.name(), this.tailleA.emet);
   }

}
