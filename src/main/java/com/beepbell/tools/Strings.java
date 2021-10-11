package com.beepbell.tools;

import java.util.Base64;

public class Strings {

    public static boolean hasLength(String s) {
        return s != null && !s.isEmpty();
    }

    public static boolean hasText(String s) {
        if (s == null) return false;
        for (int i = 0; i < s.length(); i++)
            if (!Character.isWhitespace(s.charAt(i))) return true;
        return false;
    }

    public static boolean isAlpha(String s) {
        if (!hasLength(s)) return false;
        for (int i = 0; i < s.length(); i++)
            if (!Characters.isAlpha(s.charAt(i))) return false;
        return true;
    }

    public static boolean isNumeric(String s) {
        if (!hasLength(s)) return false;
        for (int i = 0; i < s.length(); i++)
            if (!Characters.isNumeric(s.charAt(i))) return false;
        return true;
    }

    public static boolean isAlphanumeric(String s) {
        if (!hasLength(s)) return false;
        for (int i = 0; i < s.length(); i++)
            if (!Characters.isAlphanumeric(s.charAt(i))) return false;
        return true;
    }

    public static String leftPad(String s, char c, int size) {
        if (s == null || s.length() >= size) return s;
        return repeat(c, size - s.length()) + s;
    }

    public static String rightPad(String s, char c, int size) {
        if (s == null || s.length() >= size) return s;
        return s + repeat(c, size - s.length());
    }

    public static String center(String s, char c, int size) {
        if (s == null || s.length() >= size) return s;
        int n = size - s.length();
        return repeat(c, n / 2) + s + repeat(c, n - (n / 2));
    }

    public static String repeat(char c, int size) {
        if (size < 1) return "";
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) sb.append(c);
        return sb.toString();
    }

    public static boolean hasTwinNeighbors(String s) {
        if (s == null || s.length() < 2) return false;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == s.charAt(i - 1)) return true;
        return false;
    }

    public static String encodeBase64(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    public static String decodeBase64(String s) {
        return new String(Base64.getDecoder().decode(s));
    }

    public static String capitalize(String s) {
        if (!hasLength(s)) return s;
        char first = s.charAt(0);
        char capital = Character.toUpperCase(first);
        if (capital == first) return s;
        char[] chars = s.toCharArray();
        chars[0] = capital;
        return new String(chars);
    }

    private Strings() {}
}
