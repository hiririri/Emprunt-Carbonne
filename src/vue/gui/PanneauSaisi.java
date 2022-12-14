package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A PanneauSaisi objet is an JPanel
 * who allows inputting information
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class PanneauSaisi extends JPanel implements ActionListener {

    /**
     * Sector label
     */
    private JLabel lbl;

    /**
     * Icon label
     */
    private JLabel lblIcon;

    /**
     * 'Commencer' button
     */
    private JButton btn;

    /**
     * Sector
     */
    private String secteur;

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
     * Panel Transport
     */
    private PanneauSaisiTransport pst;

    /**
     * Panel Logement
     */
    private PanneauSaisiLogement psl;

    /**
     * Panel Alimentation
     */
    private PanneauSaisiAlimentation psa;

    /**
     * Panel BienConso
     */
    private PanneauSaisiBienConso psbc;

    /**
     * Panel Avion
     */
    private PanneauSaisiAvion psva;

    /**
     * Scroll pane
     */
    private JScrollPane scrollPane;

    /**
     * Instantiates a new Panneau saisi.
     *
     * @param controleur the controleur
     */
    public PanneauSaisi(Controleur controleur) {
        this.controleur = controleur;
        this.secteur = "Avion";
        this.color = new Color(89, 80, 133);

        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.lbl = new JLabel(this.secteur);
        this.lblIcon = new JLabel(new ImageIcon("./vue/gui/images/" + this.secteur + ".png"));
        this.btn = new JButton("Commencer");

        this.lbl.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
        this.lbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.btn.setBackground(new Color(86, 87, 187));
        this.btn.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 12));
        this.btn.setForeground(Color.white);
        this.setBackground(this.color);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(this.lbl, this.gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(this.lblIcon, this.gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.add(this.btn, this.gbc);

        this.btn.addActionListener(this);
        this.setBackground(this.color);
    }

    /**
     * Set panel state.
     *
     * @param isCommence if button 'Commencer' is clicked.
     */
    private void setEtat(boolean isCommence) {
        this.lbl.setVisible(isCommence);
        this.lblIcon.setVisible(isCommence);
        this.btn.setVisible(isCommence);

        if (this.pst != null) {
            this.remove(this.pst);
            this.remove(this.scrollPane);
        }
        if (this.psl != null) {
            this.remove(this.psl);
            this.remove(this.scrollPane);
        }
        if (this.psa != null) {
            this.remove(this.psa);
            this.remove(this.scrollPane);
        }
        if (this.psbc != null) {
            this.remove(this.psbc);
            this.remove(this.scrollPane);
        }
        if (this.psva != null) {
            this.remove(this.psva);
            this.remove(this.scrollPane);
        }
        this.repaint();
    }

    /**
     * Update panel.
     *
     * @param secteur the sector
     * @param color   the color
     */
    public void majPanneau(String secteur, Color color) {
        this.secteur = secteur;
        this.color = color;
        this.setEtat(true);
        this.lbl.setText(secteur);
        this.setBackground(color);
        this.lblIcon.setIcon(new ImageIcon("./vue/gui/images/" + secteur + ".png"));

        this.psl = null;
        this.pst = null;
    }

    /**
     * Event associated with the button 'Commencer'
     *
     * @param e event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setEtat(false);
        switch (this.secteur) {
            case "Avion" -> {
                this.psva = new PanneauSaisiAvion(this.color, this.controleur);
                this.scrollPane = new JScrollPane(this.psva);
            }
            case "Voiture" -> {
                this.pst = new PanneauSaisiTransport(this.color, this.controleur);
                this.scrollPane = new JScrollPane(this.pst);
            }
            case "Logement" -> {
                this.psl = new PanneauSaisiLogement(this.color, this.controleur);
                this.scrollPane = new JScrollPane(this.psl);
            }
            case "Alimentation" -> {
                this.psa= new PanneauSaisiAlimentation(this.color, this.controleur);
                this.scrollPane = new JScrollPane(this.psa);
            }
            case "BienConso" -> {
                this.psbc = new PanneauSaisiBienConso(this.color, this.controleur);
                this.scrollPane = new JScrollPane(this.psbc);
            }
        }
        scrollPane.setPreferredSize(this.getSize());
        scrollPane.setBackground(this.color);
        this.add(scrollPane);
        this.repaint();
    }
}
