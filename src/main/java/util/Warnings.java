package util;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class Warnings {
    public static final String ANSI_RESET = "\\u001B[0m";
    public static final String ANSI_RED = "\\u001B[31m";
    public static final String ANSI_GREEN = "\\u001B[32m";
    public static final String ANSI_YELLOW = "\\u001B[33m";
    public static void warn(String str, int color) {
        AnsiConsole.systemInstall();
        switch(color) {
            case 1:
                System.out.println(ANSI_YELLOW + str + ANSI_RESET);
        }
    }
}
