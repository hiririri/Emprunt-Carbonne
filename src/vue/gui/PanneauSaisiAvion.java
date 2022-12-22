package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanneauSaisiAvion extends JPanel implements ActionListener {
    private JLabel lbl;
    private JTextField textField;
    private JButton btn;
    private GridBagConstraints gbc;
    private Color color;
    private List<JPanel> lst;
    private Controleur controleur;

    public PanneauSaisiAvion(Color color, Controleur controleur) {
        this.controleur = controleur;
        this.color = color;
        this.btn = new JButton("Suivant");
        this.btn.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.btn.setForeground(Color.white);
        this.btn.setBackground(new Color(86, 87, 187));
        this.lbl = new JLabel("Combien de fois vous avez voyagé en avion ? ");
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

    public boolean estNull() {
        return this.textField.getText().equals("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nbVoyage = 0;
        if (this.textField.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Veuillez saisir le nombre de voyage en avion.");
        else {
            nbVoyage = Integer.parseInt(this.textField.getText());

            if (this.lst == null) {
                // Possede un ou des voitures
                if (nbVoyage != 0) {
                    this.remove(this.btn);
                    this.lbl.setVisible(false);
                    this.textField.setVisible(false);
                    this.lst = new ArrayList<>();

                    for (int i = 0; i < nbVoyage; i++) {
                        JPanel panel = new JPanel();
                        panel.setBackground(this.color);
                        JLabel l1 = new JLabel("Voyage N°" + (i+1) + " : ");
                        l1.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
                        l1.setForeground(Color.white);
                        ButtonGroup bg = new ButtonGroup();
                        JRadioButton r1 = new JRadioButton("P ");
                        JRadioButton r2 = new JRadioButton("G ");
                        r1.setSelected(true);
                        r1.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
                        r1.setForeground(Color.white);
                        r2.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
                        r2.setForeground(Color.white);
                        bg.add(r1);
                        bg.add(r2);

                        JTextField j1 = new JTextField("", 5);
                        j1.setDocument(new NumberDocument());
                        JLabel j2 = new JLabel("Kms");
                        j2.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
                        j2.setForeground(Color.white);

                        panel.add(l1);
                        panel.add(r1);
                        panel.add(r2);
                        panel.add(j1);
                        panel.add(j2);

                        this.gbc.gridx = 0;
                        this.gbc.gridy = i;
                        this.add(panel, this.gbc);

                        this.lst.add(panel);
                    }
                    this.gbc.gridy = nbVoyage + 1;
                    this.add(this.btn, this.gbc);
                }
                // Ne possede pas de voiture
                else {
                    this.controleur.addTransport(this.controleur.getAvion());
                    this.removeAll();
                    this.controleur.terminerAvion();
                    this.controleur.afficheResultat();
                    JLabel tl = new JLabel("Vous avez terminé cette étape !");
                    tl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
                    tl.setForeground(Color.white);
                    this.gbc.gridx = 0;
                    this.gbc.gridy = 0;
                    this.add(tl,this.gbc);
                    this.repaint();
                }
            }
            else {
                boolean estCompleter = false;
                for (JPanel panel : lst) {
                    char taille = 0;
                    int kilomettre = 0, amortissement = 1;
                    for (Component component : panel.getComponents()) {
                        if (component instanceof JRadioButton) {
                            if (((JRadioButton) component).isSelected() && ((JRadioButton) component).getText().equals("P "))
                                taille = ((JRadioButton) component).getText().charAt(0);
                            if (((JRadioButton) component).isSelected() && ((JRadioButton) component).getText().equals("G "))
                                taille = ((JRadioButton) component).getText().charAt(0);
                        }
                        if (component instanceof JTextField) {
                            if (((JTextField) component).getText().equals("")) {
                                estCompleter = false;
                                break;
                            }
                            else {
                                if (((JTextField) component).equals(panel.getComponent(3))) {
                                    kilomettre = Integer.parseInt(((JTextField) component).getText());
                                    estCompleter = true;
                                }
                            }
                        }
                    }
                    if (estCompleter) {
                        this.controleur.addTransport(this.controleur.getAvion(taille,kilomettre));
                        this.controleur.calculerImpact();
                        this.remove(panel);
                    }
                    else
                        break;
                }
                if (estCompleter) {
                    this.remove(this.btn);
                    this.controleur.terminerAvion();
                    JLabel tl = new JLabel("Vous avez terminé cette étape !");
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
