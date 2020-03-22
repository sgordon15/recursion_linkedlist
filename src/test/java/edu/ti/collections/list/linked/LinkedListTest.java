package edu.ti.collections.list.linked;

import edu.ti.collections.list.dataobj.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testNewEmptyListIsEmpty() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testNewNotEmptyListIsNotEmpty() {
        Integer i14 = 14;
        LinkedList<Integer> linkedList = new LinkedList<>(i14);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testInsertTwoObjectsGivesCorrectSize() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList<Integer> linkedList = new LinkedList<>(i12);
        linkedList.insert(j37);
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testAppendTwoObjectsGivesCorrectSize() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList<Integer> linkedList = new LinkedList<>(i12);
        linkedList.append(j37);
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testGetTooBigReturnsNull() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList<Integer> linkedList = new LinkedList<>(i12);
        linkedList.append(j37);
        assertNull(linkedList.get(2));
    }

    @Test
    public void testInsertTwoObjectsCorrectOrder() {
        Double i12 = new Double(12);
        Double j37 = new Double(37);
        LinkedList<Double> linkedList = new LinkedList<>(i12);
        linkedList.insert(j37);
        Double first = linkedList.get(0);
        assertEquals(j37, first);
        Double second = linkedList.get(1);
        assertEquals(i12, second);
    }

    @Test
    public void testAppendTwoObjectsCorrectOrder() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList<Integer> linkedList = new LinkedList<>(i12);
        linkedList.append(j37);
        Integer first = linkedList.get(0);
        assertEquals(i12, first);
        Integer second = linkedList.get(1);
        assertEquals(j37, second);
    }

    @Test
    public void testDeleteCorrectElementByPositionFirst() {
        Person bob = new Person("Jones", "Bob");
        Person jimmy = new Person("Dean", "Jimmy");
        Person george = new Person("Jungle", "George");
        LinkedList<Person> linkedList = new LinkedList<>(bob);
        linkedList.insert(jimmy);
        linkedList.insert(george);
        Person actualPerson = linkedList.remove(0);
        assertEquals(george, actualPerson);
        assertEquals(2, linkedList.size());
        assertEquals(jimmy, linkedList.get(0));
        assertEquals(bob, linkedList.get(1));
    }

    @Test
    public void testDeleteCorrectElementByPositionSecond() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        Integer k34 = new Integer(34);
        LinkedList<Integer> linkedList = new LinkedList<>(i12);
        linkedList.insert(j37);
        linkedList.insert(k34);
        Integer actualInteger = linkedList.remove(1);
        assertEquals(j37, actualInteger);
        assertEquals(2, linkedList.size());
        assertEquals(k34, linkedList.get(0));
    }

    @Test
    public void testDeleteCorrectElementByPositionLast() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        Integer k34 = new Integer(34);
        LinkedList<Integer> linkedList = new LinkedList<>(i12);
        linkedList.insert(j37);
        linkedList.insert(k34);
        Integer actualInteger = linkedList.remove(2);
        assertEquals(i12, actualInteger);
        assertEquals(2, linkedList.size());
        assertEquals(k34, linkedList.get(0));
    }

    @Test
    public void testDeleteCorrectElementByObject() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList<Integer> linkedList = new LinkedList<>(i12);
        linkedList.insert(j37);
        Integer actualInteger = linkedList.remove(i12);
        assertEquals(i12, actualInteger);
        assertEquals(1, linkedList.size());
        assertEquals(j37, linkedList.get(0));
    }
}