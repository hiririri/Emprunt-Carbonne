package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A PanneauSaisiBienConso objet is an JPanel
 * who allows inputting information of BienConso
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class PanneauSaisiBienConso extends JPanel implements ActionListener {

    /**
     * Amount label
     */
    private JLabel lblMontant;

    /**
     * Amount text field
     */
    private JTextField tfMontant;

    /**
     * 'Suivant' button
     */
    private JButton btn;

    /**
     * GridBag Layout Constraints
     */
    private GridBagConstraints gbc;

    /**
     * Panel color
     */
    private Color color;

    /**
     * Controller
     */
    private Controleur controleur;

    /**
     * Instantiates a new Panneau saisi bien conso.
     *
     * @param color      the color
     * @param controleur the controller
     */
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

    /**
     * Event associated with the button 'Suivant'
     *
     * @param e event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.tfMontant.getText().equals("")) {
            this.controleur.setBienConso(Integer.parseInt(this.tfMontant.getText()));
            this.removeAll();
            this.repaint();
            this.controleur.terminerBienConso();
            JLabel tl = new JLabel("Vous avez terminé cette étape !");
            tl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
            tl.setForeground(Color.white);
            this.gbc.gridx = 0;
            this.gbc.gridy = 0;
            this.add(tl,this.gbc);
            this.repaint();
            this.controleur.afficheResultat();
        }
        else {
            JOptionPane.showMessageDialog(this,"Veuillez saisir le montant.");
        }
    }
}
