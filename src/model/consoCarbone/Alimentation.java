package model.consoCarbone;

/**
 * A Alimentation objet is an AppEmpruntCarbonAlimentatoin
 * who calculates the carbon footprint of food.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 3.0
 */
public class Alimentation extends ConsoCarbone{

    /**
     * Coefficient of calculating eating meet
     */
    private static final double VAL_B = 8;

    /**
     * Coefficient of calculating eating other food
     */
    private static final double VAL_A = 1.6;

    /**
     * Coefficient of calculating eating vegetable
     */
    private static final double VAL_V = 0.9;

    /**
     * Rate of eating meet
     */
    private double txBoeuf;

    /**
     * Rate of eating vegetable
     */
    private double txVege;

    /**
     * Class constructor specifying rate of meet and vegetarian
     *
     * @param txBoeuf the rate meet
     * @param txVege  the rate vegetable
     */
    public Alimentation(double txBoeuf, double txVege) {
        super();

        this.txBoeuf = txBoeuf;
        this.txVege  = txVege;
        this.calculImpact();
    }

    /**
     * Get rate of meet.
     *
     * @return rate of meet
     */
    public double getTxBoeuf() {
        return this.txBoeuf;
    }

    /**
     * Set rate of meet
     *
     * @param txBoeuf rate of meet
     */
    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }

    /**
     * Get rate of vegetable
     *
     * @return rate of vegetable
     */
    public double getTxVege() {
        return this.txVege;
    }

    /**
     * Set rate of vegetable
     *
     * @param txVege rate of vegetable
     */
    public void setTxVege(double txVege) {
        this.txVege = txVege;
    }

    /**
     * Methode used for viewing the average of Empreinte Carbone of nutrition in France.
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
     * Methode used for calculating the impact of Empreinte Carbone of food.
     */
    @Override
    public void calculImpact() {
        this.impact  = Alimentation.VAL_B * txBoeuf +
                Alimentation.VAL_A * (1 - txVege - txBoeuf) +
                Alimentation.VAL_V * txVege;
    }


    /**
     * Methode used for viewing the necessary information of Empreinte Carbone of food.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return String.format("Alimentation{%s " +
                "Taux Boeuf=%.2f " +
                "Taux Vege=%.2f}", super.toString(), this.txBoeuf, this.txVege);
    }


}
