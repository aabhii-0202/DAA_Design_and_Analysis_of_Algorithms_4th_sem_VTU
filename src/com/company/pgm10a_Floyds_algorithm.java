package com.company;
//Implement All Pairs Shortest Paths problem using Floyd's algorithm
import java.util.Scanner;
public class pgm10a_Floyds_algorithm {
    private int[][] dmat;
    private int n;
    public static final int INFINITY=999;

    public pgm10a_Floyds_algorithm(int n){
        dmat = new int [n+1][n+1];
        this.n=n;
    }

    public void floyd_compute(int[][] adjmat) {
        for (int i = 1; i <= n; i++) {
            if (n >= 0) System.arraycopy(adjmat[i], 1, dmat[i], 1, n);
        }
        for (int k = 1; k <= n; k++) {
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dmat[i][k]+dmat[k][j]<dmat[i][j]) dmat[i][j]=dmat[i][k]+dmat[k][j];
                }
            }
        }
        for(int i=1;i<=n;i++) System.out.print("\t"+i);
        System.out.println();
        for (int i=1;i<=n;i++){
            System.out.print(i+"\t");
            for (int j=1;j<=n;j++){
                System.out.print(dmat[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] adjmat;
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        n=sc.nextInt();
        adjmat=new int[n+1][n+1];
        System.out.println("Enter the Weighted Matrix for the graph");
        for (int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                adjmat[i][j]=sc.nextInt();
                if(i==j){
                    adjmat[i][j]=0;
                    continue;
                }
                if(adjmat[i][j]==0){
                    adjmat[i][j]=INFINITY;
                }
            }
        }
        System.out.println("The all pair Shortest Distance of the Graph is:");
        pgm10a_Floyds_algorithm floyd =new pgm10a_Floyds_algorithm(n);
        floyd.floyd_compute(adjmat);
        sc.close();

    }

}
