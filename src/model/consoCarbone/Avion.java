package model.consoCarbone;

public class Avion extends Transport{
    private boolean voyagerEnAvion;
    private TailleAvion tailleA;

    /**
     * Class constructor specifying possession, size, kilometer and amortization of Avion.
     * @param tailleA size of Avion
     * @param kilomAnnee kilometer of Avion
     */
    public Avion(TailleAvion tailleA, int kilomAnnee) {
        super();

        this.voyagerEnAvion = true;
        this.setKilomAnnee(kilomAnnee);
        this.tailleA = tailleA;
        this.calculImpact();
    }

    public Avion() {
        super();
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbonne of Avion.
     */
    @Override
    public void calculImpact() {
        this.impact = this.voyagerEnAvion ? this.tailleA.emet * (this.getKilomAnnee() - 200) : 0;
    }


   /**
    * Methode used for viewing the necessary information of Empreinte Carbonne of Avion.
    * @return information in string format.
    */
   @Override
   public String toString() {
       return String.format("%s, voyageEnAvion=%b, tailleAvion=%s : %.1f", super.toString(), this.voyagerEnAvion, this.tailleA.name(), this.tailleA.emet);
   }

}
