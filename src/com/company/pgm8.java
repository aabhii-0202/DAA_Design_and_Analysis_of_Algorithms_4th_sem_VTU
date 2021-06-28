package com.company;
/*
 8.     Find Minimum Cost Spanning Tree of a given connected undirected graph using Kruskal's
        algorithm. Use Union-Find algorithms in your program.
 */
import java.util.*;
class compute {
    private static int nodes;
    int[][] graph;
    int[] parent;

    public void readfromconsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes ");
        nodes = sc.nextInt();
        graph = new int[nodes + 2][nodes + 2];
        parent = new int[nodes + 2];
        int max = Integer.MAX_VALUE;
        System.out.println("Enter cost matrix");
        for (int i = 1; i <=nodes; i++) {
            parent[i] = 0;
            for (int j = 1; j <=nodes; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 0) graph[i][j] = max;
            }
        }
        sc.close();
    }

    public void Kruskal() {
        int i, j, a = 0, b = 0, u = 0, v = 0, min, mincost = 0, ne = 1;
        System.out.println("The edges of Minimum Cost Spanning Tree are :");
        while (ne < nodes) {
            for (i = 1, min = Integer.MAX_VALUE; i <= nodes; i++)
                for (j = 1; j <= nodes; j++)
                    if (graph[i][j] < min) {
                        min = graph[i][j];
                        a = u = i;
                        b = v = j;
                    }
            u = find(u);
            v = find(v);
            if (uni(u, v) == 1) {
                System.out.println(ne++ + "edge(" + a + "," + b + ")=" + min);
                mincost += min;
            }
            graph[a][b] = graph[b][a] = Integer.MAX_VALUE;
        }
        System.out.println("Minimum cost =" + mincost);
    }

    public int find(int i) {
        while (parent[i] != 0) i = parent[i];
        return i;
    }

    public int uni(int i, int j) {
        if (i != j) {
            parent[j] = i;
            return 1;
        }
        return 0;
    }
}

public class pgm8 {
    public static void main(String[] args) {
        compute c=new compute();
        c.readfromconsole();
        c.Kruskal();
    }
}
/*
Example Out Put
Enter number of nodes
6
Enter cost matrix
0 3 0 0 6 5
3 0 1 0 0 4
0 1 0 6 0 4
0 0 6 0 8 5
6 0 0 8 0 2
5 4 4 5 2 0
The edges of Minimum Cost Spanning Tree are
1 edge(2,3) = 1
2 edge(5,6) = 2
3 edge(1,2) = 3
4 edge(2,6) = 4
5 edge(4,6) = 5
Minimum cost = 15


 */
