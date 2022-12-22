package vue.console;

import java.util.regex.Pattern;

/**
 * A MyExceptions objet is an AppException
 * who check the input exception and IOException
 *
 * @author Qinming JIANG
 * @version 2.0
 */
public class MyExceptions extends Exception{
    /**
     * Instantiates a new My exceptions.
     */
    public MyExceptions() {}

    /**
     * Instantiates a new My exceptions.
     *
     * @param msg the message
     */
    public MyExceptions(String msg) {
        super(msg);
    }

    /**
     * Check each state menu of input.
     *
     * @param car   the choice
     * @param debut the low
     * @param fin   the high
     * @return true if input is well-formed, else false
     * @see MyExceptions
     */
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


    /**
     * Check each information's input
     *
     * @param reg  the regular expression
     * @param text the text
     * @param msg  the message
     * @return true if input is well-formed, else false
     * @see MyExceptions
     */
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

    /**
     * Check each information's input
     *
     * @param reg   the regular expression
     * @param text  the text
     * @param debut the low
     * @param fin   the high
     * @return true if input is well-formed, else false
     * @see MyExceptions
     */
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

    /**
     * Check each rate information's input
     *
     * @param txB the rate meet
     * @param txV the rate vegetable
     * @return true if input is well-formed, else false
     * @see MyExceptions
     */
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

    /**
     * Check utilisateur's data
     *
     * @param txB           the rate meet
     * @param txV           the rate vegetable
     * @param montant       the amount
     * @param superficie    the house size
     * @param niveauEnergie the energy rate
     * @param taille        the car's size
     * @param kilomettre    the car's year kilometer
     * @param amortissement the car's year amortization
     * @param cpt           the counter
     * @return true if all the data is correct, else false
     * @see java.io.IOException
     */
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
