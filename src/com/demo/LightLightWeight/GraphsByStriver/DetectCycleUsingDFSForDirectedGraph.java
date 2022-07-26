package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DetectCycleUsingDFSForDirectedGraph {
    public static void main(String[] args) {
        
    }

    static boolean isCyclicDirectedGraph(int n, ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[n]; //visited wala array
        int[] dfsVisited = new int[n]; // current dfs calls me jo element visit ho rhe uska track rkhne ke liye

        for(int i=0;i<n;i++){
            if(visited[i] == 0){ //mtlb node visited nhi hai
                if(checkCycle(i,adj,visited,dfsVisited) ==true){
                    return true; //agar ek bhi call true return kiya mtlb usme cycle hai
                }
            }
        }
        return false;
    }

    static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dfsVisited){
        visited[node] = 1; // us node ko visited kar do dono array me
        dfsVisited[node] = 1; // us node ko visited kar do dono array me

        for(int it : adj.get(node)){ //adjacent nodes ko check karo
            if(visited[it] == 0){ // agar wo node visit na hui
                if(checkCycle(it, adj, visited, dfsVisited) == true){  //recursion call
                    return true;
                }
            }
                else if(dfsVisited[it] == 1){ //iska mtlb jab visited aur dfs visited dono 1 hai toh usme cycle hai that means ,, for dfsvisited = 1 that means us current traversal me wo node visit ho chuki 
                    return true;
                }
            }
        dfsVisited[node] = 0;//recursion call se wapis aate time dfsVisited ko 0 kar do why beacuse cycle nhi mila toh back to original state for other traversal 
        return false; //us traversal ke liye false return karo
    }
}
