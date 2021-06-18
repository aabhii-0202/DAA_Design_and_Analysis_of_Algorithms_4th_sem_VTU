package com.company;
/*
Q 2a. Design a super class Staff with details as Staff Id, Names, Phone, Salary. Extend this class by writing
    three subclass namesly Teaching(domain, publications),Technical skills and Contract period.
    Write a java program to read and display atleast 3 staff of all three categories.
*/
import java.util.Scanner;
class staff{
    String name ,phone;
    int sid, sal;
    Scanner scan= new Scanner(System.in);

    void read(){
        System.out.println("Staff Id:");
        sid=scan.nextInt();
        System.out.println("Name:");
        name= scan.next();
        System.out.println("Phone:");
        phone=scan.next();
        System.out.println("Salary:");
        sal=scan.nextInt();
        scan.nextLine();
        }
    void display(){
        System.out.println("Staff Id: "+sid);
        System.out.println("Name: "+name);
        System.out.println("Phone: "+phone);
        System.out.println("Salary: "+sal);
    }
}

class teacher extends staff{
    String domain;
    int publication;
    @Override
    void read() {
        super.read();
        System.out.println("Enter the Domain Expertise:");
        domain=scan.nextLine();
        System.out.println("Enter numbers of publications:");
        publication= scan.nextInt();
    }
    void display(){
        super.display();
        System.out.println("Domain Expert is : "+domain);
        System.out.println("No. of Publications : "+publication);
        }
}
class technical extends staff{
    String[] skills;

    void read(){
        super.read();
        System.out.println("Skills (seperated by commas)");
        skills=scan.nextLine().split(",");
    }
    void display(){
        super.display();
        System.out.println("Skills :");
        for (int i = 0; i < skills.length ; i++) System.out.println(skills[i]+ " ");
    }
}
class contract extends staff{
    int period;
    void read(){
        super.read();
        System.out.println("Enter the Contract period: ");
        period=scan.nextInt();
    }
    void display(){
        super.display();
        System.out.println("Contract Period: "+period);
    }
}
public class pgm2a {
    public static void main(String[] args) {
        teacher[] teach =new teacher[3];
        technical[] tech =new technical[3];
        contract[] cont =new contract[3];
        System.out.println("Enter the staff details" );
        for (int i=0;i<3;i++){
            System.out.println("\nEnter the details of teaching staff#"+(i+1));
            teach[i]=new teacher();
            teach[i].read();
        }
        for (int i=0;i<3;i++){
            System.out.println("\n Enter the details of technical staff#"+(i+1));
            tech[i]=new technical();
            tech[i].read();
        }
        for (int i=0;i<3;i++){
            System.out.println("\n Enter the details of contract staff#"+(i+1));
            cont[i]=new contract();
            cont[i].read();
        }
        System.out.println("The details of all three categories are");
        for (int i = 0; i <3 ; i++) {
            System.out.println("Details of teaching staff#"+(i+1));
            teach[i].display();
        }
        for (int i = 0; i <3 ; i++) {
            System.out.println("Details of technical staff#"+(i+1));
            tech[i].display();
        }
        for (int i = 0; i <3 ; i++) {
            System.out.println("Details of contract staff#"+(i+1));
            cont[i].display();
        }

    }
}