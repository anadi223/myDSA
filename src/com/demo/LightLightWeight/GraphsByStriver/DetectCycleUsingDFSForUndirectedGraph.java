package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class DetectCycleUsingDFSForUndirectedGraph {
    public static void main(String[] args) {
        
    }

    static boolean checkForCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V+1];
        for(int i = 1;i<=V;i++){
            if(visited[i] == false){
                if(checkDFSCycle(i,-1,visited,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean checkDFSCycle(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int it : adj.get(node)){
            if(visited[it] == false){
                if(checkDFSCycle(it, node, visited, adj) == true){//recursion call
                    return true; //yhn kyo true likha,, bhaiya recursive call me agar maan lo neeche call krte krte someone gave a true return so we will not check further if one element foound a cycle which means there is a cycle in graph
                }else if(it != parent){
                    return true; // ye wo case hai jab ek current node adjacent node ko visit krne ja rha ho aur wo already visited ho aur wo parent na ho tab bhi wo cycle hoga see notes
                }
            }
        }
        return false;
    }
}
