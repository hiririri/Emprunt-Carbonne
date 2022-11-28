package consoCarbone;

import static java.lang.Math.E;

/**
 * This is a class simulates carbon consume of transport
 */
public class Transport extends ConsoCarbone{
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;

    /**
     * Class constructor specifying possession, size, kilometer and amortization of transport.
     * @param possede possession of transport
     * @param taille size of transport
     * @param kilomAnnee kilometer of transport
     * @param amortissement amortization of transport
     */
    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement) {
        super();

        this.possede = possede;
        this.taille = taille;
        this.kilomAnnee = kilomAnnee;
        this.amortissement = amortissement;

        this.calculImpact();
    }

    /**
     * Verify if the transport is under possession.
     * @return true if under possession, false if non.
     */
    public boolean isPossede() {
        return possede;
    }

    /**
     * Set possession.
     * @param possede possession of transport
     */
    public void setPossede(boolean possede) {
        this.possede = possede;
    }

    /**
     * Get size of transport.
     * @return size of transport
     */
    public Taille getTaille() {
        return taille;
    }

    /**
     * Set size of transport.
     * @param taille size of transport
     */
    public void setTaille(Taille taille) {
        this.taille = taille;
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
     * Get amortization of transport.
     * @return amortization of transport
     */
    public int getAmortissement() {
        return amortissement;
    }

    /**
     * Set amortization of transport
     * @param amortissement amortization of transport
     */
    public void setAmortissement(int amortissement) {
        this.amortissement = amortissement;
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbonne of transport.
     */
    @Override
    public void calculImpact() {
        if (!this.possede)
            this.impact = 0;
        else
            this.impact = this.kilomAnnee * 1.93 * E-4 + this.taille.emet / this.amortissement;
    }

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
                ", possede=%b" +
                ", taille=%s : %.1f" +
                ", kilomAnnee=%d" +
                ", amortissement=%d" +
                "}", this.id, this.impact, this.possede, this.taille.name(), this.taille.emet, this.kilomAnnee, this.amortissement);
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

    public static void main(String[] args) {
        System.out.println(new Transport(true,Taille.P,4000,8));
        Transport.moyenEmpreinteCarboneTransport();
    }
}
