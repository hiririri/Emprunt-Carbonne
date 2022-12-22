package vue.console;

import java.util.regex.Pattern;

public class MyExceptions extends Exception{
    public MyExceptions() {}

    public MyExceptions(String msg) {
        super(msg);
    }

    public static boolean verifierSaisiEtatMenu(char car, char debut, char fin){
        try {
            if (!Character.isDigit(car))
                throw new MyExceptions("Saisir \033[1;93mDOIT ETRE UN NUMERO\033[m. Veuillez resaisir votre action : ");

            if (car < debut || car > fin)
                throw new MyExceptions("Saisir \033[1;93mDOIT ETRE CONTENU DANS [" + debut + "," + fin + "]\033[m. Veuillez resaisir votre action : ");
        } catch (MyExceptions e) {
            System.out.print(e.getMessage());
            return false;
        }

        return true;
    }


    public static boolean verifierSaisiInfo(String reg, String text, String msg) {
        try {
            if (!Pattern.matches(reg, text))
                throw new MyExceptions(msg);
        } catch (MyExceptions e) {
            System.out.print(e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean verifierSaisiInfo(String reg, String text, int debut, int fin) {
        try {
            if (!Pattern.matches(reg,text))
                throw new MyExceptions("Saisi \033[1;93mDOIT ETRE UN CHIFFRE\033[m. Veuillez resaisir un chiffre : ");
            if (Integer.parseInt(text) < 0 || Integer.parseInt(text) > 100)
                throw new MyExceptions("Saisir \033[1;93mDOIT ETRE CONTENU DANS [" + debut + "," + fin + "]\033[m. Veuillez resaisir un chiffre : ");
        } catch (MyExceptions e) {
            System.out.print(e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean verifierSaisiInfo(double txB, double txV) {
        try {
            if (1 - txB - txV < 0)
                throw new MyExceptions("\033[1;93mTaux du beouf + Taux du vege DOIT ETRE INFERIEURE A 1\033[m!");
        } catch (MyExceptions e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean verifierSaisiEtatMenu(String reg, char car) {
        try {
            if (car != 'O' && car != 'N')
                throw new MyExceptions("Saisi \033[1;93mDOIT ETRE O(Oui) ou N(Non)\033[m. Veuillez resaisir : ");
        } catch (MyExceptions e) {
            System.out.print(e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean verifierChargerUtilisateur(double txB, double txV, int montant, int superficie, char niveauEnergie,
                                                     char taille, int kilomettre, int amortissement, int cpt) {
        try {
            if (txB < 0 || txV < 0 || 1 - txB - txV < 0 || montant < 0 || superficie < 0 ||
                niveauEnergie < 'A' || niveauEnergie > 'G' || taille != 'P' && taille != 'G' || kilomettre < 0 || amortissement < 0)
                throw new MyExceptions("\033[1;91mMauvaises données utilisateur " + cpt + " dans le ficher data.txt\033[m.");
        } catch (MyExceptions e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
