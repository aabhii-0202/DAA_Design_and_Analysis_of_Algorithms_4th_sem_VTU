package com.company;
/*
Q. Write a java program to implement the stack using arrays. write push,pop and display
    methods to demonstrate its working
*/
import java.util.Scanner;
class  stack{
    Scanner sc=new Scanner(System.in);
    int[] s;
    int top;
    int size;
    stack(int n){
        size=n;
        s=new int[n];
        top =-1;
    }
    void push(){
        if(top==size-1) System.out.println("\nStack is full");
        else{
            System.out.println("Enter element to push:");
            int element =sc.nextInt();
            s[++top]=element;
        }
    }
    int pop(){
        if(top==-1) {
            System.out.println("\nStack in empty");
            return -1;
        }
        return s[top--];
    }
    void display(){
        if (top==-1)System.out.println("\nStack is empty");
        else {
            System.out.println("Elements in the stack are: ");
            for (int i = top; i >=0 ; i--) {
                System.out.println(s[i]);
            }
        }
    }



}
public class pgm01c {
    public static void main(String[] args) {
        System.out.println("Enter the size of the stack:");
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int choice ;
        stack stkob=new stack(n);
        do{
            System.out.println("Stack operations:");
            System.out.println("1.Push\n2.Pop\n3.Display\n4.EXIT");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice){
                case 1:stkob.push();break;
                case 2:int popped= stkob.pop();
                    if(popped!=-1) System.out.println("Popped element is : "+popped);
                    break;
                case 3:stkob.display();break;
                case 4:
                    System.out.println("Thanks ");break;
                default:
                    System.out.println("INVALID CHOICE try again");

            }
        }while (choice!=4);
    }
}
