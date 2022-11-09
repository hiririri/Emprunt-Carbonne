package consoCarbone;

public class BienConso extends ConsoCarbone{
    private double montant;

    public BienConso(double montant) {
        super();

        this.montant = montant;
        this.calculImpact();
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public void calculImpact() {
        this.impact  = this.montant / 1750;
    }

    @Override
    public int compareTo(ConsoCarbone o) {
        return (int)(this.impact - o.impact);
    }

    @Override
    public String toString() {
        return String.format("BienConso{" +
                "id=%d" +
                ", impact=%.2f" +
                ", montant=%.2f" +
                "}", this.id, this.impact, this.montant);
    }

    public static void moyenEmpreinteCarboneBienConso() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport au bien conso : \n" +
                "Habillement : 763 Kg eq CO2/an\n" +
                "Autres Biens et Services  : 682 Kg eq CO2/an\n" +
                "Achats et usages Internet et technologies : 1180 Kg eq CO2/an");
    }

    public static void main(String[] args) {
        System.out.println(new BienConso(2000));
        System.out.println(new BienConso(4000));
        BienConso.moyenEmpreinteCarboneBienConso();
    }
}
