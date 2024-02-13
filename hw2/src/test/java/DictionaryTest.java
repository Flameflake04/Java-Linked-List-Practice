// Name: Duc Tran, UIN: 679876782
// Class: CS 342
// DictionaryTest.java: This file tests all the case for Linked List Dictionary implementation
// The file testing including case for zero element, many elements, and single element
// System: Window 11, Intellij Idea, Java 21
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class DictionaryTest {
    public Dictionary<Integer,String> newDictionary() {
        return new LinkedListDictionary<Integer,String>();
    }
    @Test
    void testEmptyFind(){
        Dictionary<Integer,String> dict = newDictionary();
        assertNull(dict.find(3),"Incorrect empty find behavior");
    }
    @Test
    void testSingleFind(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        assertEquals("three",dict.find(3),"Incorrect single element find behavior");
    }
    @Test
    void testMultipleFind(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(8,"eight");
        dict.insert(10,"ten");
        assertEquals("eight",dict.find(8),"Incorrect multiple elements find behavior");
        assertEquals("ten",dict.find(10),"Incorrect multiple elements find behavior");
        assertEquals("three",dict.find(3),"Incorrect multiple elements find behavior");
    }

    @Test
    void testZeroElementDelete(){
        Dictionary<Integer,String> dict = newDictionary();
        assertFalse(dict.delete(5),"Incorrect 0 elements delete behavior");
    }
    @Test
    void testSingleDelete(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        assertTrue(dict.delete(3));
        assertNull(dict.find(3),"Incorrect single element delete behavior");
    }
    @Test
    void testMultipleDelete(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(5,"five");
        dict.insert(7,"seven");
        dict.insert(9,"nine");
        dict.insert(11,"eleven");
        dict.insert(13,"thirteen");

        assertEquals(6, dict.getSize());
        assertTrue(dict.delete(3));
        assertNull(dict.find(3),"Incorrect multiple elements delete behavior");
        assertEquals(5, dict.getSize());
        assertTrue(dict.delete(7));
        assertNull(dict.find(7),"Incorrect multiple elements delete behavior");
        assertEquals(4, dict.getSize());
        assertTrue(dict.delete(13));
        assertNull(dict.find(13),"Incorrect multiple elements delete behavior");
        assertEquals(3, dict.getSize());

        dict.insert(1, "one");
        assertTrue(dict.delete(1));
        assertNull(dict.find(1),"Incorrect multiple elements delete behavior");
        assertEquals(3, dict.getSize());

    }
    @Test
    void testIteratorEmpty(){
        Dictionary<Integer,String> dict = newDictionary();
        Iterator<Integer> iter = dict.iterator();
        assertFalse(iter.hasNext(), "Incorrect emptied linked list hasNext Iterator behavior");
        assertNull(iter.next(), "Incorrect emptied linked list hasNext Iterator behavior");
    }
    @Test
    void testIteratorSingle(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        Iterator<Integer> iter = dict.iterator();
        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(3,iter.next(), "Incorrect single element iterator behavior");
        assertFalse(iter.hasNext(), "Incorrect emptied hasNext Iterator behavior");
    }
    @Test
    void testIteratorMultiple(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(6,"six");
        dict.insert(10,"ten");
        dict.insert(11,"eleven");

        dict.delete(10);
        dict.insert(12,"twelve");

        Iterator<Integer> iter = dict.iterator();
        assertTrue(iter.hasNext(), "Incorrect multiple elements hasNext Iterator behavior");
        assertEquals(3,iter.next(), "Incorrect multiple elements iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple elements hasNext Iterator behavior");
        assertEquals(6,iter.next(), "Incorrect multiple elements element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple elements hasNext Iterator behavior");
        assertEquals(11,iter.next(), "Incorrect multiple elements iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple elements hasNext Iterator behavior");
        assertEquals(12,iter.next(), "Incorrect multiple elements iterator behavior");

        assertFalse(iter.hasNext(), "Incorrect multiple elements hasNext Iterator behavior");

    }
    @Test
    void testGetSizeZeroSingleMany(){
        Dictionary<Integer,String> dict = newDictionary();
        assertEquals(0, dict.getSize(), "Incorrect size behaviour");
        dict.insert(1, "one");
        assertEquals(1, dict.getSize(), "Incorrect size behaviour");
        dict.insert(2, "two");
        assertEquals(2, dict.getSize(), "Incorrect size behaviour");
        dict.delete(1);
        assertEquals(1, dict.getSize(), "Incorrect size behaviour");
        dict.delete(2);
        assertEquals(0, dict.getSize(), "Incorrect size behaviour");
    }
}





