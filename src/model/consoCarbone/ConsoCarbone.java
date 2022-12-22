package model.consoCarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
    /**
     * Number of class instances
     */
    private static int nbClass;

    /**
     *The id of the current object
     */
    protected int id;
    /**
     *Carbon dioxide emissions
     */
    protected double impact;

    /**
     *Auto-add object id
     */
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

    /**
     *Calculating carbon emissions
     */
    public abstract void calculImpact();

    /**
     * @return Returns a string containing the current member variable
     */
    @Override
    public String toString() {
        return "ConsoCarbone{" +
                "id=" + id +
                ", impact=" + impact +
                '}';
    }
}
