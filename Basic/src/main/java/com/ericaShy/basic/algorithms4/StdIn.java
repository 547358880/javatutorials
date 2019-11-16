package com.ericaShy.basic.algorithms4;

import java.io.BufferedInputStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class StdIn {

    private static final String CHARSET_NAME = "UTF-8";

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    private static final Locale LOCALE = Locale.US;

    private static Scanner scanner;

    //used to read the entire input
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

    static {
        resync();
    }

    private static void resync() {
        setScanner(new Scanner(new BufferedInputStream(System.in), CHARSET_NAME));
    }

    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
        StdIn.scanner.useLocale(LOCALE);
    }

    private StdIn() { }

    private static String readAll() {
        if (!scanner.hasNextLine()) {
            return "";
        }

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    /**
     * Reads all remaining tokes from standard input and returns them as an array
     */
    public static String[] readAllStrings() {
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0) {
            return tokens;
        }

        String[] decaptitokens = new String[tokens.length - 1];
        for (int i = 0; i < tokens.length - 1; i++) {
            decaptitokens[i] = tokens[i + 1];
        }
        return decaptitokens;
    }
}
