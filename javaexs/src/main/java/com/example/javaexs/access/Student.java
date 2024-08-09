package com.example.javaexs.access;

public class Student {

    private   String penPocket;

   public String myHandGetPen(){
       int a = 10;
       Integer aInteger = a; //boxing --aInteger is a box
       a = aInteger;  //unboxing
       int b = 20;
       if(a==b){}
       return this.penPocket;

   }

   public  void putPenPocket(String pen){
       penPocket = pen;
   }

   private void myOtherHand(){
       penPocket = "somepen";
   }
}
