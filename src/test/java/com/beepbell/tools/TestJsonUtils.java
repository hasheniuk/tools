package com.beepbell.tools;

import com.beepbell.tools.JsonUtils;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestJsonUtils {

    @Test
    public void test_as_json_string() {
        assertNull(JsonUtils.asJsonString(null));
        TestObject testObject = new TestObject(null, null);
        String json = JsonUtils.asJsonString(testObject);
        assertEquals("{\"text\":null,\"array\":null}", json);
        testObject = new TestObject("abc", null);
        json = JsonUtils.asJsonString(testObject);
        assertEquals("{\"text\":\"abc\",\"array\":null}", json);
        testObject = new TestObject("def", new int[]{1,2,3});
        json = JsonUtils.asJsonString(testObject);
        assertEquals("{\"text\":\"def\",\"array\":[1,2,3]}", json);
    }

    @Test
    public void test_as_object() {
        assertNull(JsonUtils.asObject(null, TestObject.class));
        String json = "{\"text\":null,\"array\":null}";
        TestObject o = JsonUtils.asObject(json, TestObject.class);
        assertEquals(new TestObject(null, null), o);
        json = "{\"text\":\"abc\",\"array\":null}";
        o = JsonUtils.asObject(json, TestObject.class);
        assertEquals(new TestObject("abc", null), o);
        json = "{\"text\":\"def\",\"array\":[1,2,3]}";
        o = JsonUtils.asObject(json, TestObject.class);
        assertEquals(new TestObject("def", new int[]{1,2,3}), o);
    }

    @Test
    public void test_collection_as_json_string() {
        List<String> list = Arrays.asList("a", "b", "c");
        String json = JsonUtils.asJsonString(list);
        assertEquals("[\"a\",\"b\",\"c\"]", json);
        Map<String, String> map = new HashMap<>();
        map.put("k0", null);
        map.put("k1", "v1");
        json = JsonUtils.asJsonString(map);
        assertEquals("{\"k0\":null,\"k1\":\"v1\"}", json);
    }

    @Test
    public void test_collection_as_object() {
        List list = JsonUtils.asObject("[\"a\",\"b\",\"c\"]", List.class);
        assertEquals(Arrays.asList("a", "b", "c"), list);
        Map map = JsonUtils.asObject("{\"k0\":null,\"k1\":\"v1\"}", Map.class);
        Map<String, String> expected = new HashMap<>();
        expected.put("k0", null);
        expected.put("k1", "v1");
        assertEquals(expected, map);
    }

    @Test
    public void testReadValue() {
        String json = "{\"p0\":[1,2],\"p1\":{\"p11\":null,\"p12\":\"abc\"}}";
        assertNull(JsonUtils.readValue(json, null));
        assertEquals(JsonUtils.readValue(json, ""), "");
        assertEquals(JsonUtils.readValue(json, "p0"), "[1,2]");
        assertEquals(JsonUtils.readValue(json, "p1"), "{\"p11\":null,\"p12\":\"abc\"}");
        assertEquals(JsonUtils.readValue(json, "p2"), "");
        assertEquals(JsonUtils.readValue(json, "p0.p01"), "");
        assertEquals(JsonUtils.readValue(json, "p1.p11"), "null");
        assertEquals(JsonUtils.readValue(json, "p1.p12"), "abc");
        assertEquals(JsonUtils.readValue(json, "p1.p13"), "");
    }

    private static class TestObject {
        private String text;
        private int[] array;
        public TestObject() {}
        public TestObject(String text, int[] array) {
            this.text = text;
            this.array = array;
        }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestObject testObject = (TestObject) o;
            if (!Objects.equals(this.text, testObject.getText())) return false;
            return Arrays.equals(this.array, testObject.getArray());
        }
        @Override
        public int hashCode() {
            return this.text.hashCode() + 31 * Arrays.hashCode(this.array);
        }
    }
}
