/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author user
 */
public class LambdaExample {


    private static int d = 0;

    //public void filterPersons(List<Person> persons, )

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereSystem.out.println("=== RunnableTest ===");

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Иван", "Иванов", 17, "ivanov@gmail.com"));
        personList.add(new Person("Иван", "Иванчук", 28, "ivanchuk@gmail.com"));
        personList.add(new Person("Александр", "Александров", 2, "aleksandrov@gmail.com"));
        personList.add(new Person("Алексей", "Алексеев", 20, "alekseev@gmail.com"));

        MyInterface2 o1 = (a) -> a.length();
        MyInterface3 o2 = (a) -> a.length();
        if (o1.equals(o2)) System.out.println("Equal objects");
        if (o1 == o2) System.out.println("Equal references");

        //if(((a) -> a.length()).equals((a) -> a.length())) System.out.println("Equal references");


        // Sort with Inner Class
        Collections.sort(personList, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getSurname().compareTo(p2.getSurname());
            }
        });

        System.out.println("=== Sorted Asc SurName ===");
        for (Person p : personList) {
            p.printInfo();
        }

        // Use Lambda instead

        // Print Asc
        System.out.println("=== Sorted Asc SurName ===");
        Collections.sort(personList,
                (Person p1, Person p2) -> p1.getSurname().compareTo(p2.getSurname())
        );

        for (Person p : personList) {
            p.printInfo();
        }

        // Print Desc
        System.out.println("=== Sorted Desc SurName ===");
        Collections.sort(personList, (p1, p2) -> p2.getSurname().compareTo(p1.getSurname()));

        for (Person p : personList) {
            p.printInfo();
        }

        //COLLECTIONS ITERATION
        System.out.println("=== COLLECTIONS ITERATION ===");
        for (Person p : personList) {
            p.printInfo();
        }


        Consumer<Person> cons1 = (Person p) -> p.printInfo();
        Consumer<Person> cons2 = (Person p) -> p.setAge(18);
        System.out.println("=== COLLECTIONS ITERATION WITH FOREACH ===");
        personList.forEach(cons1);
        //personList.forEach(cons2);

        personList.removeIf(
                (Person p) -> p.getAge() < 18
        );
        personList.forEach(cons1);


    }

}

class Person {
    private String name;
    private String surname;
    private int age;
    private String email;

    public Person(String name, String surname, int age, String email) {
        this.setAge(age);
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surame
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surame to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public void printInfo() {
        System.out.println(getName() + " " + getSurname() + ", age: " + getAge());
    }
}   
