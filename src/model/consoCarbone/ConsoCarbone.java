package model.consoCarbone;

/**
 * A ConsoCarbone objet is an AppEmpruntCarbon
 * who calculates the carbon footprint.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 3.0
 */
public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
    /**
     * Number of class instances
     */
    private static int nbClass;

    /**
     * The id of the current object
     */
    protected int id;

    /**
     * Carbon dioxide emissions
     */
    protected double impact;

    /**
     * Auto-add object id
     */
    public ConsoCarbone() {
        this.id = ++ConsoCarbone.nbClass;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets impact.
     *
     * @return the impact
     */
    public double getImpact() {
        return impact;
    }

    /**
     * Sets impact.
     *
     * @param impact the impact
     */
    public void setImpact(double impact) {
        this.impact = impact;
    }

    /**
     * Calculating carbon emissions
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
        return String.format("id=%d, impact=%.2f", this.id, this.impact);
    }
}
