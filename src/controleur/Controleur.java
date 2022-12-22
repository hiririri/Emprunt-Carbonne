package controleur;

import model.consoCarbone.Avion;
import model.consoCarbone.Logement;
import model.consoCarbone.ServicePublics;
import model.consoCarbone.Transport;
import model.utilisateur.Utilisateur;
import org.junit.runner.JUnitCore;
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
            case '4' -> this.testClassServicePublics();
            case '5' -> this.testClassTransport();
            default  -> System.exit(0);
        }
    }

    private void testClassTransport() {
        JUnitCore.main("model.test.VoitureTest");
    }

    public void testClassServicePublics() {
        JUnitCore.main("model.test.ServicePublicsTest");
    }

    public void chargerUtilisateur(double txB, double txV, int montant, int superficie, char niveauEnergie, char taille, int kilomettre, int amortissement) {
        this.utilisateur = new Utilisateur(txB,txV,montant,superficie,niveauEnergie,taille,kilomettre,amortissement);
        this.utilisateur.setServices(ServicePublics.instance);
        this.menu.afficherNouvelUtilisateur();
    }

    public void retourner() {
        this.utilisateur = new Utilisateur();
        this.utilisateur.setServices(ServicePublics.instance);
        this.lancer();
    }

    public Transport getTransport(char taille, int kilomettre, int amortissement) {
        return this.utilisateur.getVoiture(taille,kilomettre,amortissement);
    }

    public Transport getTransport() {
        return this.utilisateur.getVoiture();
    }

    public Avion getAvion() {
        return this.utilisateur.getAvion();
    }

    public Logement getLogement(int superficie, char niveauEnergie) {
        return this.utilisateur.getLogement(superficie,niveauEnergie);
    }

    public Avion getAvion(char taille, int kilomettre) {
        return this.utilisateur.getAvion(taille,kilomettre);
    }

    public void terminerAvion() {
        this.frame.terminerAvion();
    }

    public void afficherPanneauResultat() {
        this.menu.afficherPanneauResultat();
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

    public void addTransport(Transport transport) {
        this.utilisateur.addTransport(transport);
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
