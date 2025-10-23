package ua.opnu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[4];

        people[0] = new Person("Doe", "John", 45);
        people[1] = new Student("Doe", "Jane", 20, "241", "KB12345678");
        people[2] = new Lecturer("Kowalski", "Jan", 38, "Computer science", 21500.75);
        people[3] = new Student("Kowalski", "Jana", 19, "242", "KB87654321");

        System.out.println("Інформація про персон");

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}