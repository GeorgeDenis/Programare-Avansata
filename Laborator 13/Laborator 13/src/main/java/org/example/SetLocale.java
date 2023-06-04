package org.example;

import app.LocaleExplore;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public static void execute(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", LocaleExplore.class.getClassLoader().getUnnamedModule());
        String currentLocale = locale.getDisplayName(locale);
        String message = bundle.getString("locale.set");
        System.out.println(message.replace("{0}", currentLocale));
    }
}
