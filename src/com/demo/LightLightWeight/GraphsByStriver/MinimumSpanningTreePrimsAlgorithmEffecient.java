package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrimsAlgorithmEffecient {
    public static void main(String[] args) {
        
    }
    // TCO(n+logn)  logn hai priority queue ke liye 
    static void primsAlgorithmOptimizedApproach(ArrayList<ArrayList<Help>> adj, int n){
        int key[] = new int[n]; // key me hm weight rkh rhe
        int parent[] = new int[n]; //parent me mst ke elements ke connection / parent rkh rhe
        boolean mst[] = new boolean[n]; // mst ka part hai ya nahi wo rkh rhe
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(mst, false);
        key[0] = 0; // initialization every element with infinity apart from 0th element

        PriorityQueue<Help> pq = new PriorityQueue<Help>(n,new Help()); //min heap bnaya
        pq.add(new Help(0,key[0])); // we insert 0 as well as weight as priority queueu weight ke according sort kar rha

        for(int i=0;i<n-1;i++){ //
            int u = pq.poll().node; // jo minimum value nikal rhe the hm for loop se wo hmne priority queue ka use krke nikal liya hence loop hta diya extra

            mst[u] = true; // jo element minimum nikala hai usko mst ka part bna do simple
//next step is to find the adjacent node and check if the element can be a part of mst uske liye key wale array ko update karna hai with minimum values
            for(Help it: adj.get(u)){
                if(mst[it.node] == false && it.weight < key[it.node]){ //if not a part of mst ,, if the current weight is smaller than what it is in the key update the parent and key
                    parent[it.node] = u;
                    key[it.node] = it.weight;
                    pq.add(new Help(it.node,key[it.node])); //aur priority queue me daal do
                }
            }
        }

        for(int i =1;i<n;i++){
            System.out.println(parent[i] +"-" +i);
        }
    }
}



class Help implements Comparator<Help>{
    int node;
    int weight;
    Help(){}
    Help(int node, int weight){
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compare(Help node1, Help node2) {
        if (node1.weight < node2.weight) // weight ke according sort kr rha
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }

}