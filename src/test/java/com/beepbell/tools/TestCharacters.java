package com.beepbell.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCharacters {

    @Test
    public void test_is_alpha() {
        assertFalse(Characters.isAlpha(null));
        assertFalse(Characters.isAlpha('$'));
        assertFalse(Characters.isAlpha('1'));
        assertTrue(Characters.isAlpha('y'));
        assertTrue(Characters.isAlpha('B'));
    }

    @Test
    public void test_is_numeric() {
        assertFalse(Characters.isNumeric(null));
        assertFalse(Characters.isNumeric('$'));
        assertFalse(Characters.isNumeric('a'));
        assertTrue(Characters.isNumeric('0'));
        assertTrue(Characters.isNumeric('5'));
    }

    @Test
    public void test_is_alphanumeric() {
        assertFalse(Characters.isAlphanumeric(null));
        assertFalse(Characters.isAlphanumeric('$'));
        assertTrue(Characters.isAlphanumeric('f'));
        assertTrue(Characters.isAlphanumeric('R'));
        assertTrue(Characters.isAlphanumeric('7'));
    }
}
