package vue.console;

import controleur.Controleur;
import model.consoCarbone.*;
import model.utilisateur.Utilisateur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuPrincipal {
    private List<String> menu;
    private Controleur controleur;

    public MenuPrincipal(Controleur controleur) {
        this.controleur = controleur;
    }

    public void choisirInterface() {
        System.out.println("1. Interface console.");
        System.out.println("2. Interface graphique.");
        System.out.println("3. Charger un utilisateur a partir d'un ficher.");
        System.out.println("0. Quitter");
        System.out.print("Veuillez choisir un numero : ");
    }

    public char getAction(int etat) {
        char car = 0;

        if (etat == 0) {
            Scanner sc = new Scanner(System.in);
            car = sc.next().charAt(0);
            while (!Character.isDigit(car)) {
                System.out.print("Saisir DOIT ETRE UN NUMERO. Veuillez resaisir votre action : ");
                car = sc.next().charAt(0);
            }
            while (car < '0' || car > '3') {
                System.out.print("Saisir DOIT ETRE INCLUS DANS [0,3]. Veuillez resaisir votre action : ");
                car = sc.next().charAt(0);
            }
        }
        else if (etat == 1) {
            Scanner sc = new Scanner(System.in);
            car = sc.next().charAt(0);
            while (!Character.isDigit(car)) {
                System.out.print("Saisir DOIT ETRE UN NUMERO. Veuillez resaisir votre action : ");
                car = sc.next().charAt(0);
            }
            while (car < '0' || car > (char)(menu.size() + 46)) {
                System.out.print("Saisir DOIT ETRE INCLUS DANS [0," + (char)(menu.size() + 46) + "]. Veuillez resaisir votre action : ");
                car = sc.next().charAt(0);
            }
        }
        else if (etat == 2) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            car = str.charAt(0);
            if (str.charAt(0) == 'R')
                return str.charAt(0);
            while (!Pattern.matches("^[R|\\d{1}]$",str)) {
                System.out.print("Saisir DOIT ETRE UN NUMERO [0,9] OU 'R'. Veuillez resaisir : ");
                str = sc.next();
                if (str.charAt(0) == 'R')
                    return str.charAt(0);
                car = str.charAt(0);
            }
        }
        
        return car;
    }

    public void frameCUI() {
        menu = new ArrayList<>();
        menu.add("1. Calculer l'empreinte carbon dans Transport");
        menu.add("2. Calculer l'empreinte carbon dans Logement");
        menu.add("3. Calculer l'empreinte carbon dans Alimentation");
        menu.add("4. Calculer l'empreinte carbon dans Bien Consommation");
        menu.add("0. Retourner");
        menu.add("Veuillez choisir un numero : ");
        for (int i = 0; i < menu.size()-1; i++)
            System.out.println(menu.get(i));
        System.out.print(menu.get(menu.size()-1));

        char action = this.getAction(1);

        while (true) {
            if (action == '0') {
                this.controleur.retourner();
                break;
            }
            for (int i = 0; i < menu.size(); i++) {
                if (action == menu.get(i).charAt(0)) {
                    if (menu.get(i).substring(36).equals("Transport")) {
                        if (this.menuTransport())
                            menu = this.majMenu(menu.get(i).substring(36), menu);
                    }
                    else if (menu.get(i).substring(36).equals("Logement")) {
                        if (this.menuLogement())
                            menu = this.majMenu(menu.get(i).substring(36), menu);
                    }
                    else if (menu.get(i).substring(36).equals("Alimentation")) {
                        if (this.menuAlimentation())
                            menu = this.majMenu(menu.get(i).substring(36), menu);
                    }
                    else if (menu.get(i).substring(36).equals("Bien Consommation")) {
                        if (this.menuBienConso())
                            menu = this.majMenu(menu.get(i).substring(36), menu);
                    }
                }

                if (menu.size() == 2) {
                    System.out.println(String.format("Mon Empreinte Carbonne : %.2f tonnes CO2 / an", this.controleur.calculerImpact()/1000));
                    this.controleur.detaillerResultat();
                    this.controleur.reconmmander();
                    System.exit(0);
                }
            }
            menu.forEach(System.out::println);
            action = this.getAction(1);
        }
    }

    private List<String> majMenu(String secteur, List<String> menu) {
        for (int i = 0; i < menu.size(); i++)
            if (menu.get(i).contains(secteur))
                menu.remove(i);

        for (int i = 0; i < menu.size(); i++) {
            String str = menu.get(i);
            if (Character.isDigit(str.charAt(0)) && str.charAt(0) != '0')
                str = str.replace(str.charAt(0), (char) (i + 49));
            menu.set(i, str);
        }

        return menu;
    }

    private boolean menuBienConso() {
        Scanner sc = new Scanner(System.in);
        String repMontant = null;

        System.out.print("Veuillez saisir le montant depense annuel (EURO)(Appuyer 'R' pour retourner) : ");
        repMontant = sc.next();
        if (repMontant.equals("R"))
            return false;
        while (!Pattern.matches("^\\d{0,9}$",repMontant)) {
            System.out.println("Saisi DOIT ETRE UN CHIFFRE");
            repMontant = sc.next();
        }
        this.controleur.setBienConso(Integer.parseInt(repMontant));

        return true;
    }

    private boolean menuAlimentation() {
        Scanner sc = new Scanner(System.in);
        String repTxB = null, repTxV = null;
        int txB, txV;
        System.out.print("Veuillez saisir le taux du beouf annuel (%)(Appuyer 'R' pour retourner) : ");
        repTxB = sc.next();
        repTxB = this.verifierTaux(repTxB,sc);
        if (repTxB.equals("R"))
            return false;
        txB = Integer.parseInt(repTxB);
        System.out.print("Veuillez saisir le taux du vegetarien annuel (%)(Appuyer 'R' pour retourner) : ");
        repTxV = sc.next();
        repTxV = this.verifierTaux(repTxV,sc);
        if (repTxV.equals("R"))
            return false;
        txV = Integer.parseInt(repTxV);
        this.controleur.setAlimentation(txB,txV);

        return true;
    }

    private String verifierTaux(String str, Scanner sc) {
        if (str.equals("R"))
            return str;
        while (!Pattern.matches("^\\d{0,3}$",str)) {
            System.out.println("Saisi DOIT ETRE UN CHIFFRE");
            str = sc.next();
            while (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 100) {
                System.out.println("Saisi DOIT ETRE CONTENU DANS [0,100]");
                str = sc.next();
            }
        }
        return str;
    }

    private boolean menuLogement() {
        Scanner sc = new Scanner(System.in);
        char repNbLogement;
        System.out.print("Combien de logement portez-vous (Appuyer 'R' pour retourner) ? ");
        repNbLogement = this.getAction(2);
        if (repNbLogement == 'R')
            return false;
        if (repNbLogement == '0')
            this.controleur.addLogement(new Logement(0, CE.A));
        else {
            for (int i = 0; i < (int)repNbLogement - 48; i++) {
                System.out.print("Format : (Superficie (6 chiffres max)),(Niveau energie (A-G))\n" +
                                 "Veuillez saisir les information de votre logement N° " + (i+1) + " : ");
                String str = sc.next();
                while (!Pattern.matches("^\\d{0,6},[A-G]$", str)) {
                    System.out.print("Format : (Superficie (6 chiffres max)),(Niveau energie (A-G))\n" +
                                     "Saisir DOIT ETRE EN FORMAT. Veuillez resaisir l'ensemble d'informations : ");
                    str = sc.next();
                }
                String[] tabInfo = str.split(",");
                Logement l = new Logement();
                l.setSuperficie(Integer.parseInt(tabInfo[0]));
                if (tabInfo[1].equals("A")) l.setCe(CE.A);
                if (tabInfo[1].equals("B")) l.setCe(CE.B);
                if (tabInfo[1].equals("C")) l.setCe(CE.C);
                if (tabInfo[1].equals("D")) l.setCe(CE.D);
                if (tabInfo[1].equals("E")) l.setCe(CE.E);
                if (tabInfo[1].equals("F")) l.setCe(CE.F);
                if (tabInfo[1].equals("G")) l.setCe(CE.G);
                this.controleur.addLogement(l);
            }
        }

        return true;
    }

    private boolean menuTransport() {
        Scanner sc = new Scanner(System.in);
        char repNbVoiture;
        System.out.print("Combien de voiture portez-vous (Appuyer 'R' pour retourner) ? ");
        repNbVoiture = this.getAction(2);
        if (repNbVoiture == 'R')
            return false;
        if (repNbVoiture == '0')
            this.controleur.addVoiture(new Transport(false));
        else {
            for (int i = 0; i < (int)repNbVoiture - 48; i++) {
                System.out.print("Format : (Taille (P/G)),(Kilometre (7 chiffres max)),(Annee d'armotissement (3 chiffres max))\n" +
                                 "Veuillez saisir les information de votre voitrue N° " + (i+1) + " : ");
                String str = sc.next();
                while (!Pattern.matches("^[P|G],\\d{0,7},\\d{0,3}$", str)) {
                    System.out.print("Format : (Taille (P/G)),(Kilometre),(Annee d'armotissement)\n" +
                                     "Saisir DOIT ETRE EN FORMAT. Veuillez resaisir l'ensemble d'informations : ");
                    str = sc.next();
                }
                String[] tabInfo = str.split(",");
                this.controleur.addVoiture(new Transport(
                        ((tabInfo[0].equals("P"))?Taille.P:Taille.G),
                        Integer.parseInt(tabInfo[1]),
                        Integer.parseInt(tabInfo[2])
                        )
                );
            }
        }

        return true;
    }

    public void chargerUtilisateur() {
        try {
            File file = new File("./src/data.txt");
            InputStreamReader read = null;
            if (file.isFile() && file.exists()) {
                read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = "";
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] tabInfo = lineTxt.split(" ");
                    this.controleur.chargerUtilisateur(
                            Double.parseDouble(tabInfo[0]),
                            Double.parseDouble(tabInfo[1]),
                            Integer.parseInt(tabInfo[2]),
                            Integer.parseInt(tabInfo[3]),
                            tabInfo[4].charAt(0),
                            tabInfo[5].charAt(0),
                            Integer.parseInt(tabInfo[6]),
                            Integer.parseInt(tabInfo[7]));
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherNouvelUtilisateur(Utilisateur utilisateur) {
        System.out.println(String.format("Empreinte Carbonne de l'utilisateur charge : %.2f tonnes CO2 / an", this.controleur.calculerImpact()/1000));
        utilisateur.detaillerEmpreinte();
        utilisateur.recommender();
        this.controleur.retourner();
    }
}
