package com.company;
/*
Program 4
Sort a given set of n integer elements using Quick Sort method and compute its time complexity. Run the
program for varied values of n> 5000 and record the time taken to sort. Plot a graph of the time taken
versus non graph sheet. The elements can be read from a file or can be generated using the random
number generator. Demonstrate using Java how the divide-and-conquer method works along with its time
complexity analysis: worst case, average case and best case.
 */
import java.io.*;
import java.util.*;
class Qsort {
    int[] array;
    int length;
    int cnt;
    int size;
    String flag;

    void proccess() throws IOException {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        flag = "best";
        cnt = 0;
        int[] inputArr = new int[size];
        getRandomNum(inputArr);
        sc.close();
        int[] temparr = new int[size];
        //so now we will begin to sort
        System.arraycopy(inputArr, 0, temparr, 0, inputArr.length); //copies array
        sort(inputArr);
        System.out.println();
        System.out.println("The time complexity for best case is "+cnt);
        PrintWriter outA=new PrintWriter(new File("q_asort.txt"));
        for (int i:inputArr) {
            outA.print(i+" ");
        }outA.close();
        cnt =0;
        flag ="worst";
        sort(inputArr);
        System.out.println();
        System.out.println("The time complexity for worst case is "+cnt);
        cnt=0;
        flag="average";
        sort(temparr);
        System.out.println();
        PrintWriter outb=new PrintWriter(new File("qb_sort.txt"));
        for (int i:inputArr) {
            outb.print(i);
            outb.print(" ");
        }
        outb.close();
        System.out.println("The time complexity for average case is "+cnt);

    }

    //first we will make a random number filler for our array
    void getRandomNum(int[] inputArr) throws IOException {
        Random rnd = new Random();
        int number, count = 0;
        PrintWriter out = new PrintWriter(new File("Qrandom.txt"));//this will make a text file in which we will store our Random numbers
        while (count < size) {
            number = rnd.nextInt(size) + 1;
            out.print(number + " ");
            inputArr[count++] = number;
        }
        out.close();
        System.out.println("The total numbers generated: " + count);
    }

    void sort(int[] inputarr) {
        int pivot = 0;
        if (inputarr == null || inputarr.length == 0) return;
        this.array=inputarr;
        length=inputarr.length;
        if(flag.equals("best") || flag.equals("average")){   //flag=="average" and flag.equals("average") are same
            pivot=array[length/2];
            quicksort(0,length-1,pivot);
        }else if(flag.equals("worst")){
            pivot=array[0];
            quicksort(0,length-1,pivot);
        }
    }
    void quicksort(int lowerIndex,int higherIndex,int pivot){
        int i=lowerIndex;
        int j=higherIndex;
        switch (flag){
            case "best":
            case "average":
                pivot=array[lowerIndex+(higherIndex-lowerIndex)/2];
                break;
            case"worst":
                pivot=array[lowerIndex];
                break;
        }
        while (i<=j){
            while (array[i]<pivot){
                i++;
                cnt++;
            }while (array[j]>pivot){
                j--;
                cnt++;
            }if(i<=j){
                swap(i,j);
                i++;
                j--;
            }
        }
        if(lowerIndex<j)quicksort(lowerIndex,j,pivot);
        if (i<higherIndex)quicksort(i+1,higherIndex,pivot);
    }
    void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
public class pgm04_QuickSort {
    public static void main(String[] args)throws IOException {
        System.out.println("Enter the number of elements to be sorted:(>5000)");
        Qsort qs=new Qsort();// making object
        qs.proccess();
    }
}
