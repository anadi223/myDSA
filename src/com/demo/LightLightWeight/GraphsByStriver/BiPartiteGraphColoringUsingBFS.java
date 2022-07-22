package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/submissions/
//https://practice.geeksforgeeks.org/problems/bipartite-graph/1
public class BiPartiteGraphColoringUsingBFS {
    public static void main(String[] args) {
    }

    static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n){
        int color[] = new int[n]; //declared a color array
        Arrays.fill(color, -1); // initialize it with -1
        for(int i =0;i<n;i++){ // check with 0 based indexing -- if 1 based indexing is given change the for loop
            if(color[i] == -1){ //this color is somewhat like visited array
                if(!bfsCheck(adj,i,color)){
                    return false; // it returns a false 
                }
            }
        }
        return true; // yhn pe aa gya mtlb har color sahi se fill hogya hai aaur loop ke bahar aa gya hai
    }

    static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1; //you can take 0 or 1 absoultely your choice
        while(!q.isEmpty()){
            int nde = q.poll();
            for(int it : adj.get(nde)){
                if(color[it] == -1){
                    color[it] = 1-color[nde]; // what you doinn --> coloring the adjacent node with exactly opposite 1- kyu bhaiya upr 1 se start kiye hai 
                    q.add(it);
                }else if(color[it] == color[nde]){ // agar abhi adjacent node ka color mere current node se same hogya mltb guru it is not  a bipartite graph
                    return false;
                }
            }
        }
        return true;
    }
}
