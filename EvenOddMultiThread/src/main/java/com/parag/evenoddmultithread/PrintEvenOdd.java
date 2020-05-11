package com.parag.evenoddmultithread;

public class PrintEvenOdd {
    public static void main(String[] args){

        Printer printer= new Printer();

        Thread t1= new Thread(new TaskOddEven(10,printer,false),"ODD");
        Thread t2= new Thread(new TaskOddEven(10,printer,true),"EVEN");

        t1.start();
        t2.start();

    }

}
