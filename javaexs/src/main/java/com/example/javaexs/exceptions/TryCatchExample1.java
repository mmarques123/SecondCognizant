package com.example.javaexs.exceptions;

public class TryCatchExample1 {
  
    public static void main(String[] args) {

        try {
            int data=50/0;
        } catch (Exception e) {
        }

        System.out.println("rest of the code");  
          
    }  
      
}