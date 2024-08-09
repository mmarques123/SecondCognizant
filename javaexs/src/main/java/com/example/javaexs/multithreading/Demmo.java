package com.example.javaexs.multithreading;

public class Demmo {

    public static void main(String[] args) {
        FeeThread feeThread = new FeeThread("ft");
        feeThread.start(); //asking office boy to get water
       // feeThread.run();//it will runn on the main thread

        LibraryThread libraryThread = new LibraryThread();
        Thread libThread = new Thread(libraryThread,"libt");
        libThread.start();

    }
}
