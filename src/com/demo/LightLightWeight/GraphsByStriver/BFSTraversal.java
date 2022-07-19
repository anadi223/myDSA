package com.demo.LightLightWeight.GraphsByStriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1



//NO matter Directed Undirected works for every graph
public class BFSTraversal {
    public static void main(String[] args) {
        //Take Input for adjacency list

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); //adjancency list bnane ka tareeka
        int V =5; //no of vertices / nodes
        for(int i=1;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);

        System.out.println(adj);
        ArrayList<Integer> ans = bfsOfGraph(V, adj);
        System.out.println(ans);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    // BFS TRAVERSAL KA CODE ITTA HAI BAS

    static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){ //V --> No of nodes

        ArrayList<Integer> bfsAnswer = new ArrayList<>(); // answer store krega
        boolean visited[]  = new boolean[V+1]; //visited array bnaya N+1 size ka

        for(int i=1;i<=V;i++){
            if(visited[i] == false){ // loop ke andar ka kaam tbhi hoga jab visited false hoga,, agar ye nhi lete toh ho skta kuch elements repeat kr skte answer me
                Queue<Integer> q = new LinkedList<>(); // Queue use kar rhe har node ke liye
                q.add(i); // jis node pe ho usko daal do // i hi hai us node ka data -- jab list bnate hai toh i reprsents the node
                visited[i] = true; // aur visited ko true mark kar do

                while(!q.isEmpty()){ // jab tak queue empty na ho tb tak process karo
                    Integer node = q.poll(); // node nikalo
                    bfsAnswer.add(node); // answer me dalo

                    for(Integer it : adj.get(node)){ // ab ye step kya krega,, adjacency matrix me se 1 ke against kaun sa adjacent matrix hai usko nikalega aur since wo list me rhta hai (mtlb for 1 node there can be multiple adjacent elements) toh iterate kar rhe 
                        if(visited[it] == false){ // agar visited false hai tb hi process karna
                            visited[it] = true;
                            q.add(it); //q me add kar do kyuki process kar rhe abhi while loop me sirf 1 node ke liye aur agar us node ka adjacent bhi mil gya toh usko bhi queue me daal do
                        }
                    }
                }


            }
        }
        return bfsAnswer;
    }
}
