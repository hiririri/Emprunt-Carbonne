package model.consoCarbone;

/**
 * A ServicePublics objet is an AppEmpruntCarbonServicePublics
 * who calculates the carbon footprint of public service.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 2.0
 */
public class ServicePublics extends ConsoCarbone {
    /**
     * The constant instance.
     */
    public static ServicePublics instance;

    /**
     * Methode used for creating the unique instance of class ServicePublics.
     *
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
     * Methode used for calculating the impact of Empreinte Carbone of public service.
     */
    @Override
    public void calculImpact() {
        this.impact = 1.5;
    }

    /**
     * Methode used for viewing the necessary information of Empreinte Carbone of public service.
     * @return information in string format.
     */
    @Override
    public String toString() {
        return "ServicePublics{" + super.toString() + "}";
    }

    /**
     * Methode used for viewing the average of Empreinte Carbone of public service in France.
     */
    public static void moyenEmpreinteCarboneServicePublics() {
        System.out.println("Empreinte carbone moyenne d'un français par rapport au service publics : \n" +
                           "Service Public Santé : 1489 Kg eq CO2/an");
    }
}
