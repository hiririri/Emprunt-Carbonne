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
     * Method used for comparing impact of Empreinte Carbonne of nutrition.
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
