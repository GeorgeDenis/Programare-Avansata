package app;



import org.example.DisplayLocales;
import org.example.Info;
import org.example.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", LocaleExplore.class.getClassLoader().getUnnamedModule());
        System.out.println(bundle);

        while (true) {
            System.out.println(bundle.getString("prompt"));
            String command = scanner.nextLine();

            if (command.equals("locales")) {
                DisplayLocales.execute();
            } else if (command.startsWith("set ")) {
                String languageTag = command.substring(4);
                SetLocale.execute(languageTag);
            } else if (command.startsWith("info")) {
                String languageTag = command.length() > 5 ? command.substring(5).trim() : "";
                if (languageTag.isEmpty()) {
                    Info.execute(Locale.getDefault());
                } else {
                    Locale locale = Locale.forLanguageTag(languageTag);
                    Info.execute(locale);
                }
            }
            else if (command.equals("exit")) {
                break;
            } else {
                System.out.println(bundle.getString("invalid"));

            }

            System.out.println();
        }

        scanner.close();
    }
}
