package com.demo.basicDATASTRUCTURE.LinkedList;

//https://www.codingninjas.com/codestudio/problems/sort-linked-list-of-0s-1s-2s_1071937
public class Sort012s {
    public static void main(String[] args) {
        
    }


    //Approach 1 ye hai ki zero 1 and 2 ko count kr lo phir loop chla do ki linked list ke data ko modify kr do
    static Node sortO12Approach1(Node head){
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;

        Node temp = head;
        while(temp!=null){
            if(temp.data ==0){
                zeroCount++;
            }
            else if(temp.data ==1){
                oneCount++;
            }
            else if(temp.data ==2){
                twoCount++;
            }
            temp =temp.next;
        }

        temp =head; // why because temp pehle wale loop ke hisab se null point kr rha hoga 
        while(temp !=null){
            if(zeroCount !=0){
                temp.data =0;
                zeroCount--;
            }
            else if(oneCount  !=0){
                temp.data = 1;
                oneCount--;
            }
            else if(twoCount !=0){
                temp.data =2;
                twoCount--;
            }
            temp =temp.next;
        }
        return head;
    }
    

}
