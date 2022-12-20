package vue.gui;

import controler.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanneauSaisiBienConso extends JPanel implements ActionListener {
    private JLabel lblMontant;
    private JTextField tfMontant;
    private JButton btn;
    private GridBagConstraints gbc;

    private Color color;
    private Controleur controleur;

    public PanneauSaisiBienConso(Color color, Controleur controleur) {
        this.color = color;
        this.controleur = controleur;

        this.setBackground(this.color);
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.btn = new JButton("Suivant");
        this.btn.setBackground(new Color(86, 87, 187));
        this.btn.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.btn.setForeground(Color.white);
        this.lblMontant = new JLabel("Montant dépensé annuel :");
        this.lblMontant.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.lblMontant.setForeground(Color.white);
        this.tfMontant = new JTextField(5);
        this.tfMontant.setDocument(new NumberDocument());

        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.add(this.lblMontant, this.gbc);
        this.gbc.gridx = 1;
        this.gbc.gridy = 0;
        this.add(this.tfMontant, this.gbc);
        this.gbc.gridx = 2;
        this.gbc.gridy = 0;
        JLabel l = new JLabel(" euros");
        l.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        l.setForeground(Color.white);
        this.add(l, this.gbc);
        this.gbc.gridx = 0;
        this.gbc.gridy = 1;
        this.gbc.gridwidth = 2;
        this.add(this.btn, this.gbc);

        this.btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.tfMontant.getText().equals("")) {
            this.controleur.setBienConso(Integer.parseInt(this.tfMontant.getText()));
            this.removeAll();
            this.repaint();
            this.controleur.terminerBienConso();
            this.controleur.afficheResultat();
            JLabel tl = new JLabel("Vous avez terminé cette étape !");
            tl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
            tl.setForeground(Color.white);
            this.gbc.gridx = 0;
            this.gbc.gridy = 0;
            this.add(tl,this.gbc);
            this.repaint();
        }
        else {
            JOptionPane.showMessageDialog(this,"Veuillez saisir le montant.");
        }
    }
}
