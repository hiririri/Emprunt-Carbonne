package consoCarbone;

import static java.lang.Math.E;

public class Transport extends ConsoCarbone{
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;

    public Transport() {

    }

    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement) {
        super();

        this.possede = possede;
        this.taille = taille;
        this.kilomAnnee = kilomAnnee;
        this.amortissement = amortissement;

        this.calculImpact();
    }

    public boolean isPossede() {
        return possede;
    }

    public void setPossede(boolean possede) {
        this.possede = possede;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public int getKilomAnnee() {
        return kilomAnnee;
    }

    public void setKilomAnnee(int kilomAnnee) {
        this.kilomAnnee = kilomAnnee;
    }

    public int getAmortissement() {
        return amortissement;
    }

    public void setAmortissement(int amortissement) {
        this.amortissement = amortissement;
    }

    @Override
    public void calculImpact() {
        if (!this.possede)
            this.impact = 0;
        else
            this.impact = this.kilomAnnee * 1.93 * E-4 + this.taille.emet / this.amortissement;
    }

    @Override
    public int compareTo(ConsoCarbone o) {
        return (int)(this.impact - o.impact);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", impact=" + impact +
                ", possede=" + possede +
                ", taille=" + taille.name() + ":" + taille.emet +
                ", kilomAnnee=" + kilomAnnee +
                ", amortissement=" + amortissement +
                '}';
    }

    public static int getMoyenne() {
        return 85 + 383 + 480 + 1972;
    }
}
