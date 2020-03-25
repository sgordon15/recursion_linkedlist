package edu.ti.collections.list.queue;

import edu.ti.collections.list.dataobj.Person;
import org.junit.Ignore;
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

        assertEquals(4, stack.size());

        Person personPopped = stack.pop();
        assertEquals(doris, personPopped);
        assertEquals(3, stack.size());

        personPopped = stack.pop();
        assertEquals(carl, personPopped);
        assertEquals(2, stack.size());

        personPopped = stack.pop();
        assertEquals(bob, personPopped);
        assertEquals(1, stack.size());

        personPopped = stack.pop();
        assertEquals(alice, personPopped);
        assertEquals(0, stack.size());

        assertTrue(stack.isEmpty());
    }
}