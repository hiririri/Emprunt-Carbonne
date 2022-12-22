package model.utilisateur;

import model.consoCarbone.*;

import java.util.*;
import java.util.stream.Collectors;

public class Utilisateur {
    private Alimentation   alimentation;
    private BienConso      bienConso;
    private ServicePublics service;

    private List<Logement> lstLogements;
    private List<Transport> lstTransports;

    public Utilisateur() {
        this.alimentation = new Alimentation(0,0);
        this.bienConso = new BienConso(0);
        this.service = ServicePublics.creatServicePublics();
        this.lstLogements = new ArrayList<>();
        this.lstTransports  = new ArrayList<>();
    }

    public Utilisateur(double txB, double txV, int montant, int superficie, char niveauEnergie,
                       char taille, int kilomettre, int amortissement) {
        this.alimentation = new Alimentation(txB,txV);
        this.bienConso = new BienConso(montant);
        this.lstLogements = new ArrayList<>();
        this.lstTransports  = new ArrayList<>();

        this.lstLogements.add(this.getLogement(superficie, niveauEnergie));
        this.lstTransports.add(this.getVoiture(taille,kilomettre,amortissement));
    }

    public Logement getLogement(int superficie, char niveauEnergie) {
        switch (niveauEnergie) {
            case 'A' -> {return new Logement(superficie, CE.A);}
            case 'B' -> {return new Logement(superficie, CE.B);}
            case 'C' -> {return new Logement(superficie, CE.C);}
            case 'D' -> {return new Logement(superficie, CE.D);}
            case 'E' -> {return new Logement(superficie, CE.E);}
            case 'F' -> {return new Logement(superficie, CE.F);}
            case 'G' -> {return new Logement(superficie, CE.G);}
        }
        return null;
    }

    public Voiture getVoiture(char taille, int kilomettre, int amortissement) {
        switch (taille) {
            case 'P' -> {return new Voiture(TailleVoiture.P, kilomettre, amortissement);}
            case 'G' -> {return new Voiture(TailleVoiture.G, kilomettre, amortissement);}
        }
        return null;
    }

    public Voiture getVoiture() {
        return new Voiture();
    }

    public Avion getAvion(char taille, int kilomettre) {
        switch (taille) {
            case 'P' -> {return new Avion(TailleAvion.P, kilomettre);}
            case 'G' -> {return new Avion(TailleAvion.G, kilomettre);}
        }
        return null;
    }

    public Avion getAvion() {
        return new Avion();
    }

    public void setAlimentation(double txB, double txV) {
        this.alimentation.setTxBoeuf(txB);
        this.alimentation.setTxVege(txV);
    }

