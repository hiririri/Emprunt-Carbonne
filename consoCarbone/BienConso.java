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
        return "BienConso{" +
                "id=" + id +
                ", impact=" + impact +
                ", montant=" + montant +
                '}';
    }

    public static int getMoyenne() {
        return 763 + 682 + 1180;
    }
}
