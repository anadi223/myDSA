package com.demo.LightWeightBaby.BinarySearchTree;

import java.util.ArrayList;

//https://www.codingninjas.com/codestudio/problems/h_920474?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar 
//although above link is not getting correct result so thats why I have made a main method here
public class MergeTwoBSTIMP {
    public static void main(String[] args) {
        /* Creating following tree as First balanced BST
                100
                / \
                50 300
                / \
               20 70
        */
         
        Node root1 = new Node(100);
        root1.left = new Node(50);
        root1.right = new Node(300);
        root1.left.left = new Node(20);
        root1.left.right = new Node(70);
         
        /* Creating following tree as second balanced BST
                80
                / \
              40 120
        */
             
        Node root2 = new Node(80);  
        root2.left = new Node(40);
        root2.right = new Node(120);

        Node ans = mergeBSTApproach1(root1, root2);
       // Node ans = mergeBSTApproach2(root1, root2);
        printInorder(ans);
        //20 40 50 70 80 100 120 300 ans correct

    }

    static void printInorder(Node root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.data +" ");
        printInorder(root.right);
    }

    //Approach 1 TC O(m+n)  SC O(m+n) || --------------GIve approach 1 to interviewer first -------------
    //* STEPS -- 1--- Inorder for each root and save it,,, then merge two sorted arrays,, then make tree from inorder  */
    static Node mergeBSTApproach1(Node root1, Node root2){
        //Step 1 : store inorder
        ArrayList<Integer> inOrder1 = new ArrayList<>();
        ArrayList<Integer> inOrder2 = new ArrayList<>();
        inOrder(root1, inOrder1);
        inOrder(root2, inOrder2);

        //Step 2 : Merge two sorted arrays::
        ArrayList<Integer> mergedArrays = mergeTwoSortedArrays(inOrder1, inOrder2);

        //step 3 :: BST FROM INORDER 
        int s =0;
        int end = mergedArrays.size()-1;

        return inOrderToBST(s, end, mergedArrays);
    
    }

    static void inOrder(Node root,ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        inOrder(root.left,ans);
        ans.add(root.data);
        inOrder(root.right, ans);

    }

    static ArrayList<Integer> mergeTwoSortedArrays(ArrayList<Integer> arr1, ArrayList<Integer> arr2){

        ArrayList<Integer> mergedArray = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<arr1.size() && j <arr2.size()){
            if(arr1.get(i) <arr2.get(j)){
                mergedArray.add(arr1.get(i));
                i++;
            }else{
                mergedArray.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            mergedArray.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            mergedArray.add(arr2.get(i));
            j++;
        }

        return mergedArray;
    }

    static Node inOrderToBST(int start, int end, ArrayList<Integer> ans){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(ans.get(mid)); // mid wale element se root bna lo aur mid ke left me left recursion call right me right call
        root.left = inOrderToBST(start, mid-1, ans); //start to mid -1 is the left part
        root.right = inOrderToBST(mid+1, end, ans); // mid+1  to end is the right part
        return root;

    }

    //Approach 2 Space optimized
    //Steps::  Convert a BST into sorted linked list
    //:: Merge two sorted linked list
    //:: Convert Sorted Linked list into BST
    //!Approach 2 chl nhi rha hai wo phla method me reference wala khel ho rha
    static Node mergeBSTApproach2(Node root1, Node root2){
        //step 1 : convert a BST to sorted Linked List
        Node head1 =convertIntoSortedDoublyLinkedList(root1, null);
        head1.left = null;
        Node head2 =convertIntoSortedDoublyLinkedList(root1, null);
        head2.left = null;

        //step 2:: MErge two sorted linked list
        Node mergeTwoSorted =  mergeTwoSorted(head1, head2);

        //step 3:: Convert sorted linked list to bst
        int n = countNodes(mergeTwoSorted); // length of linked list

        return convertSortedLinkedListToBST(mergeTwoSorted, n);

    }
    //Step 1 :: Convert BST TO Sorted Linked List
    static Node convertIntoSortedDoublyLinkedList(Node root, Node head){
        //base case
        if(root == null){
            return null;
        }

        head.left = convertIntoSortedDoublyLinkedList(root.right, head);
        root.right = head;
        if(head != null){
        head.left = root;
        }

        head = root;
        head.right = convertIntoSortedDoublyLinkedList(root.left, head);
        return head;
    }
    //Step2 :: Merge two sorted linked list
    static Node mergeTwoSorted(Node h1 , Node h2){
        if(h1 == null)
        return h2; //if h1 is null then no need to merge

        if(h2==null)
        return h1; // if h2 is null no need to merge

        Node head  =null; //head and tail pointer 
        Node tail = null;

        if(h1.data<=h2.data){ // head aur tail pointer ko us h1 ya h2 ko assign kro jo ki chota hai 
            head =tail = h1;
            h1 = h1.right; // assign krne ke baad h1 ko aage bdha do
        }else{
            head = tail = h2;
            h2 = h2.right;
        }

        while(h1!=null && h2!=null){ 
            if(h1.data<=h2.data){ //check karo h1 aur h2 ka data since tail pointer already kisi ek head ko point kr rha toh next pointer kaun sa hoga uske liye aur jo bhi chota hai usko assign kr do tail ke next ko aur tail ko aage bdha do aur head ko aage bdha do
                tail.right = h1;
                tail =h1;
                h1 = h1.right;
            }
            else{
                tail.right =h2;
                tail =h2;
                h2= h2.right;
            }
        }
        if(h1 == null){ // suppose koi ek list khtm hogyi toh tail ke agle ke baaki bchi hui list pe point kr do isse
            tail.right = h2;
        }else{
            tail.right = h1;
        }
        return head;
    }

  static  int countNodes(Node head){ // to get the length of a linked list
        int count=0;
        Node temp = head;
        while(temp !=null){
            count++;
            temp = temp.right;
        }
        return count;
    }
    static Node convertSortedLinkedListToBST(Node head,int n){ //n is the length of a LL
        // base case
        if(n <=0 || head == null){
            return null;
        }

        Node left = convertSortedLinkedListToBST(head, n/2); //n/2 se phle wale left me aagya
        Node root = head; // root node bna li
        root.left = left; // root node ka left me left atttach kr lo

        head = head.right; // head ko aage bdha do
        root.right = convertSortedLinkedListToBST(head, n-n/2-1);
        return root;
    }
}


