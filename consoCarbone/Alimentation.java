package consoCarbone;

public class Alimentation extends ConsoCarbone{
    private static double VAL_B = 8;
    private static double VAL_A = 1.6;
    private static double VAL_V = 0.9;

    private double txBoeuf;
    private double txVege;

    public Alimentation(double txBoeuf, double txVege) {
        super();

        this.txBoeuf = txBoeuf;
        this.txVege  = txVege;
        this.calculImpact();
    }

    public double getTxBoeuf() {
        return this.txBoeuf;
    }

    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }

    public double getTxVege() {
        return this.txVege;
    }

    public void setTxVege(double txVege) {
        this.txVege = txVege;
    }

    public static void moyenEmpreinteCarboneAlimentation() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport à l'alimentation : \n" +
                "Boissons : 263 Kg eq CO2/an\n" +
                "Produits laitier en oeufs : 408 Kg eq CO2/an\n" +
                "Viandes et poissons : 1144 Kg eq CO2/an\n" +
                "Autres : 538 Kg eq CO2/an");
    }

    @Override
    public void calculImpact() {
        this.impact  = Alimentation.VAL_B * txBoeuf +
                Alimentation.VAL_A * (1 - txVege - txBoeuf) +
                Alimentation.VAL_V * txVege;
    }

    @Override
    public int compareTo(ConsoCarbone o) {
        return (int)(this.impact - o.impact);
    }

    @Override
    public String toString() {
        return String.format("Alimentation{" +
                "Id=%d " +
                "Impact=%.2f " +
                "Taux Boeuf=%.2f " +
                "Taux Vege=%.2f}", this.id, this.impact, this.txBoeuf, this.txVege);
    }

    public static void main(String[] args) {
        Alimentation alimentation = new Alimentation(0.475, 0.225);
        System.out.println(alimentation);
        System.out.println(new Alimentation(0.2, 0.5));
        Alimentation.moyenEmpreinteCarboneAlimentation();
    }
}
