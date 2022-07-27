package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSortUsingBFSKahnsAlgorithm {
    public static void main(String[] args) {
        
    }

    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj){
        int[] topo = new int[N]; // answer store krwane ke liye
        int[] indegree = new int[N]; //indegree store krwa rhe

        for(int i=0;i<N;i++){
            for(int it: adj.get(i)){
                indegree[it]++; // indegree har element ka store krwane ke liye
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i] == 0){ // jis element ka indegree 0 hai usko queue me daal do uske liye loop
                q.add(i);
            }
        }

        int ind = 0; // index topo array track ke liye
        while(!q.isEmpty()){ 
            int node = q.poll();
            topo[ind++] = node;
            for(int it: adj.get(node)){
                indegree[it]--; //har adjacent node ka indegree decrease karo
                if(indegree[it] == 0){
                    q.add(it); // jab indegree 0 ho jaaye phatt se queeu me add kr do
                }
            }
        }
        return topo; // jab queue empty ho jayegi toh topo me saare elements aa jayenege topo sorted
    }
}
