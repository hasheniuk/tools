package com.beepbell.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestStrings {

    @Test
    public void test_has_length() {
        assertFalse(Strings.hasLength(null));
        assertFalse(Strings.hasLength(""));
        assertTrue(Strings.hasLength(" "));
        assertTrue(Strings.hasLength("abc"));
        assertTrue(Strings.hasLength("^$(#)"));
    }

    @Test
    public void test_has_text() {
        assertFalse(Strings.hasText(null));
        assertFalse(Strings.hasText(""));
        assertFalse(Strings.hasText(" "));
        assertFalse(Strings.hasText("      \r\n "));
        assertTrue(Strings.hasText("^$(#)"));
    }

    @Test
    public void test_is_alpha() {
        assertFalse(Strings.isAlpha(""));
        assertFalse(Strings.isAlpha("!d2d"));
        assertTrue(Strings.isAlpha("abcde"));
        assertTrue(Strings.isAlpha("FGHIGK"));
        assertTrue(Strings.isAlpha("lmnopQRSTUVWZYX"));
    }

    @Test
    public void test_is_numeric() {
        assertFalse(Strings.isNumeric(null));
        assertFalse(Strings.isNumeric("!d2d"));
        assertTrue(Strings.isNumeric("1234567890"));
        assertTrue(Strings.isNumeric("995"));
    }

    @Test
    public void test_is_alphanumeric() {
        assertFalse(Strings.isAlphanumeric("12a#$^"));
        assertFalse(Strings.isAlphanumeric("!d2d"));
        assertTrue(Strings.isAlphanumeric("123456"));
        assertTrue(Strings.isAlphanumeric("DGFhfs"));
        assertTrue(Strings.isAlphanumeric("Adf335dsdf"));
    }

    @Test
    public void test_left_pad() {
        assertNull(Strings.leftPad(null, ' ', 2));
        assertEquals("  d", Strings.leftPad("d", ' ', 3));
        assertEquals("abc", Strings.leftPad("abc", '0', 3));
    }

    @Test
    public void test_right_pad() {
        assertNull(Strings.rightPad(null, ' ', 2));
        assertEquals("d  ", Strings.rightPad("d", ' ', 3));
        assertEquals("abc", Strings.rightPad("abc", '0', 3));
    }

    @Test
    public void test_center() {
        assertNull(Strings.center(null, ' ', 2));
        assertEquals(" d  ", Strings.center("d", ' ', 4));
        assertEquals("abc", Strings.center("abc", '0', 3));
    }

    @Test
    public void test_repeat() {
        assertEquals("", Strings.repeat('a', -3));
        assertEquals("0000", Strings.repeat('0', 4));
    }

    @Test
    public void test_has_twin_neighbors() {
        assertFalse(Strings.hasTwinNeighbors(null));
        assertFalse(Strings.hasTwinNeighbors("a"));
        assertFalse(Strings.hasTwinNeighbors("a1b2a3cf"));
        assertTrue(Strings.hasTwinNeighbors("abba"));
        assertTrue(Strings.hasTwinNeighbors("null"));
    }

    @Test
    public void test_encode_base_64() {
        assertEquals("QmFzZTY0IUAjJCU=", Strings.encodeBase64("Base64!@#$%"));
        assertEquals("YWJjQG1haWwuY29t", Strings.encodeBase64("abc@mail.com"));
    }

    @Test
    public void test_decode_base_64() {
        assertEquals("Base64!@#$%", Strings.decodeBase64("QmFzZTY0IUAjJCU="));
        assertEquals("abc@mail.com", Strings.decodeBase64("YWJjQG1haWwuY29t"));
    }

    @Test
    public void test_capitalize() {
        assertNull(Strings.capitalize(null));
        assertEquals("", Strings.capitalize(""));
        assertEquals("789daD", Strings.capitalize("789daD"));
        assertEquals("MmmN", Strings.capitalize("mmmN"));
        assertEquals("ABcD2" ,Strings.capitalize("aBcD2"));
    }
}