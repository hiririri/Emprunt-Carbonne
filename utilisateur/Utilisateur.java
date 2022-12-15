package utilisateur;

import consoCarbone.*;
import org.w3c.dom.css.Counter;

import java.util.*;
import java.util.stream.Collectors;

public class Utilisateur {
    private Alimentation   alimentation;
    private BienConso      bienConso;
    private ServicePublics services;

    private List<Logement> lstLogements;
    private List<Transport> lstVoitures;

    public Utilisateur() {
        this.lstLogements = new ArrayList<>();
        this.lstVoitures  = new ArrayList<>();
    }

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }

    public void setServices(ServicePublics services) {
        this.services = services;
    }

    public void addLogement(Logement logement) {
        this.lstLogements.add(logement);
    }

    public void addVoiture(Transport transport) {
        this.lstVoitures.add(transport);
    }

    public double calculerEmpreinte() {
        for (Logement logement : lstLogements)
            logement.calculImpact();
        for (Transport transport : lstVoitures)
            transport.calculImpact();

        this.alimentation.calculImpact();
        this.bienConso.   calculImpact();
        this.services.    calculImpact();

        return this.alimentation.getImpact() +
               this.bienConso.   getImpact() +
               this.services.    getImpact() +
               this.getImpactLogements() +
               this.getImpactTransports();
    }

    private double getImpactTransports() {
        return this.lstVoitures.stream().mapToDouble(ConsoCarbone::getImpact).sum();
    }

    private double getImpactLogements() {
        return this.lstLogements.stream().mapToDouble(ConsoCarbone::getImpact).sum();
    }

    public void detaillerEmpreinte() {
        this.calculerEmpreinte();
        String dtl = String.format("%-17s : %.2f\n", "Alimentation"    , this.alimentation.getImpact()) +
                     String.format("%-17s : %.2f\n", "Bien Consomation", this.bienConso   .getImpact()) +
                     String.format("%-17s : %.2f\n", "Logement"        , this.getImpactLogements()    ) +
                     String.format("%-17s : %.2f\n", "Transport"       , this.getImpactTransports()   ) +
                     String.format("%-17s : %.2f\n", "Services Publics", this.services    .getImpact());

        System.out.println(dtl);
    }

    public void recommender() {
        HashMap<String, Double> map = new HashMap<>();

        map.put("alimentation",this.alimentation.getImpact());
        map.put("bienConso",this.bienConso.getImpact());
        map.put("services",this.services.getImpact());
        map.put("logement",this.getImpactLogements());
        map.put("transport",this.getImpactTransports());

        map = map.entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .collect(Collectors.toMap(Map.Entry::getKey,
                          Map.Entry::getValue,
                          (e1, e2) -> e1,
                          LinkedHashMap::new));

        System.out.println("Liste des consommations carbonne");
        int[] counter = new int[1];
        map.entrySet().stream().toList().forEach(elt->{
            System.out.printf("%d-->%s\n", ++counter[0], elt);
        });

        String consoMax = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .stream()
                .map(Map.Entry::getKey)
                .toList()
                .get(0);

        System.out.println("Votre consommation dans le secteur " + consoMax + " est le plus élevé. Soyez plus attentif à ce secteur.");
    }
}
