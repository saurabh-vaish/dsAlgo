package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.Arrays;

/**
 *
 * @Link = https://aaronice.gitbook.io/lintcode/linked_list/odd-even-linked-list
 *
 * @Problem  = Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *              You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * @Author saurabh vaish
 * @Date 14-06-2022
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {


        SinglyLinkedListNormal<Integer> list1 = new SinglyLinkedListNormal<>();
        list1.addAll(Arrays.asList(1,2,3,4,5)); // output = 1,3,5,2,4

        list1.display(evenOdd(list1.getHead()));

    }

    public static Node<Integer> evenOdd(Node<Integer> head){
        if(head==null)return head;

        Node<Integer> odd=head,even = head.next ; // as first position is odd and second is even
        Node<Integer> evenHead = even; // to add even in last

        while (even !=null && even.next!=null){
//            even=even.next;
            if(odd.next!=null) {
                odd.next = odd.next.next;
            }
            even.next = even.next.next;
            odd=odd.next;
            even=even.next;
        }

        if(odd!=null)
        odd.next = evenHead;   // adding all even after odd

        return head;
    }

}
