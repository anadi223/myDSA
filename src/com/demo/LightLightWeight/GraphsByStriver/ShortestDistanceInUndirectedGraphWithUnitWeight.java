package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInUndirectedGraphWithUnitWeight {
    public static void main(String[] args) {
        
    }
    //TC O(N+E) SC O(N) + O(N) //koi question dikha nahi direct 
    static void shortestPath(ArrayList<ArrayList<Integer>> adj, int n, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, 1000000000); //val bda sa number hai assuming infinity

        Queue<Integer> q = new LinkedList<>();
        q.add(src); // src ko push kar do

        while(!q.isEmpty()){
            int node = q.poll();

            for(int it : adj.get(node)){
                if(dist[node] + 1 < dist[it]){ //agar adjacent node ka distance current node +1( why +1 --> unit distance hai na is liye)
                    dist[it] = dist[node] + 1; // agar chota hai toh bhaiya adjacent node ka distance update kar do
                    q.add(it);//and push that adjacent node to queue
                }
            }
        }

        for(int x : dist){
            System.out.print(x+" ");
        }
    }
}
