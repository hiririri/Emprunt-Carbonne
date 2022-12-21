package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;

public class PanneauResultat extends JPanel {
    private JLabel lblInfo;
    private JLabel lblData;
    private JLabel lblUnite;

    public PanneauResultat(Controleur controler) {
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));

        this.lblInfo = new JLabel("Mon Empreinte Carbonne :");
        this.lblData = new JLabel("0.0");
        this.lblUnite = new JLabel("tonnes de CO2/an");

        this.lblInfo.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
        this.lblData.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
        this.lblUnite.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 22));
        this.lblInfo.setForeground(Color.white);
        this.lblData.setForeground(Color.white);
        this.lblUnite.setForeground(Color.white);

        this.setBackground(new Color(153,153,255));

        this.add(this.lblInfo);
        this.add(this.lblData);
        this.add(this.lblUnite);
    }

    public void setResultatPane(double res) {
        this.lblData.setText(String.format("%.2f", res));
    }
}
