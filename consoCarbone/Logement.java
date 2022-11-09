package consoCarbone;

public class Logement extends ConsoCarbone {
    private CE ce;
    private int superficie;


    public Logement(int superficie, CE ce) {
        super();

        this.superficie = superficie;
        this.ce         = ce;
        this.calculImpact();
    }

    public int getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public static int getMoyenne() {
        return 335 + 675 + 1696;
    }

    @Override
    public void calculImpact() {
        this.impact = this.ce.alpha * this.superficie;
    }

    @Override
    public String toString() {
        return "Logement{" +
                "id=" + id +
                ", impact=" + impact +
                ", ce=" + ce.name() + ":" + ce.alpha +
                ", superficie=" + superficie +
                '}';
    }

    @Override
    public int compareTo(ConsoCarbone o) {
        return (int)(this.impact - o.impact);
    }

    public static void main(String[] args) {
        System.out.println(Logement.getMoyenne());
    }
}
