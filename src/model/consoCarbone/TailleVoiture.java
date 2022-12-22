package model.consoCarbone;

/**
 * The enum Taille voiture.
 */
public enum TailleVoiture {
    /**
     * P taille voiture.
     */
    P(4.2),
    /**
     * G taille voiture.
     */
    G(19 );

    /**
     * The coefficient.
     */
    public double emet;

    /**
     * Constructor of TailleVoiture
     *
     * @param coeff coefficient
     */
    private TailleVoiture(double coeff) {
        this.emet = coeff;
    }
}
