package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
public class ShortestPathInUndirectedGraphDijsktraAlgo {
    public static void main(String[] args) {
        
    }

    static void shortestPath(int source, ArrayList<ArrayList<Node>> adj, int n){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<Node>(n,new Node()); //min heap || n -->node1 new Node(0 -- > node2 comparator me jab pass hoga)
        pq.add(new Node(source,0)); //phla element

        while(pq.size()>0){
            Node node = pq.poll();

            for(Node it: adj.get(node.node)){
                if(dist[node.node]+it.weight < dist[it.node]){ // distance check karte raho
                    dist[it.node] = dist[node.node] + it.weight;
                    pq.add(new Node(it.node,dist[it.node])); //adjacent elements aur distance ka pair
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(dist[i]+" ");
        }
    }

}


class Node implements Comparator<Node>{
    int node;
    int weight;

    Node(int node, int weight){
        this.weight = weight;
        this.node = node;
    }
    Node(){}
    @Override
    public int compare(Node node1, Node node2){
        if(node1.weight < node2.weight){
            return -1;
        }

        if(node1.weight > node2.weight){
            return 1;
        }
        return 0;
    }
}