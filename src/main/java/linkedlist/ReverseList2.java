package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.lang.ref.Cleaner;
import java.util.List;

/**
 * @Link = https://aaronice.gitbook.io/lintcode/linked_list/reverse-linked-list-ii , https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * @Problem = Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 * @Author saurabh vaish
 * @Date 15-06-2022
 */
public class ReverseList2 {

    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();
        list.addAll(List.of(1,2,3,4,5));
        Node<Integer> head = list.getHead();
        list.display(reverseBetweenCopied(head,2,4));
    }


    public static Node<Integer> reverseBetween(Node<Integer> head,int left,int right){

        if(head==null)return head;
        if (left==1 && right==1)return head; // only one element in list

        // taking pointers to reach start position for swap
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        while (left>1){
            prev=curr;
            curr=curr.next;
            left--;
            right--;
        }

        // the two pointers that will maintain list in final
        Node<Integer> con = prev, tail = curr;

        // node swapping
        Node<Integer> third = null;

        while (right>0){
            third = curr.next; // next node
            curr.next = prev; //  breaking and assigning link to prev node
            prev=curr; // updating prev to curr
            curr=third; // updating curr to upcoming node
            right--;
        }

        if(con!=null){
            con.next=prev; // assigning start node to end
        }else {
            head=prev;
        }
        tail.next=curr; // assgining remaining node

        return head;

    }


    public static Node<Integer> reverseBetweenCopied(Node<Integer> head, int left, int right) {
        Node<Integer> dummyNode = new Node<Integer>();
        dummyNode.next = head;

        Node<Integer> pre = dummyNode;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        Node<Integer> cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            Node<Integer> nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = pre.next;
            pre.next = nextNode;
        }
        return dummyNode.next;
    }
    
}
