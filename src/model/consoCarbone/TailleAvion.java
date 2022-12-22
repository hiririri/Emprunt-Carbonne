package model.consoCarbone;

public enum TailleAvion {
    /**
    CO2 emissions for medium-haul air travel (200 km to 1,000 km) = 0.105 * km.
    CO2 emissions for long-haul air travel (more than 1000 km) = km × 0.139
     */
    P(0.105),
    G(0.139);

    public double emet;

    private TailleAvion(double coeff) {
        this.emet = coeff;
    }
}
