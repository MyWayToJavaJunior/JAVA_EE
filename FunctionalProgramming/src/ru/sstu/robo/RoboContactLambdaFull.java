package ru.sstu.robo;


import java.util.List;
import java.util.function.Predicate;


public class RoboContactLambdaFull {
  public void printContacts(List<Person> pl, Predicate<Person> pred, PersonPrinter printer){
    for(Person p:pl){
      if (pred.test(p)){
        printer.print(p);
      }
    }
  }  
}
