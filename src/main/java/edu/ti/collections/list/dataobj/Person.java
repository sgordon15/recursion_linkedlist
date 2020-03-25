package edu.ti.collections.list.dataobj;

public class Person {
    private String fn;
    private String lastName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.fn = firstName;
    }

    @Override
    public String toString() { return "lastName is " + lastName + ", firstName is " + fn;}
}
