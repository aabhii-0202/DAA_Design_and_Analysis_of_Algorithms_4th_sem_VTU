package com.company;
/*
9. Minimum cost spanning tree of a given connected undirected graph using Prism's algorithm.
 */
import java.util.Scanner;
class MST {
    private static int Vertices;
    int[][] graph;

    public void ReadFromConsole(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of nodes");
        Vertices= sc.nextInt();

        graph = new int[Vertices][Vertices];
        int v=Integer.MAX_VALUE;
        System.out.println("Enter Cost Matrix");
        for(int i=0;i<Vertices;i++)
            for(int j=0;j<Vertices;j++){
                graph[i][j]=sc.nextInt();
                if(graph[i][j]==0)graph[i][j]=v;
            }
        sc.close();
    }

    void printMST(int[] parent, int n){
        int sum=0;
        System.out.println("Edge Weight");
        for (int i=1;i<Vertices;i++){
            sum+=graph[i][parent[i]];
            System.out.println(parent[i]+"-"+i+" "+graph[i][parent[i]]);
        }
        System.out.println("Weight of Spanning tree is "+sum);
    }
    int minKey(int[] key, int[] mstSet){
        int min=Integer.MAX_VALUE,minindex=-1;
        for(int v=0;v<Vertices;v++){
            if(mstSet[v]==0&&key[v]<min) {
                min = key[v];
                minindex = v;
            }
        }
        return minindex;
    }
    void prismMST(){
        int[] mstSet =new int[Vertices];
        int[] parent =new int[Vertices];
        int[] key = new int[Vertices];
        for (int i=0;i<Vertices;i++){
            key[i]=Integer.MAX_VALUE;
            mstSet[i]=0;
        }
        key[0]=0;
        parent[0]=-1;
        for (int count =0;count<Vertices-1;count++){
            int u=minKey(key,mstSet);
            mstSet[u]=1;
            for(int v=0;v<Vertices;v++)
                if (graph[u][v]!=0&&mstSet[v]==0&&graph[u][v]<key[v]){
                    parent[v]=u;
                    key[v]=graph[u][v];
                }
        }
        printMST(parent,Vertices);
    }
}
public class pgm09_Prisms_algorithm {
    public static void main(String[] args) {
        MST c =new MST();
        c.ReadFromConsole();;
        c.prismMST();
    }

}



















