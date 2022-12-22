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

/**
 * A Controleur objet is an entry of this application
 * who links the model part and the view part.
 *
 * @author Qinming JIANG
 * @author Shenqi MA
 * @version 2.9
 */
public class Controleur {

    /**
     * Menu instance
     */
    private MenuPrincipal menu;

    /**
     * Frame instance
     */
    private FramePrincipal frame;

    /**
     * Utilisateur instance
     */
    private Utilisateur utilisateur;

    /**
     * Instantiates a new Controleur.
     */
    public Controleur() {
        this.menu = new MenuPrincipal(this);
        this.utilisateur = new Utilisateur();
        this.lancer();
    }

    /**
     * Run the main menu.
     */
    private void lancer() {
        char action;
        this.menu.choisirInterface();
        action = this.menu.getAction(0);
        switch (action) {
            case '1' -> this.menu.frameCUI();
            case '2' -> this.frame = new FramePrincipal(this);
            case '3' -> this.menu.chargerUtilisateur();
            case '4' -> this.testClassServicePublics();
            case '5' -> this.testClassVoiture();
            default  -> System.exit(0);
        }
    }

    /**
     * Run the JUnit test of Voiture class.
     */
    private void testClassVoiture() {
        JUnitCore.main("model.test.VoitureTest");
    }

    /**
     * Run the JUnit test of class service publics.
     */
    public void testClassServicePublics() {
        JUnitCore.main("model.test.ServicePublicsTest");
    }

    /**
     * Read a Utilisateur from data.txt
     *
     * @param txB           the rate meet
     * @param txV           the rate vegetable
     * @param montant       the amount
     * @param superficie    the house size
     * @param niveauEnergie the energy rate
     * @param taille        the car size
     * @param kilomettre    the year kilometer
     * @param amortissement the car's year amortization
     */
    public void chargerUtilisateur(double txB, double txV, int montant, int superficie, char niveauEnergie, char taille, int kilomettre, int amortissement) {
        this.utilisateur = new Utilisateur(txB,txV,montant,superficie,niveauEnergie,taille,kilomettre,amortissement);
        this.utilisateur.setServices(ServicePublics.instance);
        this.menu.afficherNouvelUtilisateur();
    }

    /**
     * Back to main menu.
     */
    public void retourner() {
        this.utilisateur = new Utilisateur();
        this.utilisateur.setServices(ServicePublics.instance);
        this.lancer();
    }

    /**
     * Gets transport.
     *
     * @param taille        the car's size
     * @param kilomettre    the car's year kilometer
     * @param amortissement the car's amortization
     * @return the transport
     */
    public Transport getTransport(char taille, int kilomettre, int amortissement) {
        return this.utilisateur.getVoiture(taille,kilomettre,amortissement);
    }

    /**
     * Gets void Voiture.
     *
     * @return the Transport instance of Voiture
     */
    public Transport getTransport() {
        return this.utilisateur.getVoiture();
    }

    /**
     * Gets void Avion.
     *
     * @return the Avion
     */
    public Avion getAvion() {
        return this.utilisateur.getAvion();
    }

    /**
     * Gets Logement.
     *
     * @param superficie    the house size
     * @param niveauEnergie the energy rate
     * @return the logement
     */
    public Logement getLogement(int superficie, char niveauEnergie) {
        return this.utilisateur.getLogement(superficie,niveauEnergie);
    }

    /**
     * Gets avion.
     *
     * @param taille     the airplane's size
     * @param kilomettre the air travel kilometer
     * @return the avion
     */
    public Avion getAvion(char taille, int kilomettre) {
        return this.utilisateur.getAvion(taille,kilomettre);
    }

    /**
     * Set panel Avion no longer enable.
     */
    public void terminerAvion() {
        this.frame.terminerAvion();
    }

    /**
     * Print result on panel.
     */
    public void afficherPanneauResultat() {
        this.menu.afficherPanneauResultat();
    }

    /**
     * Sets result pane.
     *
     * @param res the result
     */
    public void setResultatPane(double res) {
        this.frame.setResultatPane(res);
    }

    /**
     * Calculate utilisateur's carbon emissions.
     *
     * @return the utilisateur's carbon emissions
     */
    public double calculerImpact() {
        return this.utilisateur.calculerImpact();
    }

    /**
     * Add logement.
     *
     * @param logement the logement
     */
    public void addLogement(Logement logement) {
        this.utilisateur.addLogement(logement);
    }

    /**
     * Add transport.
     *
     * @param transport the transport
     */
    public void addTransport(Transport transport) {
        this.utilisateur.addTransport(transport);
    }

    /**
     * Sets alimentation.
     *
     * @param txB the tx b
     * @param txV the tx v
     */
    public void setAlimentation(double txB, double txV) {
        this.utilisateur.setAlimentation(txB, txV);
    }

    /**
     * Sets bien conso.
     *
     * @param montant the montant
     */
    public void setBienConso(int montant) {
        this.utilisateur.setBienConso(montant);
    }

    /**
     * Update sector panel.
     *
     * @param secteur the secteur
     * @param color   the color
     */
    public void majPanneau(String secteur, Color color) {
        this.frame.majPanneau(secteur, color);
    }

    /**
     * Set panel Transport no longer enable.
     */
    public void terminerTransport() {
        this.frame.terminerTransport();
    }

    /**
     * Set panel Alimentation no longer enable.
     */
    public void terminerAlimentation() {
        this.frame.terminerAlimentation();
    }

    /**
     * Set panel Logement no longer enable.
     */
    public void terminerLogement() {
        this.frame.terminerLogement();
    }

    /**
     * Set panel BienConso no longer enable.
     */
    public void terminerBienConso() {
        this.frame.terminerBienConso();
    }

    /**
     * Print result.
     */
    public void afficheResultat() {
        this.frame.afficheResultat();
    }

    /**
     * Result detail.
     */
    public void detaillerResultat() {
        this.utilisateur.detaillerEmpreinte();
    }

    /**
     * Recommendation.
     */
    public void reconmmander() {
        this.utilisateur.recommender();
    }

    /**
     * Close graphic interface.
     */
    public void fermerGUI() {
        this.frame.fermerGUI();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new Controleur();
    }
}
