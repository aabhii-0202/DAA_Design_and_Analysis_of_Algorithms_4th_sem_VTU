package com.company;
/*
2b. Write a java class Customer to store their name and date of birth. The date of birth format should be in dd/mm/yyyy.
    Write methods to read customer data as <name, dob> and display as name date month and year <name,dd,mm,yyyy>using
    string tokenizer class considering delimiter character as "/".
 */
import java.util.Scanner;
import java.util.StringTokenizer;
public class pgm2b {
    private String name,dob;
    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name: ");
        name=sc.nextLine();
        System.out.println("Enter the date of birth in format dd/mm/yyyy");
        dob=sc.nextLine();
        sc.close();
    }
    public void disp(){
        System.out.println("Name and");
        StringTokenizer st=new StringTokenizer(dob,"/");
        System.out.print("Date of birth is:"+"<"+name+",");
        int n=st.countTokens();
        while(st.hasMoreTokens()){
            if(n>1) System.out.print(st.nextToken("/")+",");
            else System.out.print(st.nextToken("/")+">");
            n--;
        }
    }

    public static void main(String[] args) {
        pgm2b st=new pgm2b();
        st.input();
        st.disp();
    }
}