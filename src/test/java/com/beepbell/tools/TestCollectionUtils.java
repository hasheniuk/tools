package com.beepbell.tools;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestCollectionUtils {

    @Test
    public void test_is_array_empty() {
        assertTrue(DataStructures.isEmpty((int[]) null));
        assertTrue(DataStructures.isEmpty(new int[0]));
        assertTrue(DataStructures.isEmpty(new long[0]));
        assertTrue(DataStructures.isEmpty(new double[0]));
        assertFalse(DataStructures.isEmpty(new int[] { 1 }));
    }

    @Test
    public void test_swap_byte() {
        byte[] arr = new byte[] { 0, 1, 2, 3, 4 };
        DataStructures.swap(arr, 1, 3);
        assertArrayEquals(arr, new byte[] { 0, 3, 2, 1, 4});
    }

    @Test
    public void test_swap_int() {
        int[] arr = new int[] { 0, 1, 2, 3, 4 };
        DataStructures.swap(arr, 1, 3);
        assertArrayEquals(arr, new int[] { 0, 3, 2, 1, 4});
    }

    @Test
    public void test_swap_char() {
        char[] arr = new char[] { '0', '1', '2', '3', '4' };
        DataStructures.swap(arr, 1, 3);
        assertArrayEquals(arr, new char[] { '0', '3', '2', '1', '4' });
    }

    @Test
    public void test_swap_boolean() {
        boolean[] arr = new boolean[] { true, true, true, false };
        DataStructures.swap(arr, 1, 3);
        assertArrayEquals(arr, new boolean[] { true, false, true, true });
    }

    @Test
    public void test_swap_Object() {
        String[] arr = new String[] { "0", "1", "2", "3", "4" };
        DataStructures.swap(arr, 1, 3);
        assertArrayEquals(arr, new String[] { "0", "3", "2", "1", "4" });
    }

    @Test
    public void test_is_empty() {
        assertTrue(DataStructures.isEmpty((List) null));
        List<String> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        assertTrue(DataStructures.isEmpty(list));
        assertTrue(DataStructures.isEmpty(map));
        list.add("abc");
        map.put(1, "qwerty");
        assertFalse(DataStructures.isEmpty(list));
        assertFalse(DataStructures.isEmpty(map));
    }

    @Test
    public void test_first_array_list() {
        List<String> list = null;
        assertNull(DataStructures.first(list));
        list = new ArrayList<>();
        assertNull(DataStructures.first(list));
        list.add("string1");
        assertEquals("string1", DataStructures.first(list));
        list.add("string2");
        assertEquals("string1", DataStructures.first(list));
    }

    @Test
    public void test_first_linked_hash_map() {
        Map<Integer, String> map = null;
        assertNull(DataStructures.first(map));
        assertNull(DataStructures.firstKey(map));
        assertNull(DataStructures.firstValue(map));
        map = new LinkedHashMap<>();
        assertNull(DataStructures.first(map));
        assertNull(DataStructures.firstKey(map));
        assertNull(DataStructures.firstValue(map));
        map.put(1, "abc");
        assertEquals(new Integer(1), DataStructures.first(map).getKey());
        assertEquals("abc", DataStructures.first(map).getValue());
        assertEquals(new Integer(1), DataStructures.firstKey(map));
        assertEquals("abc", DataStructures.firstValue(map));
        map.put(2, "def");
        assertEquals(new Integer(1), DataStructures.first(map).getKey());
        assertEquals("abc", DataStructures.first(map).getValue());
        assertEquals(new Integer(1), DataStructures.firstKey(map));
        assertEquals("abc", DataStructures.firstValue(map));
    }

    @Test
    public void test_index_of_regex() {
        List<String> strings = Arrays.asList("abc", "123", "ghiabdc", "0ydssf");
        assertEquals(0, DataStructures.indexOfRegex(strings, "abc"));
        assertEquals(1, DataStructures.indexOfRegex(strings, "^1.*"));
        assertEquals(2, DataStructures.indexOfRegex(strings, ".*bdc$"));
        assertEquals(3, DataStructures.indexOfRegex(strings, ".*ss.*"));
        assertEquals(-1, DataStructures.indexOfRegex(strings, ".*4.*"));
    }

    @Test
    public void test_as_hex_string() {
        assertNull(DataStructures.asHexString(null));
        assertEquals("", DataStructures.asHexString(new byte[0]));
        assertEquals("ff0001", DataStructures.asHexString(new byte[]{-1,0,1}));
    }
}
