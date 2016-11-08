/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Employee {
    
    List<Employee> friends = new ArrayList<>();
    String name;

    public Employee(String name) {
        this.name = name;
    }
}
