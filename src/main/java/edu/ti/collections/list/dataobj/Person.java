package edu.ti.collections.list.dataobj;

public class Person {
    private String firstName;
    private String lastName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() { return lastName + ", " + firstName;}
}
