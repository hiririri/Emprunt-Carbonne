package model.consoCarbone;

/**
 * This is a class simulates carbon consume of nutrition
 */
public class Alimentation extends ConsoCarbone{
    private static double VAL_B = 8;
    private static double VAL_A = 1.6;
    private static double VAL_V = 0.9;

    private double txBoeuf;
    private double txVege;

    /**
     * Class constructor specifying rate of meet and vegetarian
     * @param txBoeuf
     * @param txVege
     */
    public Alimentation(double txBoeuf, double txVege) {
        super();

        this.txBoeuf = txBoeuf;
        this.txVege  = txVege;
        this.calculImpact();
    }

    /**
     * Get rate of meet.
     * @return rate of meet
     */
    public double getTxBoeuf() {
        return this.txBoeuf;
    }

    /**
     * Set rate of meet
     * @param txBoeuf rate of meet
     */
    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }

    /**
     * Get rate of vegetarian
     * @return rate of vegetarian
     */
    public double getTxVege() {
        return this.txVege;
    }

    /**
     * Set rate of vegetarian
     * @param txVege rate of vegetarian
     */
    public void setTxVege(double txVege) {
        this.txVege = txVege;
    }

    /**
     * Methode used for viewing the average of Empreinte Carbonne of nutrition in France.
     */
    public static void moyenEmpreinteCarboneAlimentation() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport à l'alimentation : \n" +
                "Boissons : 263 Kg eq CO2/an\n" +
                "Produits laitier en oeufs : 408 Kg eq CO2/an\n" +
                "Viandes et poissons : 1144 Kg eq CO2/an\n" +
                "Autres : 538 Kg eq CO2/an");
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbonne of nutrition.
     */
    @Override
    public void calculImpact() {
        this.impact  = Alimentation.VAL_B * txBoeuf +
                Alimentation.VAL_A * (1 - txVege - txBoeuf) +
                Alimentation.VAL_V * txVege;
    }


    /**
     * Methode used for viewing the necessary information of Empreinte Carbonne of nutrition.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return String.format("Alimentation{%s " +
                "Taux Boeuf=%.2f " +
                "Taux Vege=%.2f}", super.toString(), this.txBoeuf, this.txVege);
    }


}
