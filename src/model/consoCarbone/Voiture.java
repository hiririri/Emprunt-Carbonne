package model.consoCarbone;

/**
 * This is a class simulates carbon consume of Voiture
 */
public class Voiture extends Transport{
    private boolean possede;
    private TailleVoiture tailleV;
    private int amortissement;

    /**
     * Class constructor specifying possession, size, kilometer and amortization of Voiture.
     * @param tailleV size of Voiture
     * @param kilomAnnee kilometer of Voiture
     * @param amortissement amortization of Voiture
     */
    public Voiture(TailleVoiture tailleV, int kilomAnnee, int amortissement) {
        super();

        this.possede = true;
        this.tailleV = tailleV;
        this.setKilomAnnee(kilomAnnee);
        this.amortissement = amortissement;

        this.calculImpact();
    }

    public Voiture() {
        super();

        this.impact = 0;
        this.tailleV = tailleV.G;
        this.setKilomAnnee(0);
        this.amortissement = 1;
    }

    /**
     * Verify if the Voiture is under possession.
     * @return true if under possession, false if non.
     */
    public boolean isPossede() {
        return possede;
    }

    /**
     * Set possession.
     * @param possede possession of Voiture
     */
    public void setPossede(boolean possede) {
        this.possede = possede;
    }

    /**
     * Get size of Voiture.
     * @return size of Voiture
     */
    public TailleVoiture getTailleVoiture() {
        return tailleV;
    }

    /**
     * Set size of Voiture.
     * @param tailleV size of Voiture
     */
    public void setTailleVoiture(TailleVoiture tailleV) {
        this.tailleV = tailleV;
    }


    /**
     * Get amortization of Voiture.
     * @return amortization of Voiture
     */
    public int getAmortissement() {
        return amortissement;
    }

    /**
     * Set amortization of Voiture
     * @param amortissement amortization of Voiture
     */
    public void setAmortissement(int amortissement) {
        this.amortissement = amortissement;
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbonne of Voiture.
     */
    @Override
    public void calculImpact() {
        this.impact = this.possede ? this.getKilomAnnee() * 1.93 * Math.pow(10,-4) + this.tailleV.emet / this.amortissement : 0;
    }

    /**
     * Methode used for viewing the necessary information of Empreinte Carbonne of Voiture.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return String.format("Voiture{" + super.toString() +
                ", possede=%b" +
                ", tailleV=%s : %.1f" +
                ", amortissement=%d" +
                "}", this.possede, this.tailleV.name(), this.tailleV.emet, this.amortissement);
    }


}
