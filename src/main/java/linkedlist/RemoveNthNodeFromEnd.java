package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.List;

/**
 *
 * @Link = https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Problem = https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Author saurabh vaish
 * @Date 14-06-2022
 */
public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();
        list.addAll(List.of(1,2,3,4,5,6,7,8,9));
        Node<Integer> temp = list.getHead();
        list.display(removeNthNodeFromEnd(temp,2));
//        list.display(removeNthNodeFromEndBasic(temp,2));
//        list.display(middleIteration(temp));
    }

    // solution = https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/
    // time - O(n) as max we will iterate n
    // space - O(1)
    private static Node<Integer> removeNthNodeFromEnd(Node<Integer> head,int n){
        Node<Integer> dummy=new Node<>();
        dummy.next=head;
        Node<Integer> fast=dummy;
        Node<Integer> slow=dummy;

        // traverse fast untill it reaches the position
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // when fast wil reach to end then slow will be on position from end i.e. (total elemnt - nth)
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        // deleting node
        if(slow.next!=null) {
            slow.next = slow.next.next;
        }
        return dummy.next;

    }

    // solution = copied from leetcode submission
    private static Node<Integer> removeNthNodeFromCopied(Node<Integer> head,int n){

        // reversing the list making head in last

        Node<Integer> reversed= reverse(head, null);
        if(n < 2) {
            return reverse(reversed.next, null);
        }
        head = reversed;
        for(int i = 2; i < n; i++) {
            head = head.next;
        }
        head.next = head.next.next;

        // again reversing head to make head point from start again
        return reverse(reversed, null);
    }

    public static Node<Integer> reverse(Node<Integer> head, Node<Integer> tail) {
        if (head == null) {return tail;}
        Node<Integer> nextNode = head.next;
        head.next = tail;
        return reverse(nextNode, head);
    }


    // not recommended basic solution
    // solution = https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/
    // time - O(n) + O(n) as max we will iterate 3 tiems one for count and another for traversal
    // space - O(1)
    private static Node<Integer> removeNthNodeFromEndBasic(Node<Integer> head,int n){
        Node<Integer> dummy=new Node<>();
        dummy.next=head;
        Node<Integer> temp=head;
        Node<Integer> prev=dummy;
        int totalNodes = 0;
        // traverse fast untill it reaches the position
        while(temp!=null){
            totalNodes++;
            temp=temp.next;
        }

        int pos = totalNodes - n;
        for (int i = 0; i < pos; i++) {
            prev = prev.next;
        }

        // deleting node
        if(prev.next!=null) {
            prev.next = prev.next.next;
        }
        return dummy.next;

    }
    
    
    
}
