package edu.ti.collections.list.queue;

import edu.ti.collections.list.dataobj.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testNewQueueIsEmpty() {
        Queue<Double> queue = new Queue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testAddOneIsNotEmptyHasSizeOne() {
        Queue<Integer> queue =  new Queue<>();
        Integer student = new Integer(4);
        queue.enqueue(student);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    public void testPopIsPush() {
        Queue<Person> queue = new Queue<>();
        Person alice = new Person("Smith", "Alice");
        Person bob = new Person("Smith", "Bob");
        Person carl = new Person("Jones", "Carl");
        Person doris = new Person("Jones", "Doris");
        queue.enqueue(alice);
        queue.enqueue(bob);
        queue.enqueue(carl);
        queue.enqueue(doris);

        assertEquals(4, queue.size());

        Person personDequeued = queue.dequeue();
        assertEquals(alice, personDequeued);
        assertEquals(3, queue.size());

        personDequeued = queue.dequeue();
        assertEquals(bob, personDequeued);
        assertEquals(2, queue.size());

        personDequeued = queue.dequeue();
        assertEquals(carl, personDequeued);
        assertEquals(1, queue.size());

        personDequeued = queue.dequeue();
        assertEquals(doris, personDequeued);
        assertEquals(0, queue.size());

        assertTrue(queue.isEmpty());
    }
}