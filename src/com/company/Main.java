package com.company;
import java.util.Scanner;
class TSP{
    static int[][] two_dim_cost_matric = new int[1000][1000];
    static boolean[] visited_copy_array = new boolean[1000];//odwiedzony
    static int no_of_vertices, current_vertex, total_min_cost=0;//vertex= wierzchołek
    public static void inputs()
    {
        Scanner scobj = new Scanner(System.in);
        System.out.print("Podaj ilosc miast");//ilosc miast
        no_of_vertices = scobj.nextInt();
        System.out.print("Podaj poczatkowy wierzcholek: ");
        current_vertex = scobj.nextInt();
        for (int i = 0;i<no_of_vertices; i++)
        {
            for(int j=0;j<no_of_vertices;j++)
            {
                if(i==j)// wynik tych samych miast
                {
                    two_dim_cost_matric[i][j]=0;
                }
                else
                {
                    System.out.print(("Podaj kosz miedzy miastami"+(i+1)+"-->"+(j+1)+": "));
                    two_dim_cost_matric[i][j]=scobj.nextInt();
                }
            }
        }
        System.out.print("\n");
        System.out.print("\n");
        for(int i=0;i<no_of_vertices;i++){
            for(int j=0;j<no_of_vertices;j++){
                System.out.print(two_dim_cost_matric[i][j]+"    ");
            }
            System.out.println();
        }
    }
    public  static  int next_visit(int c_vertex){
        int MIN = Integer.MAX_VALUE;
        int cost_spent =0, next_vertex = Integer.MAX_VALUE;
        for(int i=0;i<no_of_vertices;i++)
        {
            if(two_dim_cost_matric[c_vertex-1][i]!=0 &&!visited_copy_array[i])
            {
                if(two_dim_cost_matric[c_vertex][i]+two_dim_cost_matric[i][c_vertex]<MIN)
                {
                    MIN = two_dim_cost_matric[c_vertex-1][i]+two_dim_cost_matric[i][c_vertex-1];
                    cost_spent = two_dim_cost_matric[c_vertex][i];
                    next_vertex = i;
                }
            }
        }
        if(MIN != Integer.MAX_VALUE)
        {
            total_min_cost+=cost_spent;
        }
        return next_vertex+1;
    }
    public static void shortest_distance(int c_vertex){
        visited_copy_array[c_vertex-1]=true;
        System.out.print(c_vertex+"--->");
        int nxt_visit = next_visit(c_vertex);
        if(nxt_visit==Integer.MAX_VALUE+1){
            System.out.print(current_vertex);
            total_min_cost+=two_dim_cost_matric[c_vertex-1][current_vertex-1];
            return;
        }
        shortest_distance(nxt_visit);
    }
    public static void main(String[]args){
        inputs();
        System.out.print("\nSciezka: ");
        shortest_distance(current_vertex);
        System.out.println();
        System.out.println("\nKoszt podruzy:"+total_min_cost);
    }
}