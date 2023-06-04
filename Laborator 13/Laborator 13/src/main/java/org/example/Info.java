package org.example;

import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public static void execute(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);

        String currentLocale = locale.getDisplayName(locale);

        System.out.println(bundle.getString("info").replace("{0}", currentLocale));

        // Display country and language
        String country = locale.getDisplayCountry(locale);
        String language = locale.getDisplayLanguage(locale);
        if (!country.isEmpty()) {
            System.out.println("Country: " + country + " (" + language + ")");
        } else {
            System.out.println("Language: " + language);
        }

        // Display currency
        Currency currency;
        try {
            currency = Currency.getInstance(locale);
            System.out.println(locale);
            System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Currency: RON");
        }

        // Display week days
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        String[] weekDays = dateFormatSymbols.getWeekdays();
        System.out.println("Week Days: " + String.join(", ", (CharSequence[]) weekDays));

        // Display months
        String[] months = dateFormatSymbols.getMonths();
        System.out.println("Months: " + String.join(", ", (CharSequence[]) months));

        // Display today's date
        // You should use a real date instance here. The code below is for illustration only.
        String date = DateFormatSymbols.getInstance(locale).getMonths()[4] + " 8, 2016";
        System.out.println("Today: " + date);
    }
}
