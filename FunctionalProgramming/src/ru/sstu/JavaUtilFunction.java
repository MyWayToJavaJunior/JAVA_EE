/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu;

import java.util.function.*;
import java.util.stream.Stream;

/**
 *
 * @author user
 */
public class JavaUtilFunction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        Function func = new Function() {
            @Override
            public Object apply(Object t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        
        
        UnaryOperator unaryOperator = new UnaryOperator() {
            @Override
            public Object apply(Object t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        BinaryOperator binaryOperator = new BinaryOperator() {
            @Override
            public Object apply(Object t, Object u) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };         
        
    }
}
