package vue.gui;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;

/**
 * A PanneauResultat objet is an JPanel
 * who allows seeing the result of calculating carbon emissions
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class PanneauResultat extends JPanel {
    /**
     * Information label
     */
    private JLabel lblInfo;

    /**
     * Data label
     */
    private JLabel lblData;

    /**
     * Unit label
     */
    private JLabel lblUnite;

    /**
     * Instantiates a new Panneau resultat.
     *
     * @param controleur the controller
     */
    public PanneauResultat(Controleur controleur) {
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));

        this.lblInfo = new JLabel("Mon Empreinte Carbone :");
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

    /**
     * Sets result pane.
     *
     * @param res the result
     */
    public void setResultatPane(double res) {
        this.lblData.setText(String.format("%.2f", res));
    }
}
