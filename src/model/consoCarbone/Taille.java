package model.consoCarbone;

public enum Taille {
    P(4.2),
    G(19 );

    public double emet;

    private Taille(double coeff) {
        this.emet = coeff * 1750;
    }
}
