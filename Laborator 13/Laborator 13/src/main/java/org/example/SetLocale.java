package org.example;

import java.util.Locale;

/**
 * Metoda seteaza zona curenta
 */
public class SetLocale {
    private Locale currentLocale = Locale.getDefault();

    public void execute(String languageTag) {
        Locale.Builder builder = new Locale.Builder();
        builder.setLanguageTag(languageTag);
        currentLocale = builder.build();
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }
}

