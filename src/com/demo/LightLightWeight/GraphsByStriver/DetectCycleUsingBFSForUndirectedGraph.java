package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class DetectCycleUsingBFSForUndirectedGraph {
    public static void main(String[] args) {
    }

    static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean visited[] =  new boolean[V+1];
        Arrays.fill(visited, false);
        for(int i=1;i<=V;i++){
            if(visited[i] == false){
                if(checkCycleBFS(adj,i,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean checkCycleBFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1)); // initial node ke liye uska parent toh null hi rhega na
        vis[s] = true;

        while(!q.isEmpty()){
            int node = q.peek().first; // curr element
            int parent = q.peek().second; // curr element ka peechla wala element 
            q.remove();

            for(int it : adj.get(node)){
                if(vis[it] == false){
                    q.add(new Node(it, node)); // ab Node ke liye curr element adjacent element hoga aur prev node hoga jo phle nikala hai
                    vis[it] = true;
                }
                else if(parent != it){
                    return true; // check kar rhe ki it(adjacent element) agar parent ke equal nahi aaya mtlb kisi ne phle node visit kar rkhi hai check notes for better understanding
                }
            }
        }
        return false;
    }
}

class Node{
    int first; //NOde
    int second; // parent/prev node
    Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}