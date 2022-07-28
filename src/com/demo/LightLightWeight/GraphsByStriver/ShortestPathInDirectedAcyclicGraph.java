package com.demo.LightLightWeight.GraphsByStriver;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {
       int n =6;
       ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<Pair>());
       } 

       adj.get(0).add(new Pair(1, 2));
       adj.get(0).add(new Pair(4, 1));
       adj.get(1).add(new Pair(2, 3));
       adj.get(2).add(new Pair(3, 6));
       adj.get(4).add(new Pair(2, 2));
       adj.get(5).add(new Pair(3, 1));
    }

    static void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int n){
        Stack<Integer> stack = new Stack<>(); // toposort store krne ke liye
        int dist[] = new int[n]; //distance array shortest distance ke liye
        boolean[] visited = new boolean[n]; //for topo sort
        Arrays.fill(visited, false);
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                topologicalSortUtil(i,visited,stack,adj); // toposort method call ye stack me saare elements topo sorted le aayeag
            }
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        while(!stack.empty()){
            int node = stack.pop();
            //to check that node has been reached before
            if(dist[node] != Integer.MAX_VALUE){ 
                for(Pair it : adj.get(node)){ //pair nikalo 
                    if(dist[node] + it.weight < dist[it.node]){ //distance dekh rhe node ki agar wo chot hai kya
                        dist[it.node] = dist[node] + it.weight;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(dist[i]);
        }


    }

    static void topologicalSortUtil(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj){
        visited[node] = true;
        for(Pair it : adj.get(node)){
            if(visited[it.node] == false){
                topologicalSortUtil(it.node, visited, stack, adj);
            }
        }
        stack.add(node);
    }
}


class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}