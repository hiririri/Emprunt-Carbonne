package consoCarbone;

public class ServicePublics extends ConsoCarbone {
    public static ServicePublics instance;

    public static ServicePublics creatServicePublics() {
        return (ServicePublics.instance == null) ? new ServicePublics() : null;
    }

    private ServicePublics() {
        this.calculImpact();
    }

    @Override
    public int compareTo(ConsoCarbone o) {
        return 0;
    }

    @Override
    public void calculImpact() {
        this.impact = 1.5 * 1750;
    }

    @Override
    public String toString() {
        return String.format("ServicePublics{" +
                "id=%d" +
                ", impact=%.2f" +
                '}', this.id, this.impact);
    }

    public static void moyenEmpreinteCarboneServicePublics() {
        System.out.println("Empreinte carbone moyenne d'un français par rapport au service publics : \n" +
                           "Service Public Santé : 1489 Kg eq CO2/an");
    }
}
