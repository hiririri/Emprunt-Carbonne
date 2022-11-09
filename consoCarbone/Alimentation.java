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

    public static int getMoyenne() {
        return 263 + 538 + 408 + 1144;
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
        return "Alimentation{" +
                "Id=" + id +
                ", Impact=" + impact +
                ", Taux Boeuf=" + txBoeuf +
                ", Taux Vege=" + txVege +
                '}';
    }

    public static void main(String[] args) {
        Alimentation a = new Alimentation(0.475, 0.225);
        System.out.println(a);
        System.out.println(Alimentation.getMoyenne());
    }
}
