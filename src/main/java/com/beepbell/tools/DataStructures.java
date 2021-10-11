package com.beepbell.tools;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.*;

public class DataStructures {

    public static boolean isEmpty(byte[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(short[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(long[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(float[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(double[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(boolean[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(char[] arr) {
        return arr == null || arr.length == 0;
    }

    public static <T> boolean isEmpty(T[] arr) {
        return arr == null || arr.length == 0;
    }

    public static void swap(byte[] arr, int i, int j) {
        byte tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(long[] arr, int i, int j) {
        long tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(boolean[] arr, int i, int j) {
        boolean tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static <E> E first(Collection<E> collection) {
        if (isEmpty(collection)) return null;
        return collection.iterator().next();
    }

    public static <K, V> Map.Entry<K, V> first(Map<K, V> map) {
        if (isEmpty(map)) return null;
        return map.entrySet().iterator().next();
    }

    public static <K> K firstKey(Map<K, ?> map) {
        Map.Entry<K, ?> first = first(map);
        return first == null ? null : first.getKey();
    }

    public static <V> V firstValue(Map<?, V> map) {
        Map.Entry<?, V> first = first(map);
        return first == null ? null : first.getValue();
    }

    public static int indexOfRegex(List<String> strings, String regex) {
        if (isEmpty(strings)) return -1;
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < strings.size(); i++)
            if (pattern.matcher(strings.get(i)).find()) return i;
        return -1;
    }

    public static String asHexString(byte[] bytes) {
        if (bytes == null) return null;
        if (bytes.length == 0) return "";
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "x", bi);
    }

    private DataStructures() {}
}