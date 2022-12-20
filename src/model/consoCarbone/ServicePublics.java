package model.consoCarbone;

/**
 * This is a class simulates carbon consume of public service.
 */
public class ServicePublics extends ConsoCarbone {
    public static ServicePublics instance;

    /**
     * Methode used for creating the instance of class ServicePublics.
     * @return instance of ServicePublics
     */
    public static ServicePublics creatServicePublics() {
        if (ServicePublics.instance == null) {
            ServicePublics.instance = new ServicePublics();
            return ServicePublics.instance;
        }
        return null;
    }

    /**
     * Class constructor.
     */
    private ServicePublics() {
        this.calculImpact();
    }


    @Override
    public int compareTo(ConsoCarbone o) {
        return 0;
    }

    /**
     * Methode used for calculating the impact of Empreinte Carbonne of public service.
     */
    @Override
    public void calculImpact() {
        this.impact = 1.5 * 1750;
    }

    /**
     * Methode used for viewing the necessary information of Empreinte Carbonne of public service.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return String.format("ServicePublics{" +
                "id=%d" +
                ", impact=%.2f" +
                '}', this.id, this.impact);
    }

    /**
     * Methode used for viewing the average of Empreinte Carbonne of public service in France.
     */
    public static void moyenEmpreinteCarboneServicePublics() {
        System.out.println("Empreinte carbone moyenne d'un français par rapport au service publics : \n" +
                           "Service Public Santé : 1489 Kg eq CO2/an");
    }

    public static void main(String[] args) {

    }
}
