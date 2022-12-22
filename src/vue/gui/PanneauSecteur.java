package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A PanneauSecteur objet is an JPanel
 * who allows selecting different sector
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class PanneauSecteur extends JPanel implements ActionListener {

    /**
     * 'Avion' button
     */
    private JButton btnAvion;

    /**
     * 'Transport' button
     */
    private JButton btnTransport;

    /**
     * 'Alimentation' button
     */
    private JButton btnAlimentaiton;

    /**
     * 'BienConso' button
     */
    private JButton btnBienConso;

    /**
     * 'Logement' button
     */
    private JButton btnLogement;

    /**
     * Controller
     */
    private Controleur controleur;

    /**
     * Instantiates a new Panneau secteur.
     *
     * @param controleur the controller
     */
    public PanneauSecteur(Controleur controleur) {
        this.controleur = controleur;

        this.btnAvion        = new JButton(new ImageIcon("./vue/gui/images/Avion_p.png"));
        this.btnTransport    = new JButton(new ImageIcon("./vue/gui/images/Voiture_p.png"));
        this.btnAlimentaiton = new JButton(new ImageIcon("./vue/gui/images/Alimentation_p.png"));
        this.btnBienConso    = new JButton(new ImageIcon("./vue/gui/images/BienConso_p.png"));
        this.btnLogement     = new JButton(new ImageIcon("./vue/gui/images/Logement_p.png"));

        this.btnAvion.setBackground(new Color(89, 80, 133));
        this.btnTransport.setBackground(new Color(182, 21, 64));
        this.btnAlimentaiton.setBackground(new Color(227, 141, 39));
        this.btnBienConso.setBackground(new Color(91, 91, 222));
        this.btnLogement.setBackground(new Color(4, 163, 172));

        this.btnAvion.setForeground(Color.white);
        this.btnTransport.setForeground(Color.white);
        this.btnAlimentaiton.setForeground(Color.white);
        this.btnBienConso.setForeground(Color.white);
        this.btnLogement.setForeground(Color.white);

        this.btnAvion.addActionListener(this);
        this.btnTransport.addActionListener(this);
        this.btnAlimentaiton.addActionListener(this);
        this.btnBienConso.addActionListener(this);
        this.btnLogement.addActionListener(this);

        this.setLayout(new GridLayout(1,5,10,0));

        this.add( this.btnAvion       ,0);
        this.add( this.btnTransport   ,1);
        this.add( this.btnAlimentaiton,2);
        this.add( this.btnBienConso   ,3);
        this.add( this.btnLogement    ,4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnTransport) {
            this.controleur.majPanneau("Voiture", new Color(182, 21, 64));
        } else if (e.getSource() == this.btnAvion) {
            this.controleur.majPanneau("Avion", new Color(89, 80, 133));
        } else if (e.getSource() == this.btnBienConso) {
            this.controleur.majPanneau("BienConso", new Color(91, 91, 222));
        } else if (e.getSource() == this.btnAlimentaiton) {
            this.controleur.majPanneau("Alimentation", new Color(227, 141, 39));
        } else {
            this.controleur.majPanneau("Logement", new Color(4, 163, 172));
        }
    }

    /**
     * Print result.
     */
    public void afficheResultat() {
            this.controleur.setResultatPane(this.controleur.calculerImpact());
            if (!this.btnLogement.isEnabled() && !this.btnTransport.isEnabled() && !this.btnAvion.isEnabled() &&
                !this.btnAlimentaiton.isEnabled() && !this.btnBienConso.isEnabled()) {
                JOptionPane.showMessageDialog(this, "Vous avez terminé toutes les étapes.\nVeuillez retrouver les detailles et la recommendation dans la console.");
                this.controleur.afficherPanneauResultat();
                this.controleur.detaillerResultat();
                this.controleur.reconmmander();
                this.controleur.fermerGUI();
                this.controleur.retourner();
            }
    }

    /**
     * Set button Avion no longer enable.
     */
    public void terminerAvion() {
        this.btnAvion.setEnabled(false);
    }

    /**
     * Set button Transport no longer enable.
     */
    public void terminerTransport() {
        this.btnTransport.setEnabled(false);
    }

    /**
     * Set button Alimentation no longer enable.
     */
    public void terminerAlimentation() {
        this.btnAlimentaiton.setEnabled(false);
    }

    /**
     * Set button Logement no longer enable.
     */
    public void terminerBienConso() {
        this.btnBienConso.setEnabled(false);
    }

    /**
     * Set button BienConso no longer enable.
     */
    public void terminerLogement() {
        this.btnLogement.setEnabled(false);
    }
}
