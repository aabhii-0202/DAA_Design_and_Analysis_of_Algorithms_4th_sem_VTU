package com.company;
import java.util.*;
public class pgm12_Hamiltonian_Cycle {
    static int MAX=25;
    static int[] vertex =new int[MAX];
    public static void main(String[] args){
        int i,j,v1,v2,edge,n;
        int[][] g =new int[MAX][MAX];
        System.out.println("\n\t program for Hamiltonian cycle");
        System.out.println("Enter the number of vertices of graph");
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                g[i][j]=0;
                vertex[i]=0;
            }
        }
        System.out.println("\nEnter the total number of edges:");
        edge=sc.nextInt();
        for(i=1;i<=edge;i++){
            System.out.println("Enter the edge:");
            v1=sc.nextInt();
            v2=sc.nextInt();
            g[v1][v2]=1;
            g[v2][v1]=1;
        }
        vertex[1]=1;
        System.out.println("Hamiltonian cycle");
        H_cycle(g,n,2);
    }
    public static void next_Vertex(int g[][],int n,int k){
        int j;
        while (true){
            vertex[k]=(vertex[k]+1)%(n+1);
            if(vertex[k]==0) return;
            if(g[vertex[k-1]][vertex[k]]!=0){
                for (j=1;j<=k-1;j++){
                    if(vertex[j]==vertex[k]) break;
                }
                if(j==k){
                    if((k<n)||((k==n)&&(g[vertex[n]][vertex[1]]!=0))) return;
                }
            }
        }
    }
    public  static void H_cycle(int[][] g, int n, int k){
        int i;
        while(true){
            next_Vertex(g,n,k);
            if(vertex[k]==0)return;
            if(k==n){
                System.out.println("\n");
                for (i=1;i<=n;i++) System.out.print(vertex[i]+"-->");
                System.out.println(" "+vertex[1]);
            }
            else H_cycle(g,n,k+1);
        }
    }


}
