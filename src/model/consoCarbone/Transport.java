package model.consoCarbone;

/**
 * A Transport objet is an AppEmpruntCarbonTransport
 * who calculates the carbon footprint of transport.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 3.0
 */
public class Transport extends ConsoCarbone{

    /**
     * Transport's year kilometer
     */
    private int kilomAnnee;

    /**
     * Instantiates a new Transport.
     */
    public Transport() {
        super();
    }

    /**
     * Get kilometer of transport.
     *
     * @return kilometer of transport
     */
    public int getKilomAnnee() {
        return kilomAnnee;
    }

    /**
     * Set kilometer of transport.
     *
     * @param kilomAnnee kilometer of transport
     */
    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbonne of transport.
     */
    @Override
    public void calculImpact() {}

    /**
     * Methode used for viewing the necessary information of Empreinte Carbonne of transport.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return String.format("%s, kilomAnnee=%d",  super.toString(), this.kilomAnnee);
    }

    /**
     * Methode used for viewing the average of Empreinte Carbonne of transport in France.
     */
    public static void moyenEmpreinteCarboneTransport() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport au transport : \n" +
                "Train et bus : 85 Kg eq CO2/an\n" +
                "Fret et messagerie : 383 Kg eq CO2/an\n" +
                "Avion : 480 Kg eq CO2/an\n" +
                "Voiture : 1972 Kg eq CO2/an");
    }
}
