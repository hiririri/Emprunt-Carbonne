package vue.console;

import controleur.Controleur;
import model.consoCarbone.Avion;
import model.utilisateur.Utilisateur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private List<String> menu;
    private Controleur controleur;

    public MenuPrincipal(Controleur controleur) {
        this.controleur = controleur;
    }

    public void choisirInterface() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                          \033[1;95m* Menu Principal *\033[m                         |");
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("\033[1;92m1\033[m. Interface console.");
        System.out.println("\033[1;92m2\033[m. Interface graphique.");
        System.out.println("\033[1;92m3\033[m. Charger un utilisateur a partir d'un ficher.");
        System.out.println("\033[1;92m4\033[m. Tester la classe ServicePublics. (Cette option entrainera la fermeture du programme.)");
        System.out.println("\033[1;92m5\033[m. Tester la classe Voiture. (Cette option entrainera la fermeture du programme.)");
        System.out.println("\033[1;92m0\033[m. Quitter");
        System.out.print("Veuillez choisir un numero : ");
    }

    public char getAction(int etat) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char car = str.charAt(0);

        switch (etat) {
            case 0 -> {
                while (!MyExceptions.verifierSaisiEtatMenu(car,'0','5'))
                    car = sc.next().charAt(0);
            }
            case 1 -> {
                while (!MyExceptions.verifierSaisiEtatMenu(car,'0',(char)(menu.size() + 46)))
                    car = sc.next().charAt(0);
            }
            case 2 -> {
                if (str.charAt(0) == 'R')
                    return str.charAt(0);
                while (!MyExceptions.verifierSaisiInfo("^[R|\\d{1}]$",str,"Saisir \033[1;93mDOIT ETRE UN NUMERO [0,9] OU 'R'\033[m. Veuillez resaisir : ")) {
                    str = sc.next();
                    if (str.charAt(0) == 'R')
                        return str.charAt(0);
                    car = str.charAt(0);
                }
            }
            case 3 -> {
                while (!MyExceptions.verifierSaisiEtatMenu("^[O|N]$",car))
                    car = sc.next().charAt(0);
            }
        }
        
        return car;
    }

    public void frameCUI() {
        menu = new ArrayList<>();
        menu.add("1. Calculer l'empreinte carbon dans Voiture");
        menu.add("2. Calculer l'empreinte carbon dans Avion");
        menu.add("3. Calculer l'empreinte carbon dans Logement");
        menu.add("4. Calculer l'empreinte carbon dans Alimentation");
        menu.add("5. Calculer l'empreinte carbon dans Bien Consommation");
        menu.add("0. Retourner");
        menu.add("Veuillez choisir un numero : ");
        this.afficherMenu();

        char action = this.getAction(1);

        while (true) {
            if (action == '0') {
                this.controleur.retourner();
                break;
            }
            for (int i = 0; i < menu.size(); i++) {
                if (action == menu.get(i).charAt(0)) {
                    if (menu.get(i).substring(36).equals("Voiture")) {
                        if (this.menuVoiture())
                            menu = this.majMenu(menu.get(i).substring(36), menu);
                    }
                    else if (menu.get(i).substring(36).equals("Avion")) {
                        if (this.menuAvion())
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
                    this.afficherPanneauResultat();
                    this.controleur.detaillerResultat();
                    this.controleur.reconmmander();
                    this.controleur.retourner();
                    break;
                }
            }
            if (menu.size() == 2)
                break;
            this.afficherMenu();
            action = this.getAction(1);
        }
    }



    private void afficherMenu() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                          \033[1;96m* Menu Saisi *\033[m                             |");
        System.out.println("+---------------------------------------------------------------------+");
        for (int i = 0; i < menu.size()-1; i++)
            System.out.println("\033[1;92m" + menu.get(i).charAt(0) + "\033[m" + menu.get(i).substring(1));
        System.out.print(menu.get(menu.size()-1));
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
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                        \033[1;91m* Bien Consommation *\033[m                        |");
        System.out.println("+---------------------------------------------------------------------+");
        Scanner sc = new Scanner(System.in);
        String repMontant = null;

        System.out.print("Veuillez saisir le montant depense annuel (EURO)(Appuyer 'R' pour retourner) : ");
        repMontant = sc.next();
        if (repMontant.equals("R"))
            return false;
        while (!MyExceptions.verifierSaisiInfo("^\\d{0,9}$",repMontant,"Saisi DOIT ETRE UN CHIFFRE. Veuillez resaisir : "))
            repMontant = sc.next();
        this.controleur.setBienConso(Integer.parseInt(repMontant));

        return true;
    }

    private boolean menuAlimentation() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                           \033[1;91m* Alimentation *\033[m                          |");
        System.out.println("+---------------------------------------------------------------------+");
        Scanner sc = new Scanner(System.in);
        String repTxB = null, repTxV = null;
        double txB, txV;
        do {
            System.out.print("Veuillez saisir le taux du beouf annuel (%)(Appuyer '\033[1;92mR\033[m' pour retourner) : ");
            repTxB = sc.next();
            repTxB = this.verifierTaux(repTxB,sc);
            if (repTxB.equals("R"))
                return false;
            txB = Double.parseDouble(repTxB);
            System.out.print("Veuillez saisir le taux du vegetarien annuel (%)(Appuyer '\033[1;92mR\033[m' pour retourner) : ");
            repTxV = sc.next();
            repTxV = this.verifierTaux(repTxV,sc);
            if (repTxV.equals("R"))
                return false;
            txV = Double.parseDouble(repTxV);
        } while (!MyExceptions.verifierSaisiInfo(txB/100,txV/100));

        this.controleur.setAlimentation(txB/100,txV/100);

        return true;
    }

    private String verifierTaux(String str, Scanner sc) {
        if (str.equals("R"))
            return str;
        while (!MyExceptions.verifierSaisiInfo("^\\d+(\\.\\d+)?$",str,0,100)) {
            str = sc.next();
            if (str.equals("R"))
                return str;
        }

        return str;
    }

    private boolean menuLogement() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                             \033[1;91m* Logement *\033[m                            |");
        System.out.println("+---------------------------------------------------------------------+");
        Scanner sc = new Scanner(System.in);
        char repNbLogement;
        System.out.print("Combien de logement portez-vous (Appuyer '\033[1;92mR\033[m' pour retourner) ? ");
        repNbLogement = this.getAction(2);
        if (repNbLogement == 'R')
            return false;
        if (repNbLogement == '0')
            this.controleur.addLogement(this.controleur.getLogement(0,'A'));
        else {
            for (int i = 0; i < (int)repNbLogement - 48; i++) {
                System.out.print("Format : (Superficie)(6 chiffres max),(Niveau energie)(A-G)\n" +
                                 "Exemple : \033[1;92m50,A\033[m\n" +
                                 "Veuillez saisir les informations de votre logement N° " + (i+1) + " : ");
                String str = sc.next();
                String msg = "Format : (Superficie (6 chiffres max)),(Niveau energie (A-G))\n" +
                             "Exemple : \033[1;92m50,A\033[m\n" +
                             "Saisir \033[1;93mDOIT ETRE EN FORMAT\033[m. Veuillez resaisir l'ensemble d'informations : ";
                while (!MyExceptions.verifierSaisiInfo("^\\d{0,6},[A-G]$",str,msg))
                    str = sc.next();
                String[] tabInfo = str.split(",");
                this.controleur.addLogement(this.controleur.getLogement(Integer.parseInt(tabInfo[0]),tabInfo[1].charAt(0)));
            }
        }

        return true;
    }

    private boolean menuVoiture() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                             \033[1;91m* Voiture *\033[m                             |");
        System.out.println("+---------------------------------------------------------------------+");
        Scanner sc = new Scanner(System.in);
        char repNbVoiture;
        System.out.print("Combien de voiture portez-vous (Appuyer '\033[1;92mR\033[m' pour retourner) ? ");
        repNbVoiture = this.getAction(2);
        if (repNbVoiture == 'R')
            return false;
        if (repNbVoiture == '0')
            this.controleur.addTransport(this.controleur.getTransport());
        else {
            for (int i = 0; i < (int)repNbVoiture - 48; i++) {
                System.out.print("Format : (Taille)(P/G),(Kilometre)(9 chiffres max),(Annee d'armotissement)(3 chiffres max)\n" +
                                 "Exemple : \033[1;92mP,100000,6\033[m\n" +
                                 "Veuillez saisir les informations de votre voitrue N° " + (i+1) + " : ");
                String str = sc.next();
                String msg = "Format : (Taille (P/G)),(Kilometre),(Annee d'armotissement)\n" +
                             "Exemple : \033[1;92mP,100000,6\033[m\n" +
                             "Saisir \033[1;93mDOIT ETRE EN FORMAT\033[m. Veuillez resaisir l'ensemble d'informations : ";
                while (!MyExceptions.verifierSaisiInfo("^[P|G],\\d{0,9},\\d{0,3}$",str,msg))
                    str = sc.next();
                String[] tabInfo = str.split(",");
                this.controleur.addTransport(this.controleur.getTransport(tabInfo[0].charAt(0),
                                                                        Integer.parseInt(tabInfo[1]),
                                                                        Integer.parseInt(tabInfo[2])));
            }
        }

        return true;
    }
    private boolean menuAvion() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                              \033[1;91m* Avion *\033[m                              |");
        System.out.println("+---------------------------------------------------------------------+");
        Scanner sc = new Scanner(System.in);
        char nbFois;
        System.out.print("Combien de fois vous avez voyagé en avion ? (Appuyer '\033[1;92mR\033[m' pour retourner) ? ");
        nbFois = this.getAction(2);
        if (nbFois == 'R')
            return false;
        if (nbFois == '0')
            this.controleur.addTransport(this.controleur.getAvion());
        else {
            for (int i = 0; i < (int)nbFois - 48; i++) {
                System.out.print("Format : (Taille)(P/G),(Kilometre)(9 chiffres max)\n" +
                        "Exemple : \033[1;92mP,100000\033[m\n" +
                        "Veuillez saisir les informations de le voyage " + (i+1) + " en Avion : ");
                String str = sc.next();
                String msg = "Format : (Taille (P/G)),(Kilometre)\n" +
                        "Exemple : \033[1;92mP,100000\033[m\n" +
                        "Saisir \033[1;93mDOIT ETRE EN FORMAT\033[m. Veuillez resaisir l'ensemble d'informations : ";
                while (!MyExceptions.verifierSaisiInfo("^[P|G],\\d{0,9}$",str,msg))
                    str = sc.next();
                String[] tabInfo = str.split(",");
                this.controleur.addTransport(this.controleur.getAvion(tabInfo[0].charAt(0),Integer.parseInt(tabInfo[1])));
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
                int cpt = 1;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] tabInfo = lineTxt.split(" ");
                    if (MyExceptions.verifierChargerUtilisateur(Double.parseDouble(tabInfo[0]),
                                                                Double.parseDouble(tabInfo[1]),
                                                                Integer.parseInt(tabInfo[2]),
                                                                Integer.parseInt(tabInfo[3]),
                                                                tabInfo[4].charAt(0),
                                                                tabInfo[5].charAt(0),
                                                                Integer.parseInt(tabInfo[6]),
                                                                Integer.parseInt(tabInfo[7]),
                                                                cpt)) {
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
                    cpt++;
                }
                this.controleur.retourner();
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherNouvelUtilisateur() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                          \033[1;94m* Résultat *\033[m                               |");
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println(String.format("Emprunt Carbonne de l'utilisateur : %.2f tonnes CO2 / an", this.controleur.calculerImpact()));
        this.controleur.detaillerResultat();
        this.controleur.reconmmander();
        this.controleur.retourner();
    }

    public void afficherPanneauResultat() {
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                          \033[1;94m* Résultat *\033[m                               |");
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println(String.format("Emprunt Carbonne de l'utilisateur : %.2f tonnes CO2 / an", this.controleur.calculerImpact()));
    }
}
