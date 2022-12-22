package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A PanneauSaisiAlimentation objet is an JPanel
 * who allows inputting information of Alimentation
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class PanneauSaisiAlimentation extends JPanel implements ActionListener {
    /**
     * Meet label
     */
    private JLabel lblBoeuf;

    /**
     * Rate meet text field
     */
    private JTextField tfBoeuf;

    /**
     * Vegetable label
     */
    private JLabel lblVege;

    /**
     * Rate vegetable text field
     */
    private JTextField tfVege;

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
     * Instantiates a new Panneau saisi alimentation.
     *
     * @param color      the color
     * @param controleur the controleur
     */
    public PanneauSaisiAlimentation(Color color, Controleur controleur) {
        this.color = color;
        this.controleur = controleur;

        this.setBackground(this.color);
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.btn = new JButton("Suivant");
        this.btn.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.btn.setForeground(Color.white);
        this.btn.setBackground(new Color(86, 87, 187));
        this.lblBoeuf = new JLabel("Taux de boeuf :");
        this.lblBoeuf.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.lblBoeuf.setForeground(Color.white);
        this.tfBoeuf = new JTextField(5);
        this.tfBoeuf.setDocument(new NumberDocument());
        this.lblVege = new JLabel("Taux de végétarien :");
        this.lblVege.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.lblVege.setForeground(Color.white);
        this.tfVege = new JTextField(5);
        this.tfVege.setDocument(new NumberDocument());

        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.add(this.lblBoeuf,this.gbc);
        this.gbc.gridx = 1;
        this.gbc.gridy = 0;
        this.add(this.tfBoeuf,this.gbc);
        this.gbc.gridx = 2;
        this.gbc.gridy = 0;
        JLabel l1 = new JLabel("%");
        l1.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        l1.setForeground(Color.white);
        this.add(l1,this.gbc);
        this.gbc.gridx = 0;
        this.gbc.gridy = 1;
        this.add(this.lblVege,this.gbc);
        this.gbc.gridx = 1;
        this.gbc.gridy = 1;
        this.add(this.tfVege,this.gbc);
        this.gbc.gridx = 2;
        this.gbc.gridy = 1;
        JLabel l2 = new JLabel("%");
        l2.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        l2.setForeground(Color.white);
        this.add(l2,this.gbc);
        this.gbc.gridx = 0;
        this.gbc.gridy = 2;
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
        if (!this.tfVege.getText().equals("") && !this.tfBoeuf.equals("")) {
            double txB = Double.parseDouble(this.tfBoeuf.getText()) / 100;
            double txV = Double.parseDouble(this.tfVege.getText()) / 100;
            if (txB < 0 || txB > 1 || txV < 0 || txV > 1 || 1 - txB - txV < 0) {
                this.tfBoeuf.setText("");
                this.tfVege.setText("");
                JOptionPane.showMessageDialog(this, "Erreur de saisi, le taux doit etre inclus dand [0,1].");
            }
            else {
                this.controleur.setAlimentation(txB, txV);
                this.removeAll();
                this.repaint();
                this.controleur.terminerAlimentation();
                JLabel tl = new JLabel("Vous avez terminé cette étape !");
                tl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
                tl.setForeground(Color.white);
                this.gbc.gridx = 0;
                this.gbc.gridy = 0;
                this.add(tl,this.gbc);
                this.repaint();
                this.controleur.afficheResultat();
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Veuillez saisir les taux");
        }
    }
}
