package com.company;
/*
6a. Implement in Java, the 0/1 Knapsack problem using (a) Dynamic Programming method (b) Greedy
    method. Implement in Java, the 0/1 Knapsack problem using (a) Dynamic Programming
    Knapsack Problem statement:
    Given n objects, their weights wi , profits pi, where i=1 to n , and the capacity of the knapsack W, the
    objective is fill these objects in to the knapsack such that the maximum profit is earned and the weight of the
    objects chosen shouldn’t exceed the capacity of the knapsack
 */
import java.util.*;
public class pgm6a {
    static int max(int a,int b){
        return (a>b)?a:b;
    }
    static int knapSack(int c,int[] wt,int[] val,int n){
        int i,j;
        int[][] k=new int[n+1][c+1];
        for(i=0;i<=n;i++){
            for(j=0;j<=c;j++){
                if(i==0||j==0) k[i][j]=0;
                else if(wt[i-1]<=j) k[i][j]=max(val[i-1]+k[i-1][j-wt[i-1]],k[i-1][j]);
                else k[i][j]=k[i-1][j];
            }
        }
        System.out.println("The Knapscak table is");
        for(i=0;i<=n;i++) {
            for (j = 0; j <= c; j++)
                System.out.print(k[i][j] + "  ");
            System.out.println();
        }
        System.out.print("Items Considered: ");
        i=n;j=c;
        while(i>0&&j>0){
            if(k[i][j]!=k[i-1][j]){
                System.out.println(i+" ");
                j-=wt[i-1];
            }
            i-=1;
        }
        return k[n][c];

}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of objects : ");
        int n=sc.nextInt();
        System.out.println("Enter objects weight:");
        int[] wt=new int[n];
        for(int i=0;i<n;i++)wt[i]=sc.nextInt();

        System.out.println("Enter objects profits :");
        int[] val=new int[n];
        for(int i=0;i<n;i++)val[i]=sc.nextInt();
        System.out.println("Enter max capacity: ");
        int c=sc.nextInt();
        System.out.println("The max value that can be put in the knapsack if capasity "+c+" is "+knapSack(c,wt,val,n));
        sc.close();

    }

}
