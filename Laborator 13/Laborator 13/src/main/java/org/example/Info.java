package org.example;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Comanda afiseaza informatii legate de Tara, Limba, Moneda, Zilele saptamanii, luni in functie de zona selectata
 */
public class Info {
    public void execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);

        System.out.println(messages.getString("Country") + ": " + locale.getDisplayCountry());
        System.out.println(messages.getString("Language") + ": " + locale.getDisplayLanguage());
        try {
            System.out.println(messages.getString("Currency") + ": " + Currency.getInstance(locale).getCurrencyCode());
        } catch (IllegalArgumentException e) {
            System.out.println(messages.getString("Currency") + ": No currency associated with this locale");
        }
        System.out.println(messages.getString("Week_Days") + ": " + Arrays.toString(new DateFormatSymbols(locale).getWeekdays()));
        System.out.println(messages.getString("Months") + ": " + Arrays.toString(new DateFormatSymbols(locale).getMonths()));

        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        System.out.println(messages.getString("Today") + ": " + df.format(new Date()));
    }
}
