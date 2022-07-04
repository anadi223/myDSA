package com.demo.LightWeightBaby.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/burning-tree/1
public class MinimumTimeToBurnATreeVImp {
    public static void main(String[] args) {
        
    }
    //TC O(n) ((level order)) + O(n) (burn tree) -- > Overall TC O(N) || SC O(N)
    int minTime(Node root, int target){
        //algo:
        //step1 -- create node to parent mapping
        //step2 -- find target node
        //step3 -- burn the tree in min time

        int ans =0;
        HashMap<Node,Node> nodeToParent = new HashMap<>();
        Node targetNode = createParentMapping(root,target,nodeToParent); //createParentMapping will basically map the parent as well as //*find the given target node in the tree

        ans = burnTree(targetNode,nodeToParent);
        return ans;
    }

    private static int burnTree(Node root, HashMap<Node, Node> nodeToParent) {
        Map<Node,Boolean> visited = new HashMap<>(); // visited mapping jo ki har node ke baare me btayega ki visit hua ki nahi
        Queue<Node> q = new LinkedList<>();
        q.add(root); 
        visited.put(root, true); // visited mark kr rhe ki root node visit ho chuka
        int ans = 0;
        while(q.isEmpty() == false){
            int size = q.size(); 
            boolean flag = false; // ye check karega ki queue ka size bdha hai kya 
            for(int i=0;i<size;i++){
                //process neighbouring nodes
                Node front = q.poll();
                // ya toh left hoga ya toh right ya toh parent
                //left visit
                if(front.left != null && !visited.containsKey(front.left)){ // front ka left not null ho and //! visited nahi hona chahie phle se
                    q.add(front.left);
                    visited.put(front.left, true);
                    flag = true;
                }

                //right visit
                if(front.right != null && !visited.containsKey(front.right)){
                    q.add(front.right);
                    visited.put(front.right, true);
                    flag = true;
                }
                //parent visit
                if(nodeToParent.get(front)!=null && !visited.containsKey(nodeToParent.get(front))){
                    q.add(nodeToParent.get(front));
                    visited.put(nodeToParent.get(front), true); 
                    flag =true;       
                   }
            }
            if(flag == true){
                ans++;
            }
        }
        return ans;
    }

    private static Node createParentMapping(Node root, int target, HashMap<Node, Node> nodeToParent) {
        Node res = null;
        Queue<Node> q = new LinkedList<>(); // level order traversal krna
        q.add(root);
        nodeToParent.put(root, null); // root ka parent will always be null
        while(q.isEmpty() == false){
            Node front = q.poll();

            if(front.data == target){
                res = front;
            }
            if(front.left !=null){
                q.add(front.left);
                nodeToParent.put(front.left, front); // map kar rhe parent and child ko -- front ka left    
                //  1
                //  / \
                // 2  3   toh 2 ka parent 1 hai aise hi front hai abhi 1 toh front ka left is 2 toh hmko 2 ki mapping krni hai uske parent se which is 1
            }
            if(front.right !=null){
                q.add(front.right);
                nodeToParent.put(front.right, front);
            }
        }
        return res;
    }
}
