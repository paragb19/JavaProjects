package com.parag.evenoddmultithread;

public class TaskOddEven implements Runnable{
    private int max;
    private Printer printer;
    private boolean isEvenNumber;

    public TaskOddEven(int max, Printer printer, boolean isEvenNumber) {
        this.max = max;
        this.printer = printer;
        this.isEvenNumber = isEvenNumber;
    }
    @Override
    public void run() {
        int number= isEvenNumber? 2:1;
        while (number<=max){
            if (isEvenNumber){
                printer.printEven(number);

            }
            else{
                printer.printOdd(number);
            }
            number=number+2;
        }

    }
}
