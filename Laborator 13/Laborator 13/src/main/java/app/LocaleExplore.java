package app;

import org.example.DisplayLocales;
import org.example.Info;
import org.example.SetLocale;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        DisplayLocales displayLocales = new DisplayLocales();
        SetLocale setLocale = new SetLocale();
        Info info = new Info();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            ResourceBundle messages = ResourceBundle.getBundle("Messages", setLocale.getCurrentLocale());
            System.out.println(messages.getString("prompt"));
            String command = scanner.nextLine();

            if(command.equals("display locales")) {
                System.out.println(messages.getString("locales"));
                displayLocales.execute();
            } else if(command.startsWith("set")) {
                String languageTag = command.split(" ")[1];
                setLocale.execute(languageTag);
                String localeSetMessage = MessageFormat.format(messages.getString("locale.set"), setLocale.getCurrentLocale().getDisplayLanguage());
                System.out.println(localeSetMessage);
            } else if(command.equals("info")) {
                String infoMessage = MessageFormat.format(messages.getString("info"), setLocale.getCurrentLocale().getDisplayLanguage());
                System.out.println(infoMessage);
                info.execute(setLocale.getCurrentLocale());
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
    }
}
