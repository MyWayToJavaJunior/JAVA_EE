package ru.sstu.robo;


import java.util.List;
import java.util.function.Predicate;


public class RoboCallTest05 {
  
  public static void main(String[] args){ 

    List<Person> pl = Person.createShortList();
    RoboContactLambdaFull robo = new RoboContactLambdaFull();
    
    // Predicates
    Predicate<Person> allDrivers = p -> p.getAge() >= 16;
    Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
    Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;
    
    
    PersonPrinter emailPrinter = p -> System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
    PersonPrinter mailPrinter = p -> System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
    PersonPrinter phonePrinter = p -> System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
    
    System.out.println("\n==== Test 04 ====");
    System.out.println("\n=== Calling all Drivers with email===");
    robo.printContacts(pl, allDrivers , emailPrinter);  
    
    System.out.println("\n=== Calling all Drivers with address===");
    robo.printContacts(pl, allDrivers , mailPrinter);
    
    System.out.println("\n=== Calling all Pilots with address===");
    robo.printContacts(pl, allPilots , mailPrinter);
    
  }
}
