package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;



//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1/#

//!SIMILAR TO TOP VIEW BS ISME CONDITION NA CHECK KARNA  
import java.util.*;
public class BottomView {
    public static void main(String[] args) {
        
    }

    static ArrayList<Integer> topView(Node root,Pair pair){
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
        Map<Integer,Integer> topNode = new TreeMap<>(); //One to One mapping of (Horizontal distance and node ka data)
        Queue<Pair> q = new LinkedList<Pair>(); //Pair me rhega node aur horizontal distance
        q.add(new Pair(root,0)); // starting me horizontal distance is 0
        while(q.isEmpty() == false){
            Pair temp = q.peek();
            q.poll();
            Node front = temp.node; // pair se node nikalo
            int horizontalDistance = temp.horizontalDistance; //pair se horizontal distance nikalo 
             
                topNode.put(horizontalDistance, front.data); //* Just Put dont check any condition for putting  */
            

            if(front.left != null){ // queue me add karne ke liye
                q.add(new Pair(front.left, horizontalDistance-1)); //Horizontal distance -1 mtlb number line me dekho   -1 0 1 toh agar 0 ke left jaoge toh -1 hoga na decrement
                        }
            if(front.right != null){
                q.add(new Pair(front.right, horizontalDistance+1));//Horizontal distance +1 mtlb number line me dekho   -1 0 1 toh agar 0 ke right jaoge toh +1 hoga na incremenet
            }
        }

        for(int i : topNode.keySet()){ // dost saari keys ko nikalo  keys will be the horizontal distance
            ans.add(topNode.get(i)); // phir un keys ke against jo values hai wo nikal lo values will be the nodes
        }

        return ans;
    }
}


  //Helper class for Pair just like c++
  class Pair{
    Node node;
    int horizontalDistance;
    Pair(Node node, int horizontalDistance){
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
