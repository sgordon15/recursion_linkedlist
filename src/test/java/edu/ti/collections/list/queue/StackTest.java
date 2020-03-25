package edu.ti.collections.list.queue;

import edu.ti.collections.list.dataobj.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void testNewStackIsEmpty() {
        Stack<Double> stack = new Stack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testAddOneIsNotEmptyHasSizeOne() {
        Stack<Integer> stack =  new Stack<>();
        Integer student = new Integer(4);
        stack.push(student);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }
    
    @Test
    public void testSizeUpAndDown() {
        Stack<String> stringStack = new Stack<>();
        assertEquals(0, stringStack.size());
        stringStack.push("Foo");
        assertEquals(1, stringStack.size());
        stringStack.push("Bar");
        assertEquals(2, stringStack.size());
        stringStack.push("Baz");
        assertEquals(3, stringStack.size());
        stringStack.pop();
        assertEquals(2, stringStack.size());
        stringStack.pop();
        assertEquals(1, stringStack.size());
        stringStack.pop();
        assertEquals(0, stringStack.size());

        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testPopIsPush() {
        Stack<Person> stack = new Stack<>();
        Person alice = new Person("Smith", "Alice");
        Person bob = new Person("Smith", "Bob");
        Person carl = new Person("Jones", "Carl");
        Person doris = new Person("Jones", "Doris");
        stack.push(alice);
        stack.push(bob);
        stack.push(carl);
        stack.push(doris);

        Person personPopped = stack.pop();
        assertEquals(doris, personPopped);

        personPopped = stack.pop();
        assertEquals(carl, personPopped);

        personPopped = stack.pop();
        assertEquals(bob, personPopped);

        personPopped = stack.pop();
        assertEquals(alice, personPopped);

        assertTrue(stack.isEmpty());
    }
}