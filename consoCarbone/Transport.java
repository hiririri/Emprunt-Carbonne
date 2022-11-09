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
        return String.format("Transport{" +
                "id=%d" +
                ", impact=%.2f" +
                ", possede=%b" +
                ", taille=%s : %.1f" +
                ", kilomAnnee=%d" +
                ", amortissement=%d" +
                "}", this.id, this.impact, this.possede, this.taille.name(), this.taille.emet, this.kilomAnnee, this.amortissement);
    }

    public static void moyenEmpreinteCarboneTransport() {
        System.out.println(
                "Empreinte carbone moyenne d'un français par rapport au transport : \n" +
                "Train et bus : 85 Kg eq CO2/an\n" +
                "Fret et messagerie : 383 Kg eq CO2/an\n" +
                "Avion : 480 Kg eq CO2/an\n" +
                "Voiture : 1972 Kg eq CO2/an");
    }

    public static void main(String[] args) {
        System.out.println(new Transport(true,Taille.P,4000,8));
        Transport.moyenEmpreinteCarboneTransport();
    }
}
