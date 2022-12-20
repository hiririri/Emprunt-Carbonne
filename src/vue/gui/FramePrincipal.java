package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;

public class FramePrincipal extends JFrame {
    private PanneauResultat panneauResultat;
    private PanneauSecteur  panneauSecteur;
    private PanneauSaisi    panneauSaisi;

    private Controleur controleur;

    public FramePrincipal(Controleur controleur) {
        super("Empreinte Carbonne");
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
    }

    public void majPanneau(String secteur, Color color) {
        this.panneauSaisi.majPanneau(secteur, color);
    }

    public void terminerTransport() {
        this.panneauSecteur.terminerTransport();
    }

    public void terminerAlimentation() {
        this.panneauSecteur.terminerAlimentation();
    }

    public void terminerLogement() {
        this.panneauSecteur.terminerLogement();
    }

    public void terminerBienConso() {
        this.panneauSecteur.terminerBienConso();
    }

    public void setResultatPane(double res) {
        this.panneauResultat.setResultatPane(res);
    }

    public void afficheResultat() {
        this.panneauSecteur.afficheResultat();
    }

    public void fermerGUI() {
        this.setVisible(false);
    }
}
