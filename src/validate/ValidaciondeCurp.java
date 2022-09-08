package validate;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ValidaciondeCurp {

    private static final Logger LOG = Logger.getLogger("validate.ValidaciondeCurp");

    public static void main(String args[]) {

        LOG.setLevel(Level.WARNING);

        if(args.length == 0) {
            LOG.severe("No se proporciono ningun caracter para la CURP.");
            System.exit(1);
        }

        String curp = args[0];

        if( checkCurp(curp)) {
            System.out.printf("El curp %s es valida ",curp);
            LOG.info("OK");
        } else {
            System.out.printf("El curp %s no es valida ",curp);
            LOG.info("FAIL");
        }


    }

    public static boolean checkCurp(String curp ) {
        boolean isCorrect = false;

        final String CURPBUENA = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}\\d{6}[HM]{1}" +
                "(AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
                "[BCDFGHJKLMNÑPQRSTVXZWY]{3}[0-9A-Z]{1}\\d{1}$";

        isCorrect = Pattern.matches(CURPBUENA,curp);

        return isCorrect;
    }




}
