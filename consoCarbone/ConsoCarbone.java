package consoCarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
    private static int nbClass;

    protected int id;
    protected double impact;

    public ConsoCarbone() {
        this.id = ++ConsoCarbone.nbClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public abstract void calculImpact();
}
