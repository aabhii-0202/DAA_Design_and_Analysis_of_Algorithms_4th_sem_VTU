package com.company;
/*
3a.    Write a Java program to read two integers a and b. Compute a/b and print,, when b is not 0.Raise an exception when
       b is equal to 0.
 */
import java.util.Scanner;
public class pgm03a {
    public static void main(String[] args) {
        int a ,b;
        float res;
        try{
            Scanner sc= new Scanner(System.in);
            System.out.println("Input Dividend(a) ");
            a=sc.nextInt();
            System.out.println("Input Dividend(b)");
            b=sc.nextInt();
            res =a/b;
            System.out.println("Quotient is : "+res);
            sc.close();

        }catch (ArithmeticException e){
            System.out.println("Divided by zero error "+e);
        }
    }
}
