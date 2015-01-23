import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * DoublyLinkedList Test Cases
 * @author Jonathan Jemson
 * @author Kush Mansingh
 */
public class DoublyLinkedListTest {
    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<String>();
    }

    public void add(){
    	list.add(0, "Hello");
        list.add(1, "World");
        list.add(1, "Entire");
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testAdd1() {
        add();
        assertEquals("Hello", list.getHead().getData());
        assertEquals("Entire", list.get(1));
        assertEquals("World", list.get(2));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testAdd2(){
    	assertFalse(list.add(-1, "Something"));
    	assertFalse(list.add(100, "else"));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testAdd3(){
    	assertFalse(list.add(0, null));
    }

    @Test (timeout = 200)
    //@Worth (points = 1)
    public void testClear1() {
        add();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testClear2() {
        add();
        list.clear();
        assertNull(list.getHead());
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testContains1() {
        add();
        assertTrue(list.contains("Hello"));
        assertTrue(list.contains("Entire"));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testContains2() {
        add();
        list.remove("Entire");
        assertTrue(list.contains("Hello"));
        assertFalse(list.contains("Entire"));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testContains3() {
        add();
        assertFalse(list.contains("Thing"));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testContains4(){
    	add();
    	assertFalse(list.contains(null));
    }

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testGet1() {
        add();
        assertEquals("Hello", list.get(0));
        assertEquals("Entire", list.get(1));
        assertEquals("World", list.get(2));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 1)
    public void testGet2() {
        add();
        assertNull(list.get(-1));
        assertNull(list.get(100));
    }
    

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testIndexOf1() {
        add();
        assertEquals(0, list.indexOf("Hello"));
        assertEquals(2, list.indexOf("World"));
        assertEquals(1, list.indexOf("Entire"));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 1)
    public void testIndexOf2() {
        add();
        assertEquals(-1, list.indexOf("Something"));
        assertEquals(-1,list.indexOf(null));
    }
    
    

    @Test (timeout = 200)
    //@Worth (points = 1)
    public void testIsEmpty1() {
        assertTrue(list.isEmpty());
        add();
        assertFalse(list.isEmpty());
    }
    
    @Test (timeout = 200)
    //@Worth (points = 1)
    public void testIsEmpty2(){
    	add();
    	list.clear();
    	assertTrue(list.isEmpty());
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testIsEmpty3(){
    	add();
    	list.remove(0);
    	list.remove(0);
    	list.remove(0);
    	assertTrue(list.isEmpty());
    }

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testRemove1() {
        add();
        assertEquals("Hello", list.remove("Hello"));
        assertEquals("Entire", list.remove("Entire"));
    }

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testRemove2() {
    	add();
    	assertNull(list.remove(null));
    	assertNull(list.remove("something"));
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testRemove3() {
        add();
        assertEquals("Hello", list.remove(0));
        assertEquals("Entire", list.remove(0));
    }

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testRemove4() {
    	add();
    	assertNull(list.remove(null));
    	assertNull(list.remove(-1));
    }
    

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testReplace() {
        add();
        assertEquals("Hello", list.replace(0, "Goodbye"));
        assertEquals("Goodbye", list.getHead().getData());
        assertEquals("World", list.replace(2, "Grandma"));
        assertEquals("Grandma", list.get(2));
        assertEquals("Entire", list.replace(1, "My"));
        assertEquals("My", list.get(1));
    }

    @Test (timeout = 200)
    //@Worth (points = 1)
    public void testSize1() {
        assertEquals(0, list.size());
       
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testSize2(){
    	 add();
         assertEquals(3, list.size());
         list.clear();
         assertEquals(0, list.size());
    }

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testReverseList() {
        add();
        list.reverseList();
        assertEquals("World", list.getHead().getData());
        assertEquals("Entire", list.get(1));
    }
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testIterator() {
        add();
        int i = 0;
        for (String s : list) {
            if (i == 0)
                assertEquals("Hello", s);
            if (i == 1)
                assertEquals("Entire", s);
            if (i == 2)
                assertEquals("World", s);
            i++;
        }
    }
    
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testIterator2() {
        add();
        int i = 0;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (i == 0)
                assertEquals("Hello", s);
            if (i == 1)
                assertEquals("Entire", s);
            if (i == 2)
                assertEquals("World", s);
            i++;
        }
    }

    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testIterator3() {
        for (String s : list) {
            fail("List should be empty.");
        }
    }
    @Test (timeout = 200)
    //@Worth (points = 2)
    public void testIterator4() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            fail("List is empty.");
        }
    }

}