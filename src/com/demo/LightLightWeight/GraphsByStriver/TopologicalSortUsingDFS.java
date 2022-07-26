package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSortUsingDFS {
    public static void main(String[] args) {
        
    }

    static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> s = new Stack<>(); //Stack bnao jo answer store krega
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){ // agar visited na ho
                dfsFindTopoSort(i,adj,visited,s); // to dfs call kar do
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!s.empty()){
            ans.add(s.pop());
        }
        return ans;
    }

    static void dfsFindTopoSort(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> s){
        visited[node] = true; // visited ko true karo us node ke liye
        for(int it : adj.get(node)){
            if(!visited[it]){
            dfsFindTopoSort(it, adj, visited, s); // recursion call
        }
    }
    s.push(node); // recursion call over hone se phle stack me push kar do simple
    }
}
