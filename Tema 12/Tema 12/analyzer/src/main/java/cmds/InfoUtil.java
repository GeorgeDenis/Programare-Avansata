package cmds;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class InfoUtil {

    /**
     * Afișează detaliile despre clasa dată, inclusiv câmpurile și metodele declarate ale acesteia.
     * @param test clasa despre care se vor afișa detaliile.
     */
    public static void execute(Class test) {
        System.out.println(test + "{");

        for (Field m : test.getDeclaredFields()) {

            System.out.println("    " + m + ";");

        }

        for (Method m : test.getDeclaredMethods()) {

            System.out.println("    " + m + ";");

        }
        System.out.println("}");
    }
}
