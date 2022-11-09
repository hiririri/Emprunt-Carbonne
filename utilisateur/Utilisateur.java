package utilisateur;

import consoCarbone.*;

public class Utilisateur {
    private Alimentation   alimentation;
    private BienConso      bienConso;
    private Logement       logement;
    private Transport      transport;
    private ServicePublics services;

    public Utilisateur() {

    }

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setServices(ServicePublics services) {
        this.services = services;
    }

    public double calculerEmpreinte() {
        this.alimentation.calculImpact();
        this.bienConso.   calculImpact();
        this.logement.    calculImpact();
        this.transport.   calculImpact();
        this.services.    calculImpact();

        return this.alimentation.getImpact() +
               this.bienConso.   getImpact() +
               this.logement.    getImpact() +
               this.transport.   getImpact() +
               this.services.    getImpact();
    }

    public void detaillerEmpreinte() {
        String dtl = String.format("%-17s : %.2f\n", "Alimentation"    , this.alimentation.getImpact()) +
                     String.format("%-17s : %.2f\n", "Bien Consomation", this.bienConso   .getImpact()) +
                     String.format("%-17s : %.2f\n", "Logement"        , this.logement    .getImpact()) +
                     String.format("%-17s : %.2f\n", "Transport"       , this.transport   .getImpact()) +
                     String.format("%-17s : %.2f\n", "Services Publics", this.services    .getImpact());

        System.out.println(dtl);
    }
}
