package ru.sstu.robo;


import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.*;


public class RoboCallTest01 {

    public static void main(String[] args) {

        List<Person> persons = Person.createShortList();


        RoboContactMethods robo = new RoboContactMethods();

        System.out.println("\n==== Test 01 ====");
        System.out.println("\n=== Calling all Drivers ===");
        robo.callDrivers(persons);

        System.out.println("\n=== Emailing all Draftees ===");
        robo.emailDraftees(persons);

        System.out.println("\n=== Mail all Pilots ===");
        robo.mailPilots(persons);

    }


}
