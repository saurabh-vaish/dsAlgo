package linkedlist.ctci;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;
import linkedlist.Node;

import java.util.LinkedList;

class AnsNode{
    int ind;
    int ans;

    AnsNode(){}

    AnsNode(int ind,int ans){
        this.ind = ind;
        this.ans=ans;
    }
}

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * @Author saurabh vaish
 * @Date 07-07-2023
 */
public class CTCI_11_KthToTheLastElement {

    // O(N) both
    private static AnsNode KthToLastElementRec(LinkedListNode node, int k){
        if(node==null){return new AnsNode();}

        AnsNode ans = KthToLastElementRec(node.next,k);
        ans.ind= ans.ind+1; // 1 for indexing
        if(ans.ind==k){
            ans.ans= node.data;
        }

        return ans;
    }


    // O(n) , O(1)
    private static int KthToLastElement(LinkedListNode node,int k){
        int len=0;
        LinkedListNode temp=node;
        while(temp!=null){
            len++;
            temp=temp.next;
        }

        int step = 0;
        while(node!=null){
            if(step==len-k){
                return node.data;
            }
            step++;
            node=node.next;
        }

        return 0;
    }



    public static LinkedListNode KthElementTwoPointer(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        /* Move p1 k nodes into the list.*/
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }

        /* Move them at the same pace. When p1 hits the end,
         * p2 will be at the right element. */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            System.out.println(i +"th element from last = "+KthToLastElementRec(head, i).ans);

            System.out.println(i +"th element from last = "+KthToLastElement(head, i));

            LinkedListNode node = KthElementTwoPointer(head, i);
            if(node!=null){
                System.out.println(i +"th element from last = "+node.data);
            }else {
                System.out.println("null");
            }
        }
    }

}
