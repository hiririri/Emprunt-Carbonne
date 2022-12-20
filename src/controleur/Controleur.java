package controleur;

import model.consoCarbone.Logement;
import model.consoCarbone.Transport;
import model.utilisateur.Utilisateur;
import vue.console.MenuPrincipal;
import vue.gui.FramePrincipal;

import java.awt.*;

public class Controleur {
    private MenuPrincipal menu;
    private FramePrincipal frame;
    private Utilisateur utilisateur;

    public Controleur() {
        this.menu = new MenuPrincipal(this);
        this.utilisateur = new Utilisateur();
        this.lancer();
    }

    private void lancer() {
        char action;
        this.menu.choisirInterface();
        action = this.menu.getAction(0);
        switch (action) {
            case '1' -> this.menu.frameCUI();
            case '2' -> this.frame = new FramePrincipal(this);
            case '3' -> this.menu.chargerUtilisateur();
            default -> System.exit(0);
        }
    }

    public void chargerUtilisateur(double txB, double txV, int montant, int superficie, char niveauEnergie, char taille, int kilomettre, int amortissement) {
        Utilisateur utilisateurCharge = new Utilisateur(txB,txV,montant,superficie,niveauEnergie,taille,kilomettre,amortissement);
        utilisateurCharge.setServices(this.utilisateur.getServicePublics());
        this.menu.afficherNouvelUtilisateur(utilisateurCharge);
    }

    public void retourner() {
        this.menu = new MenuPrincipal(this);
        this.lancer();
    }

    public Transport getTransport(char taille, int kilomettre, int amortissement) {
        return this.utilisateur.getTransport(taille,kilomettre,amortissement);
    }

    public Transport getTransport(boolean possede) {
        return this.utilisateur.getTransport(possede);
    }

    public Logement getLogement(int superficie, char niveauEnergie) {
        return this.utilisateur.getLogement(superficie,niveauEnergie);
    }

    public void setResultatPane(double res) {
        this.frame.setResultatPane(res);
    }

    public double calculerImpact() {
        return this.utilisateur.calculerImpact();
    }

    public void addLogement(Logement logement) {
        this.utilisateur.addLogement(logement);
    }

    public void addVoiture(Transport transport) {
        this.utilisateur.addVoiture(transport);
    }

    public void setAlimentation(double txB, double txV) {
        this.utilisateur.setAlimentation(txB, txV);
    }

    public void setBienConso(int montant) {
        this.utilisateur.setBienConso(montant);
    }

    public void majPanneau(String secteur, Color color) {
        this.frame.majPanneau(secteur, color);
    }

    public void terminerTransport() {
        this.frame.terminerTransport();
    }

    public void terminerAlimentation() {
        this.frame.terminerAlimentation();
    }

    public void terminerLogement() {
        this.frame.terminerLogement();
    }

    public void terminerBienConso() {
        this.frame.terminerBienConso();
    }

    public void afficheResultat() {
        this.frame.afficheResultat();
    }

    public void detaillerResultat() {
        this.utilisateur.detaillerEmpreinte();
    }

    public void reconmmander() {
        this.utilisateur.recommender();
    }

    public void fermerGUI() {
        this.frame.fermerGUI();
    }

    public static void main(String[] args) {
        new Controleur();
    }
}
