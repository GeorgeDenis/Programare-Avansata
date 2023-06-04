package org.example;

import java.util.Locale;

/**
 * Metoda afiseaza zonele disponibile
 */
public class DisplayLocales {
    public void execute() {
        Locale available[] = Locale.getAvailableLocales();
        for(Locale locale : available) {
            System.out.println(locale.getDisplayName());
        }
    }
}
