package model.consoCarbone;

public class Logement extends ConsoCarbone {
    /**
     * House Energy Rating
     */
    private CE ce;
    /**
     *House size
     */
    private int superficie;


    public Logement(int superficie, CE ce) {
        super();

        this.superficie = superficie;
        this.ce         = ce;
        this.calculImpact();
    }

    public Logement() {
        super();
    }

    public int getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setCe(CE ce) {
        this.ce = ce;
    }

    /**
     *Average carbon footprint of a French person in relation to housing
     */
    public static void moyenEmpreinteCarboneLogement() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport au logement : \n" +
                "Equipement des logements : 335 Kg eq CO2/an\n" +
                "Construction & gros entretien : 675 Kg eq CO2/an\n" +
                "Energie et utilités : 1696 Kg eq CO2/an");
    }

    /**
     *Calculate CO2 emissions and update member variables
     */
    @Override
    public void calculImpact() {
        this.impact = this.ce.alpha * this.superficie;
    }

    /**
     * @return Returns a string containing the current member variable
     */
    @Override
    public String toString() {
        return String.format("Logement{" + super.toString() +
                ", ce=%s : %.3f" +
                ", superficie=%d" +
                "}", this.ce.name(), this.ce.alpha, this.superficie);
    }


}