    public void setBienConso(int montant) {
        this.bienConso.setMontant(montant);
    }

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }

    public void setServices(ServicePublics services) {
        this.service = services;
    }

    public ServicePublics getServicePublics() {
        return this.service;
    }

    public void addLogement(Logement logement) {
        this.lstLogements.add(logement);
    }

    public void addTransport(Transport transport) {
        this.lstTransports.add(transport);
    }

    /**
     * @return This method returns the sum of all carbon emissions
     */
    public double calculerImpact() {
        if (this.lstLogements.size() != 0)
            for (Logement logement : this.lstLogements)
                logement.calculImpact();
        if (this.lstTransports.size() != 0)
            for (Transport transport : this.lstTransports) {
                if (transport instanceof Voiture)
                    if (((Voiture) transport).isPossede())
                        transport.calculImpact();
                if (transport instanceof Avion)
                    transport.calculImpact();
            }

        this.alimentation.calculImpact();
        this.bienConso.   calculImpact();
        this.service.     calculImpact();

        return this.alimentation.getImpact() +
               this.bienConso.   getImpact() +
               this.service.     getImpact() +
               this.getImpactLogements() +
               this.getImpactTransports();
    }

    private double getImpactTransports() {
        return this.lstTransports.stream().mapToDouble(Transport::getImpact).sum();
    }

    private double getImpactLogements() {
        return this.lstLogements.stream().mapToDouble(Logement::getImpact).sum();
    }

    /**
     * The method outputs details of carbon emissions for each category
     */
    public void detaillerEmpreinte() {
        this.calculerImpact();

        String dtl = String.format("%-17s : %.2f tonnes CO2/an\n", "Alimentation"    , this.alimentation.getImpact()) +
                     String.format("%-17s : %.2f tonnes CO2/an\n", "Bien Consomation", this.bienConso   .getImpact()) +
                     String.format("%-17s : %.2f tonnes CO2/an\n", "Services Publics", this.service     .getImpact());

        if (this.lstLogements.size() == 1)
            dtl += String.format("%-17s : %.2f tonnes CO2/an\n", "Logement", this.lstLogements.get(0).getImpact());
        else {
            dtl += "Logements : \n";
            for (int i = 0; i < this.lstLogements.size(); i++)
                dtl += String.format("\tLogement N°%d : %.2f tonnes CO2/an\n", (i+1), this.lstLogements.get(i).getImpact());
        }

        if (this.getImpactTransports() == 0)
            dtl += String.format("%-17s : %.2f tonnes CO2/an\n", this.lstTransports.get(0).getClass().getSimpleName(), this.lstTransports.get(0).getImpact());
        else {
            int cpt = 0;
            dtl += "Transports : \n";
            this.lstTransports.sort(Comparator.comparing(transport -> transport.getClass().getSimpleName(),Comparator.reverseOrder()));
            for (int i = 0; i < this.lstTransports.size(); i++)
                if (this.lstTransports.get(i) instanceof Voiture) {
                    dtl += String.format("\t%s N°%d : %.2f tonnes CO2/an\n", this.lstTransports.get(i).getClass().getSimpleName(), (i + 1), this.lstTransports.get(i).getImpact());
                    cpt++;
                }
            for (int i = cpt; i < this.lstTransports.size(); i++)
                if (this.lstTransports.get(i) instanceof Avion)
                    dtl += String.format("\t%s N°%d : %.2f tonnes CO2/an\n", this.lstTransports.get(i).getClass().getSimpleName(), (i-cpt+1), this.lstTransports.get(i).getImpact());
        }

        System.out.println(dtl);
    }

    /**
     * orders the user's carbon consumption in a list and presents the information to the user,
     * then makes recommendations for a more sustainable lifestyle.
     */
    public void recommender() {
        HashMap<String, Double> map = new HashMap<>();

        map.put("Alimentation",this.alimentation.getImpact());
        map.put("Bien Consommation",this.bienConso.getImpact());
        map.put("Service Publics",this.service.getImpact());
        map.put("Logement",this.getImpactLogements());
        map.put("Transport",this.getImpactTransports());

        map = map.entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .collect(Collectors.toMap(Map.Entry::getKey,
                          Map.Entry::getValue,
                          (e1, e2) -> e1,
                          LinkedHashMap::new));

        System.out.println("Liste ordone des consommations carbone");
        int[] counter = new int[1];
        String lstRanked = "";
        for (String key : map.keySet())
            lstRanked += String.format("%d --> %s : %.2f tonnes CO2/an\n", ++counter[0], key, map.get(key));
        System.out.println(lstRanked);

        String consoMax = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .get(0);
        System.out.println("Votre consommation dans le secteur '" + consoMax + "' est le plus eleve.\n" +
                           "Voici quelque reconmmandation qui pourrait utile pour vous.");

        switch (consoMax) {
            case "Alimentation"      -> System.out.println("Vous pouvez réduire la consommation de viande et de charcuterie et augmenter celle des légumes secs et des fruits à coques");
            case "Bien Consommation" -> System.out.println("Vous pouvez économiser votre dépenses annuels et votre argent.");
            case "Transport"         -> System.out.println("Vous pouvez voyager en train qui pollue 32 fois moins que circuler en voiture, et 23 fois moins que voyager par les airs.");
            case "Logement"          -> System.out.println("Vous pouvez débrancher les appareils en veille et éteindre les lumières ou changer de système de chauffage etc.");
            default                  -> System.out.println("L’Etat doit aider les services publics à se réformer pour qu’ils puissent le plus rapidement possible être neutres en carbone.");
        }
    }
}
