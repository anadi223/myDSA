package com.demo.LightWeightBaby.BinaryTree;




//https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1/#
public class KthAncestor {
    static int trackK; //! refernce bhejne me help krega  // int node kyu nhi paas kar rhe as a static ref -- >> dhyn se dekho node ki value change nhi ho rhi  */
    public static void main(String[] args) {
        
    }
    int kthAncestor(Node root, int k , int node){// k mtlb ancestor node mtlb kaun si node
        trackK = k; //* k ki value recursive call me bnaye rkhne ke liye ye static reference bhej rhe hm */
        Node ans = solve(root,node);
        if(ans == null || ans.data == node){ // ans.data == node wo case jab root hi node hai aur k ki value bahot jyada ho see in notes
            return -1;
        }
        else {
            return ans.data;
        }
    }
    static Node solve(Node root ,int node){
        if(root == null) return null; //base case

        if(root.data == node)return root; // node dudh rhe 

        Node leftAns = solve(root.left, node); // left call
        Node rightAns = solve(root.right, node); // rigth call

        if(leftAns !=null && rightAns == null){ // jab left ans not null mtlb hmko wo node mil gyi
            trackK--;
            if(trackK<=0){
                trackK = Integer.MAX_VALUE; // max value tak leke jaao jaise kya hoga ki jo hm return kr rhe root that will be locked kyuki kbhi k 0 nhi hoga is case me
                return root; //root value locked 
            }
            return leftAns; // left ans ko return krwa do
        }
        else if(leftAns ==null && rightAns != null){ // same for right
            trackK--;
            if(trackK<=0){
                trackK = Integer.MAX_VALUE;
                return root;
            }
            return rightAns;
        }
        else{
        return null;
        }
    } 
}
