package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSpanningTreePrimsAlgorithmImplementation {
    public static void main(String[] args) {
        int n=5;
        ArrayList<ArrayList<Helper>> adj = new ArrayList<ArrayList<Helper>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Helper>());
        }

        adj.get(0).add(new Helper(1, 2));
		adj.get(1).add(new Helper(0, 2));
		
		adj.get(1).add(new Helper(2, 3));
		adj.get(2).add(new Helper(1, 3));
		
		adj.get(0).add(new Helper(3, 6));
		adj.get(3).add(new Helper(0, 6));
		
		adj.get(1).add(new Helper(3, 8));
		adj.get(3).add(new Helper(1, 8));
		
		adj.get(1).add(new Helper(4, 5));
		adj.get(4).add(new Helper(1, 5));
		
		adj.get(2).add(new Helper(4, 7));
		adj.get(4).add(new Helper(2, 7));

        primsAlgorithmBruteForce(adj, n);
        //O/P
        // 0-1
        // 1-2
        // 0-3
        // 1-4
    }
    //TC O(N) + O(N)*O(N) ~ O(N ^2) BRUTE FORCE IMPLEMENTATION -->>> ALWAYS GIVE BRUTE FORCE FIRST 
    static void primsAlgorithmBruteForce(ArrayList<ArrayList<Helper>> adj, int n){
        //take key, parent and MST array
        int key[] = new int[n]; // key me hm weight rkh rhe
        int parent[] = new int[n]; //parent me mst ke elements ke connection / parent rkh rhe
        boolean mst[] = new boolean[n]; // mst ka part hai ya nahi wo rkh rhe
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(mst, false);
        key[0] = 0; // initialization every element with infinity apart from 0th element

        for(int i=0;i<n-1;i++){ //why n-1 because a spanning tree has N nodes and n-1 edges so n-1 tak iterate krenge

            int mini = Integer.MAX_VALUE, u = 0;
            for(int v=0;v<n;v++){ // finding the minimum value from the key array like we did in algo
                if(mst[v] == false && key[v] < mini){ // wo element mst ka part nahi hona chhaiye aur key array ka element minimum hona chahiye
                    mini = key[v];
                    u = v;
                }
            }

            mst[u] = true; // jo element minimum nikala hai usko mst ka part bna do simple
            //next step is to find the adjacent node and check if the element can be a part of mst uske liye key wale array ko update karna hai with minimum values
            for(Helper it: adj.get(u)){
                if(mst[it.node] == false && it.weight < key[it.node]){ //if not a part of mst ,, if the current weight is smaller than what it is in the key update the parent and key
                    parent[it.node] = u;
                    key[it.node] = it.weight; //key ko update kar rhe
                }
            }
        }

        for(int i =1;i<n;i++){ // for 1 to N why not 0 because 1st element ka koi parent nhi hota
            System.out.println(parent[i] + "-" + i);
        }
    }
}

class Helper{ // to store node and their weights
    int node;
    int weight;
    Helper(){}
    Helper(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
