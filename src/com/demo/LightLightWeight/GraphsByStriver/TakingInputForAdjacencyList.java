package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;

//It removes the problem of storing data in adjaceny matrix (( 10^5 ke upr elements 2d array me store nhji ho skte))
public class TakingInputForAdjacencyList {
    public static void main(String[] args) {
        int n=3,m=3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>()); // outer list bna rhe hai jo indexes ko map karega u v ke lie
        }
            //edge 1--2
            adj.get(1).add(2); //for u 1 add 2 
            adj.get(2).add(1); // for u 2 add 1 since undirected graph

            //edge 2--3
            adj.get(2).add(3);
            adj.get(3).add(2);

            for(int i=1;i<n;i++){
                for(int j=0;j<adj.get(i).size();j++){
                    System.out.print(adj.get(i).get(j)+" "); //suppose outer hai index 3 pe hai and for inner list elements are 2,4,5,6 toh inner list ka size pe iterate krna pdega na ((EXAmple in notes))
                }
                System.out.println();
            }
        }
    }
