package com.company;
/*6.    Implement in Java, the fractional Knapsack problem using  Greedy method.
        Knapsack Problem statement:
        Given n objects, their weights wi , profits pi, where i=1 to n , and the capacity of the knapsack W, the
        objective is fill these objects in to the knapsack such that the maximum profit is earned and the weight of the
        objects chosen shouldn’t exceed the capacity of the knapsack

 */
import java.util.*;
class pgm06bKnapsack_Greedy {
    double[] weight;
    double[] benefit;
    double[] ratio;
    double w;

    pgm06bKnapsack_Greedy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of objects ");
        int nitems = sc.nextInt();
        weight = new double[nitems];
        ratio = new double[nitems];
        benefit = new double[nitems];
        System.out.println("Enter objects weight ");
        for (int i = 0; i < nitems; i++) weight[i] = sc.nextDouble();
        System.out.println("Enter objects profit ");
        for (int i = 0; i < nitems; i++) benefit[i] = sc.nextDouble();

        for (int i = 0; i < nitems; i++) ratio[i] = benefit[i] / weight[i];

        System.out.println("Enter the capacity of the knapsack ");
        w = sc.nextDouble();
    }

    int getnext() {
        double highest = 0;
        int index = -1;
        for (int i = 0; i < benefit.length; i++) {
            if (ratio[i] > highest) {
                highest = ratio[i];
                index = i;
            }
        }
        return index;
    }

    void fill() {
        double cw = 0;
        double cb = 0;
        System.out.println("\nObjects considered:");
        while (cw < w) {
            int item = getnext();
            if (item == -1) break;
            System.out.println((item + 1) + " ");
            if (cw + weight[item] <= w) {
                cw += weight[item];
                cb += benefit[item];
                ratio[item] = 0;
            } else {
                cb += (ratio[item] * (w - cw));
                cw += (w - cw);
                break;
            }
        }
        System.out.println("The optimal solution i.e. max benifit = " + cb);
    }

    public static void main(String[] args) {
        pgm06bKnapsack_Greedy k=new pgm06bKnapsack_Greedy();
        k.fill();
    }
}
