package com.example.javaexs;

import com.example.javaexs.access.Student;
import com.example.javaexs.interfaces.Biticino;
import com.example.javaexs.interfaces.GEAppliances;
import com.example.javaexs.interfaces.ISwitchBoardListener;

public class MyClass {

    public static void main(String[] args) {
       // System.out.println("hello world");
        ISwitchBoardListener isbl = new Biticino();

       Student myStudent = new Student();
       /* myStudent.penPocket = "reynolds";*/
        myStudent.putPenPocket("sheaffer");


        System.out.println(myStudent.myHandGetPen());

                //GEAppliances();  ///wiring
       //me/caller clicking the switches
        isbl.switchOne();
        isbl.switchTwo();
        isbl.switchThree();
    }
}