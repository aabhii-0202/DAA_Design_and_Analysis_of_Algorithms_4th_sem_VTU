package com.company;
/*
3b. Write a Java program that implements a multi-thread application that has three threads. First thread
generates a random integer for every 1 second; second thread computes the square of the number and
prints; third thread will print the value of cube of the numbers.
 */
import java.util.Random;
public class pgm03b {
    static int randomInt;
    public static void main(String[] args) {
        System.out.println("For 10 Random numbers");
        Mythread t=new Mythread();
        t.start();

    }
}
//thread 1
class  Mythread extends Thread{
    public  void run(){
        int i=0;
        try{
            //generating 10 random numbers
            while(i++<10){
                Random rnd = new Random();
                pgm03b.randomInt=rnd.nextInt(100);
                System.out.println((i+1)+" Random integer is "+ pgm03b.randomInt);
                new myThread2().start();
                new mythread3().start();
                Thread.sleep(1000);

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
//thread 2
class myThread2 extends Thread{
    public void run(){
        System.out.println("Square of "+ pgm03b.randomInt+" is "+ pgm03b.randomInt* pgm03b.randomInt);
    }
}
//thread 3
class mythread3 extends Thread{
    public void run(){
        System.out.println("Cube of "+ pgm03b.randomInt+" is "+ pgm03b.randomInt* pgm03b.randomInt* pgm03b.randomInt);
    }
}


