package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/is-graph-bipartite/submissions/
//https://practice.geeksforgeeks.org/problems/bipartite-graph/1
public class BiPartiteGraphColoringUsingDFS {
    public static void main(String[] args) {

    }

    static boolean checkBipartite(int n, ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[n];
        Arrays.fill(color, -1); // color array liya usko -1  se fill kiya

        for(int i = 0;i<n ;i++){ //0 based indexing 
            if(color[i] == -1){
                if(!dfsCheck(adj,i,color)){ // agar ek bhi component ka dfs call false aaya toh simple return false
                    return false;
                }
            }
        }
        return true; // agar yhn tak aa gye mtlb saare eleemnts sahi se bhar gye
    }

    static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color){
        color[node] = 1; //filling the node as color 1
        for(int it : adj.get(node)){
            if(color[it] == -1){
                color[it]  =1 -color[node]; // adjacent node ko current node ke opposite color se fill kr rhe
                if(dfsCheck(adj, it, color) == false){ // dfs check call kar rhe
                    return false;
                }
            }else if(color[it] == color[node]){ // agar do adjacent node ka color same mtlb wo bipartite kaise hoga chacha
                return false;
            }
        }
        return true; // yhn tk aa gye mtlb sab sahi return kar do true
    }
}
