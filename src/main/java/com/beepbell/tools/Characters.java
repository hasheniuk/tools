package com.beepbell.tools;

public class Characters {
    public static boolean isAlpha(Character c) {
        if (c == null) return false;
        return c > 64 && c < 91 || c > 96 && c < 123;
    }

    public static boolean isNumeric(Character c) {
        if (c == null) return false;
        return c > 47 && c < 58;
    }

    public static boolean isAlphanumeric(Character c) {
        return isAlpha(c) || isNumeric(c);
    }

    private Characters() {}
}
