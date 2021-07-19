package com.company;
/*
7.  From a given vertex in a weighted connected graph, find shortest paths to other vertices using Dijkstra's
    algorithm. Write the program in Java.
 */
import java.util.*;
class pgm07_Dijkstra_algorithm {
    public int[] distance = new int[10];
    public int[][] cost =new int [10][10];
    public void compute(int n,int src){
        int[] flag =new int[n+1];
        int i,minpos=1,u,c,minimum;
        for(i=0;i<=n;i++) {
            flag[i] = 0;
            this.distance[i] = this.cost[src][i];
        }
        c=2;
        while(c<=n){
            minimum=99;
            for(u=1;u<=n;u++){
                if (this.distance[u]<minimum&&flag[u]!=1){
                    minimum=this.distance[i];
                    minpos=u;
                }
            }
            flag[minpos]=1;
            c++;
            for(u=1;u<=n;u++){
                if(this.distance[minpos]+this.cost[minpos][u]<this.distance[u]&&flag[u]!=1)
                    this.distance[u]=this.distance[minpos]+this.cost[minpos][u];
            }
        }
    }
    public static void main(String[] args) {
        int node,source,i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of n=Nodes \n");
        node=sc.nextInt();
        pgm07_Dijkstra_algorithm d=new pgm07_Dijkstra_algorithm();
        System.out.println("Enter the cost matrix weights: ");
        for( i=1;i<=node;i++)
            for(j=1;j<=node;j++){
                d.cost[i][j]=sc.nextInt();
                if(d.cost[i][j]==0)
                    d.cost[i][j]=999;
            }
        System.out.println("Enter the source vertex:");
        source=sc.nextInt();
        d.compute(node,source);
        System.out.println("The Shortest Path from Source \t"+source+"\t to all other vertices are : ");
        for(i=1;i<=node;i++)
            if(i!=source) System.out.println("Source : "+source+"\t destination : "+i+"\t MinCosst is : "+d.distance[i]);
        }
}

/*
Sample input and output:
Enter the Number of n=Nodes

6
Enter the cost matrix weights:
0 2 4 0 0 0
0 0 1 4 2 0
0 0 0 0 5 0
0 0 0 0 0 2
0 0 0 3 0 2
0 0 0 0 0 0
Enter the source vertex:
1
The Shortest Path from Source 	1	 to all other vertices are :
Source : 1	 destination : 2	 MinCosst is : 2
Source : 1	 destination : 3	 MinCosst is : 3
Source : 1	 destination : 4	 MinCosst is : 6
Source : 1	 destination : 5	 MinCosst is : 4
Source : 1	 destination : 6	 MinCosst is : 6

 */









