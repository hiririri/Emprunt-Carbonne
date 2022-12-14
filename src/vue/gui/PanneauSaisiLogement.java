package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A PanneauSaisiLogement objet is an JPanel
 * who allows inputting information of Logement
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class PanneauSaisiLogement extends JPanel implements ActionListener {
    /**
     * Info label
     */
    private JLabel lbl;

    /**
     * Info text field
     */
    private JTextField textField;

    /**
     * 'Suivant' button
     */
    private JButton btn;

    /**
     * GriaBag Layout Constraints
     */
    private GridBagConstraints gbc;

    /**
     * Panel color
     */
    private Color color;

    /**
     * List of sub panels
     */
    private List<JPanel> lst;

    /**
     * Controller
     */
    private Controleur controleur;

    /**
     * Instantiates a new Panneau saisi logement.
     *
     * @param color      the color
     * @param controleur the controller
     */
    public PanneauSaisiLogement(Color color, Controleur controleur) {
        this.color = color;
        this.controleur = controleur;
        this.btn = new JButton("Suivant");
        this.btn.setBackground(new Color(86, 87, 187));
        this.btn.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.btn.setForeground(Color.white);
        this.lbl = new JLabel("Combien de logement portez-vous ? ");
        this.lbl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.lbl.setForeground(Color.white);
        this.textField = new JTextField(10);
        this.textField.setDocument(new NumberDocument());
        this.setBackground(this.color);

        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.fill = GridBagConstraints.VERTICAL;
        this.add(this.lbl, this.gbc);
        this.gbc.gridx = 1;
        this.gbc.gridy = 0;
        this.gbc.fill = GridBagConstraints.VERTICAL;
        this.add(this.textField, this.gbc);
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
        int nbLogement = 0;
        if (this.textField.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Veuillez saisir le nombre de logement.");
        else {
            nbLogement = Integer.parseInt(this.textField.getText());

            //Ajouter des logements
            if (this.lst == null) {
                // Possede un ou des logements
                if (nbLogement != 0) {
                    this.remove(this.btn);
                    this.lbl.setVisible(false);
                    this.textField.setVisible(false);
                    this.lst = new ArrayList<>();

                    for (int i = 0; i < nbLogement; i++) {
                        JPanel panel = new JPanel();
                        panel.setBackground(this.color);
                        JLabel l1 = new JLabel("Logement N??" + (i+1) + " : ");
                        l1.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
                        l1.setForeground(Color.white);
                        JTextField j1 = new JTextField("", 5);
                        j1.setDocument(new NumberDocument());
                        JLabel j2 = new JLabel("m2");
                        j2.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
                        j2.setForeground(Color.white);
                        JComboBox<String> ceLog = new JComboBox<String>(new String[]{"A","B","C","D","E","F","G"});
                        ceLog.setSelectedIndex(0);

                        panel.add(l1);
                        panel.add(j1);
                        panel.add(j2);
                        panel.add(ceLog);

                        this.gbc.gridx = 0;
                        this.gbc.gridy = i;
                        this.add(panel, this.gbc);

                        this.lst.add(panel);
                    }
                    this.gbc.gridy = nbLogement + 1;
                    this.add(this.btn, this.gbc);
                }
                // Ne possede pas de logement
                else {
                    this.controleur.addLogement(this.controleur.getLogement(0,'A'));
                    this.removeAll();
                    this.controleur.terminerLogement();
                    this.controleur.afficheResultat();
                    JLabel tl = new JLabel("Vous avez termin?? cette ??tape !");
                    tl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
                    tl.setForeground(Color.white);
                    this.gbc.gridx = 0;
                    this.gbc.gridy = 0;
                    this.add(tl,this.gbc);
                    this.repaint();
                }
            }
            //Recuperer les logements ?? l'utilisateur
            else {
                int superficie = 0;
                char niveauEnergie = 0;
                boolean estCompleter = false;
                for (JPanel panel : lst) {
                    for (Component component : panel.getComponents()) {
                        if (component instanceof JTextField) {
                            if (!((JTextField) component).getText().equals("")) {
                                superficie = Integer.parseInt(((JTextField) component).getText());
                                estCompleter = true;
                            }
                            else {
                                estCompleter = false;
                                break;
                            }
                        }
                        if (component instanceof JComboBox<?>) {
                            if (((JComboBox<?>) component).getSelectedItem() != null) {
                                if (((JComboBox<?>) component).getSelectedItem().equals("A")) niveauEnergie = 'A';
                                if (((JComboBox<?>) component).getSelectedItem().equals("B")) niveauEnergie = 'B';
                                if (((JComboBox<?>) component).getSelectedItem().equals("C")) niveauEnergie = 'C';
                                if (((JComboBox<?>) component).getSelectedItem().equals("D")) niveauEnergie = 'D';
                                if (((JComboBox<?>) component).getSelectedItem().equals("E")) niveauEnergie = 'E';
                                if (((JComboBox<?>) component).getSelectedItem().equals("F")) niveauEnergie = 'F';
                                if (((JComboBox<?>) component).getSelectedItem().equals("G")) niveauEnergie = 'G';
                            }
                        }
                    }
                    if (!estCompleter)
                        break;
                    this.controleur.addLogement(this.controleur.getLogement(superficie,niveauEnergie));
                }
                if (estCompleter) {
                    this.removeAll();
                    this.controleur.terminerLogement();
                    JLabel tl = new JLabel("Vous avez termin?? cette ??tape !");
                    tl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
                    tl.setForeground(Color.white);
                    this.gbc.gridx = 0;
                    this.gbc.gridy = 0;
                    this.add(tl,this.gbc);
                    this.repaint();
                    this.controleur.afficheResultat();
                }
                else
                    JOptionPane.showMessageDialog(this, "Veuillez completer toutes les informations !");
            }
        }
    }
}
