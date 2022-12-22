package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanneauSaisi extends JPanel implements ActionListener {
    private JLabel lbl;
    private JLabel lblIcon;
    private JButton btn;
    private String secteur;
    private GridBagConstraints gbc;
    private Color color;
    private Controleur controleur;

    public PanneauSaisi(Controleur controleur) {
        this.controleur = controleur;
        this.secteur = "Avion";
        this.color = new Color(182, 21, 64);

        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.lbl = new JLabel(this.secteur);
        this.lblIcon = new JLabel(new ImageIcon("./src/vue/gui/images/" + this.secteur + ".png"));
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

    public void majPanneau(String secteur, Color color) {
        this.secteur = secteur;
        this.color = color;
        this.setEtat(true);
        this.lbl.setText(secteur);
        this.setBackground(color);
        this.lblIcon.setIcon(new ImageIcon("./src/vue/gui/images/" + secteur + ".png"));

        this.psl = null;
        this.pst = null;
    }
    private PanneauSaisiTransport pst;
    private PanneauSaisiLogement psl;
    private PanneauSaisiAlimentation psa;
    private PanneauSaisiBienConso psbc;
    private PanneauSaisiAvion psva;
    private JScrollPane scrollPane;
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
