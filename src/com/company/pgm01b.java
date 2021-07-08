package com.company;
import java.util.Scanner;
class stud{
    String usn ,name,branch ,phone;
    public void read(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter student's details");
        System.out.println("Enter USN");
        this.usn= sc.next();
        System.out.println("Enter Name");
        this.name= sc.next();
        System.out.println("Enter Branch");
        this.branch=sc.next();
        System.out.println("Enter Phone NUmber");
        this.phone=sc.next();

    }
    void disp(){
        System.out.println("\n Student details:");
        System.out.println("USN = "+this.usn);
        System.out.println("Name = "+this.name);
        System.out.println("Branch = "+this.branch);
        System.out.println("Phone = "+this.phone);
    }
}
public class pgm01b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter number of students:");
        int n = sc.nextInt();
        stud[] s = new stud[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Fill the details for student no:" + (i + 1));
            s[i] = new stud();
            s[i].read();

        }
        for (int i = 0; i < n; i++) s[i].disp();
    }
}