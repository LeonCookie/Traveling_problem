package com.company;
import java.util.Scanner;
class TSP{
    static int[][] two_dim_cost_matric = new int[1000][1000];
    static boolean[] visited_copy_array = new boolean[1000];//odwiedzony
    static int no_of_vertices, current_vertex, total_min_cost=0;//vertex= wierzchołek
    static String FirstMiasto="",  LastMiast="";

    static int max = 999, min = 1;

    public static void zamienNazwa(int i, int j){
        switch (i){//firstMiasto
            case 0:
                FirstMiasto="Gdynia";
                break;
            case 1:
                FirstMiasto="Gdansk";
                break;
            case 2:
                FirstMiasto="Krakow";
                break;
            case 3:
                FirstMiasto="Warszawa";
                break;
            case 4:
                FirstMiasto="Lodz";
                break;
            case 5:
                FirstMiasto="Poznan";
                break;
            case 6:
                FirstMiasto="SuchyDwor";
                break;
            case 7:
                FirstMiasto="Koleczkowo";
                break;
            case 8:
                FirstMiasto="Pierwoszyno";
                break;
            case 9:
                FirstMiasto="Kosakowo";
                break;
            case 10:
                FirstMiasto="Puck";
                break;
            case 11:
                FirstMiasto="Ruda";
                break;
            case 12:
                FirstMiasto="MałoCyce";
                break;
            case 13:
                FirstMiasto="Chojnice";
                break;
            case 14:
                FirstMiasto="Adowo";
                break;
            case 15:
                FirstMiasto="Stulejowo";
                break;

        }


        switch (j){//LastMiast
            case 0:
                LastMiast="Gdynia";
                break;
            case 1:
                LastMiast="Gdansk";
                break;
            case 2:
                LastMiast="Krakow";
                break;
            case 3:
                LastMiast="Warszawa";
                break;
            case 4:
                LastMiast="Lodz";
                break;
            case 5:
                LastMiast="Poznan";
                break;
            case 6:
                LastMiast="SuchyDwor";
                break;
            case 7:
                LastMiast="Koleczkowo";
                break;
            case 8:
                LastMiast="Pierwoszyno";
                break;
            case 9:
                LastMiast="Kosakowo";
                break;
            case 10:
                LastMiast="Puck";
                break;
            case 11:
                LastMiast="Ruda";
                break;
            case 12:
                LastMiast="MałoCyce";
                break;
            case 13:
                LastMiast="Chojnice";
                break;
            case 14:
                LastMiast="Adowo";
                break;
            case 15:
                LastMiast="Stulejowo";
                break;

        }
    }// zamiana int i && j na string
    public static void zamienSciezke(int obecny){
        switch (obecny){//firstMiasto
            case 1:
                FirstMiasto="Gdynia";
                break;
            case 2:
                FirstMiasto="Gdansk";
                break;
            case 3:
                FirstMiasto="Krakow";
                break;
            case 4:
                FirstMiasto="Warszawa";
                break;
            case 5:
                FirstMiasto="Lodz";
                break;
            case 6:
                FirstMiasto="Poznan";
                break;
            case 7:
                FirstMiasto="SuchyDwor";
                break;
            case 8:
                FirstMiasto="Koleczkowo";
                break;
            case 9:
                FirstMiasto="Pierwoszyno";
                break;
            case 10:
                FirstMiasto="Kosakowo";
                break;
            case 11:
                FirstMiasto="Puck";
                break;
            case 12:
                FirstMiasto="Ruda";
                break;
            case 13:
                FirstMiasto="MałoCyce";
                break;
            case 14:
                FirstMiasto="Chojnice";
                break;
            case 15:
                FirstMiasto="Adowo";
                break;
            case 16:
                FirstMiasto="Stulejowo";
                break;


    }}
    public static void inputs()
    {
        Scanner scobj = new Scanner(System.in);
        System.out.print("Podaj ilosc miast: ");//ilosc miast
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
                zamienNazwa(i,j);

                    //System.out.print(("Podaj kosz miedzy miastami: "+(FirstMiasto)+" --> "+(LastMiast)+": "));
                    two_dim_cost_matric[i][j]=(int)Math.floor(Math.random()*(max-min+1)+min);
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
                    cost_spent = two_dim_cost_matric[c_vertex-1][i];
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

        zamienSciezke((c_vertex));
        visited_copy_array[c_vertex-1]=true;
        System.out.print(FirstMiasto+"--->");
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
        shortest_distance (current_vertex);
        System.out.println();
        System.out.println("\nKoszt podruzy:"+total_min_cost);
    }
}