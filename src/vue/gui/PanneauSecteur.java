package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanneauSecteur extends JPanel implements ActionListener {
    private JButton btnTransport   ;
    private JButton btnAlimentaiton;
    private JButton btnBienConso    ;
    private JButton btnLogement    ;

    private Controleur controleur;

    public PanneauSecteur(Controleur controleur) {
        this.controleur = controleur;

        this.btnTransport    = new JButton(new ImageIcon("./src/vue/gui/images/Transport_p.png"));
        this.btnAlimentaiton = new JButton(new ImageIcon("./src/vue/gui/images/Alimentation_p.png"));
        this.btnBienConso    = new JButton(new ImageIcon("./src/vue/gui/images/BienConso_p.png"));
        this.btnLogement     = new JButton(new ImageIcon("./src/vue/gui/images/Logement_p.png"));

        this.btnTransport.setBackground(new Color(182, 21, 64));
        this.btnAlimentaiton.setBackground(new Color(227, 141, 39));
        this.btnBienConso.setBackground(new Color(91, 91, 222));
        this.btnLogement.setBackground(new Color(4, 163, 172));

        this.btnTransport.setForeground(Color.white);
        this.btnAlimentaiton.setForeground(Color.white);
        this.btnBienConso.setForeground(Color.white);
        this.btnLogement.setForeground(Color.white);

        this.btnTransport.addActionListener(this);
        this.btnAlimentaiton.addActionListener(this);
        this.btnBienConso.addActionListener(this);
        this.btnLogement.addActionListener(this);

        this.setLayout(new GridLayout(1,4,10,0));

        this.add( this.btnTransport   ,0);
        this.add( this.btnAlimentaiton,1);
        this.add( this.btnBienConso    ,2);
        this.add( this.btnLogement    ,3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnTransport) {
            this.controleur.majPanneau("Transport", new Color(182, 21, 64));
        } else if (e.getSource() == this.btnBienConso) {
            this.controleur.majPanneau("BienConso", new Color(91, 91, 222));
        } else if (e.getSource() == this.btnAlimentaiton) {
            this.controleur.majPanneau("Alimentation", new Color(227, 141, 39));
        } else {
            this.controleur.majPanneau("Logement", new Color(4, 163, 172));
        }
    }

    public void afficheResultat() {
            this.controleur.setResultatPane(this.controleur.calculerImpact());
            if (!this.btnLogement.isEnabled() && !this.btnTransport.isEnabled() &&
                !this.btnAlimentaiton.isEnabled() && !this.btnBienConso.isEnabled()) {
                JOptionPane.showMessageDialog(this, "Vous avez terminé toutes les étapes.\nVeuillez retrouver les detailles et la recommendation dans la console.");
                this.controleur.detaillerResultat();
                this.controleur.reconmmander();
                this.controleur.fermerGUI();
                this.controleur.retourner();
            }
    }

    public void terminerTransport() {
        this.btnTransport.setEnabled(false);
    }

    public void terminerAlimentation() {
        this.btnAlimentaiton.setEnabled(false);
    }

    public void terminerBienConso() {
        this.btnBienConso.setEnabled(false);
    }

    public void terminerLogement() {
        this.btnLogement.setEnabled(false);
    }
}
