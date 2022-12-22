package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A FramePrincipal objet is an JFrame
 * who allows creating a graphic interface
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class FramePrincipal extends JFrame {

    /**
     * Result panel
     */
    private PanneauResultat panneauResultat;

    /**
     * Sector panel
     */
    private PanneauSecteur  panneauSecteur;

    /**
     * Input panel
     */
    private PanneauSaisi    panneauSaisi;

    private Controleur controleur;

    /**
     * Instantiates a new Frame principal.
     *
     * @param controleur the controleur
     */
    public FramePrincipal(Controleur controleur) {
        super("Empreinte Carbone");
        this.controleur = controleur;

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(new SynthLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        }


        this.setSize(1000,500);
        this.setLocation(200,60);

        this.panneauResultat = new PanneauResultat(this.controleur);
        this.panneauSecteur  = new PanneauSecteur(this.controleur);
        this.panneauSaisi    = new PanneauSaisi(this.controleur);

        this.add(this.panneauResultat, BorderLayout.NORTH);
        this.add(this.panneauSecteur,  BorderLayout.SOUTH);
        this.add(this.panneauSaisi,    BorderLayout.CENTER);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                FramePrincipal.this.setVisible(false);
                FramePrincipal.this.controleur.retourner();
            }
        });
    }

    /**
     * Update PanneauSaisi.
     *
     * @param secteur the sector
     * @param color   the color
     */
    public void majPanneau(String secteur, Color color) {
        this.panneauSaisi.majPanneau(secteur, color);
    }

    /**
     * Set panel Avion no longer enable.
     */
    public void terminerAvion() {
        this.panneauSecteur.terminerAvion();
    }

    /**
     * Set panel Transport no longer enable.
     */
    public void terminerTransport() {
        this.panneauSecteur.terminerTransport();
    }

    /**
     * Set panel Alimentation no longer enable.
     */
    public void terminerAlimentation() {
        this.panneauSecteur.terminerAlimentation();
    }

    /**
     * Set panel Logement no longer enable.
     */
    public void terminerLogement() {
        this.panneauSecteur.terminerLogement();
    }

    /**
     * Set panel BienConso no longer enable.
     */
    public void terminerBienConso() {
        this.panneauSecteur.terminerBienConso();
    }

    /**
     * Sets resultat pane.
     *
     * @param res the result
     */
    public void setResultatPane(double res) {
        this.panneauResultat.setResultatPane(res);
    }

    /**
     * Print result.
     */
    public void afficheResultat() {
        this.panneauSecteur.afficheResultat();
    }

    /**
     * Close graphic interface.
     */
    public void fermerGUI() {
        this.setVisible(false);
    }
}
