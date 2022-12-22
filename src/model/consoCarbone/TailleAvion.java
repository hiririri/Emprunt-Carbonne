package model.consoCarbone;

/**
 * The enum Taille avion.
 * CO2 emissions for medium-haul air travel (200 km to 1,000 km) = 0.105 * km.
 * CO2 emissions for long-haul air travel (more than 1000 km) = km × 0.139
 */
public enum TailleAvion {
    /**
     * Small taille avion
     */
    P(0.015),
    /**
     * Big taille avion.
     */
    G(0.025);

    /**
     * The coefficient.
     */
    public double emet;

    /**
     * Constructor of TailleAvion
     *
     * @param coeff coefficient
     */
    private TailleAvion(double coeff) {
        this.emet = coeff;
    }
}
