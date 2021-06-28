package com.company;
/*
5.  Sort a given set of n integer elements using Merge Sort method and compute its time complexity. Run the
    program for varied values of n> 5000, and record the time taken to sort. Plot a graph of the time taken
    versus non graph sheet. The elements can be read from a file or can be generated using the random
    number generator. Demonstrate using Java how the divide and-conquer method works along with its time
    complexity analysis: worst case, average case and best case.
 */



import java.util.*;
import java.io.*;
class mergeSort{
    int[] inputArr;
    int[] tempMerArr;
    int cnt;
    int size;


    void process()throws IOException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of element sorted:(>5000)");
        size= sc.nextInt();
        inputArr=new int[size];
        tempMerArr = new int[size];
        randomnumbers(inputArr);
        cnt=0;
        doMergesort(0,inputArr.length-1);

        PrintWriter outA =new PrintWriter(new File("mrg_asort.txt"));
        for (int i:inputArr) outA.print(i+" ");
        outA.close();
        System.out.println();
        System.out.println("The time complexity is..."+cnt);
        sc.close();
    }
    void randomnumbers(int [] inputArr)throws IOException{
        Random rnd =new Random();
        int number,count=0;
        PrintWriter out= new PrintWriter(new File("Mrandom.txt"));
        while (count<size){
            number=rnd.nextInt(size)+1;
            inputArr[count]=number;
            out.print(number+" ");
            count++;
        }
        out.close();
        System.out.println("The total numbers generated : "+count);

    }
    void doMergesort(int lowerIndex,int higherIndex){
        if(lowerIndex<higherIndex){
            int middle=lowerIndex+(higherIndex-lowerIndex)/2;
            //below steps sorts the left side of the array

            doMergesort(lowerIndex,middle);
            //below steps sorts the right side of the array
            doMergesort(middle+1,higherIndex);
            //Now merge both sides
            mergeParts(lowerIndex,middle,higherIndex);
        }
    }
    void mergeParts(int lowerIndex,int middle,int higherIndex){
        for(int i=lowerIndex;i<=higherIndex;i++)tempMerArr[i]=inputArr[i];
        int i=  lowerIndex;
        int j=middle+1;
        int k=lowerIndex;
        while (i<=middle&&j<=higherIndex){
            if(tempMerArr[i]<=tempMerArr[j]){
                inputArr[k]=tempMerArr[i];
                i++;
                cnt++;
            }else{
                inputArr[k]=tempMerArr[j];
                j++;
                cnt++;
            }
            k++;
        }
        while (i<=middle){
            inputArr[k]=tempMerArr[i];
            k++;
            i++;
        }
        while (j<=higherIndex){
            inputArr[k]=tempMerArr[j];
            k++;
            j++;
        }
    }
}
public class pgm5 {
    public static void main(String[] args) throws IOException {
        mergeSort m=new mergeSort();//making object
        m.process();
    }
}
