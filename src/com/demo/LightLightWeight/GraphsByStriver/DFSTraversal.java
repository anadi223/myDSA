package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class DFSTraversal {
    public static void main(String[] args) {
        
    }
    //TC & SC O(n)
    static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> storeDFS  = new ArrayList<>();
        boolean visited[] = new boolean[V+1]; //visited array bnao
        for(int i=1;i<=V;i++){ // for loop har node ke liye
            if(visited[i] == false){ // loop ke andr ka kaam tbhi hoga jab visited false hoga
                dfs(i,visited,adj,storeDFS);
            }
        }
        return storeDFS;
    }

    static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDFS){
        storeDFS.add(node); // ek node hai already usko answer me daalo
        visited[node] = true; // us node ke against viisted mark karo jaise aur iteration me naa aaye ye element
        for(int it : adj.get(node)){ // ek adjacent node dudho (adjacent node list bhi ho skti)
            if(visited[it] == false){
                dfs(it, visited, adj, storeDFS); // recursive call ho rhi adjacent list ke liye
            }
        }
    }
}
 