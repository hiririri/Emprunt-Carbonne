package model.consoCarbone;

public enum TailleVoiture {
    P(4.2),
    G(19 );

    public double emet;

    private TailleVoiture(double coeff) {
        this.emet = coeff;
    }
}
