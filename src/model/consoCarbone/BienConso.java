package model.consoCarbone;

/**
 * A BienConso objet is an AppEmpreinteCarbonBienConsommation
 * who calculates the carbon footprint of money spent.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 3.0
 */
public class BienConso extends ConsoCarbone{
    /**
     * The amount annual
     */
    private double montant;

    /**
     * Class constructor specifying amount of object bought.
     *
     * @param montant the amount
     */
    public BienConso(double montant) {
        super();

        this.montant = montant;
        this.calculImpact();
    }

    /**
     * Get amount.
     *
     * @return amount montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Set amount.
     *
     * @param montant amount
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbone of object bought.
     */
    @Override
    public void calculImpact() {
        this.impact  = this.montant / 1750;
    }

    /**
     * Methode used for viewing the necessary information of Empreinte Carbone of object bought.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return String.format("BienConso{%s" +
                ", montant=%.2f" +
                "}", super.toString(), this.montant);
    }

    /**
     * Methode used for viewing the average of Empreinte Carbone of object bought in France.
     */
    public static void moyenEmpreinteCarboneBienConso() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport au bien conso : \n" +
                "Habillement : 763 Kg eq CO2/an\n" +
                "Autres Biens et Services  : 682 Kg eq CO2/an\n" +
                "Achats et usages Internet et technologies : 1180 Kg eq CO2/an");
    }
}
