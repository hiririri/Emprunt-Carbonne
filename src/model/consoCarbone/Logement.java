package model.consoCarbone;

public class Logement extends ConsoCarbone {
    private CE ce;
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

    public static void moyenEmpreinteCarboneLogement() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport au logement : \n" +
                "Equipement des logements : 335 Kg eq CO2/an\n" +
                "Construction & gros entretien : 675 Kg eq CO2/an\n" +
                "Energie et utilités : 1696 Kg eq CO2/an");
    }

    @Override
    public void calculImpact() {
        this.impact = this.ce.alpha * this.superficie;
    }

    @Override
    public String toString() {
        return String.format("Logement{" +
                "id=%d" +
                ", impact=%.2f" +
                ", ce=%s : %.3f" +
                ", superficie=%d" +
                "}", this.id, this.impact, this.ce.name(), this.ce.alpha, this.superficie);
    }

    @Override
    public int compareTo(ConsoCarbone o) {
        return (int)(this.impact - o.impact);
    }

    public static void main(String[] args) {
        System.out.println(new Logement(50, CE.B));
        System.out.println(new Logement(25, CE.F));
        Logement.moyenEmpreinteCarboneLogement();
    }
}
