package model.consoCarbone;

/**
 * This is a class simulates carbon consume of transport
 */
public class Transport extends ConsoCarbone{
    private int kilomAnnee;

    public Transport() {
        super();
    }

    /**
     * Get kilometer of transport.
     * @return kilometer of transport
     */
    public int getKilomAnnee() {
        return kilomAnnee;
    }

    /**
     * Set kilometer of transport.
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
     * Method used for comparing impact of Empreinte Carbonne of transport.
     * @param o the object to be compared.
     * @return -1 if this.impact is less than o.impact.
     *         0 if it is equal.
     *         1 if this.impact is bigger than the other.
     */
    @Override
    public int compareTo(ConsoCarbone o) {
        return (int)(this.impact - o.impact);
    }

    /**
     * Methode used for viewing the necessary information of Empreinte Carbonne of transport.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return String.format("Transport{" +
                "id=%d" +
                ", impact=%.2f" +
                ", kilomAnnee=%d" +
                "}", this.id, this.impact, this.kilomAnnee);
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
