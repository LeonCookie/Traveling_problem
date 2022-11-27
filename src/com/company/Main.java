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
        System.out.print("Podaj poczatkowy wierzcholek");
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
        System.out.print("\n Koszt matrycy");

    }
}