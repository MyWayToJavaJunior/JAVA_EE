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
class Boss {
    String name;
    List<Employee> employees = new ArrayList<>();

    public Boss(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Начальник по имени " + name;
    }
}