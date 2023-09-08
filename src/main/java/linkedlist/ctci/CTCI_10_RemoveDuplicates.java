package linkedlist.ctci;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;
import linkedlist.Node;
import linkedlist.singly.SinglyLinkedList;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * @Author saurabh vaish
 * @Date 07-07-2023
 */
public class CTCI_10_RemoveDuplicates {



    // O(n) both
    // // for every node will check in set if present add prev next to node next node and increase node .next evry time
    //        // if not found make prev to point out node again
    //        // as this is fast and slow pointer approach
    public static Node<Integer> removeDuplicatesInUnSortedList(Node<Integer> head) {
        if(head==null)return head;
        Node<Integer> node = head;
        // approach 2 using hashset  complexity O(n)
        HashSet<Integer> set = new HashSet<>();
        Node<Integer> prev = node; // to track previous node
        while (node != null) {
            if(set.contains(node.value)) {
                prev.next = node.next; // skip next node
            }else {
                set.add(node.value);
                prev= node;
            }
            node = node.next;
        }
        return node;
    }

    // O(n2) , O(1)
    // using two pointers , current which iterates through the linked list, and runner which checks all subsequent nodes for duplicates
    public static Node<Integer> removeDuplicatesInUnSortedListWithoutExtraBuffer(Node<Integer> head) {
        if(head==null)return head;
        Node<Integer> cuurent = head;

        // loop through list
        while (cuurent != null) {

            Node<Integer> runner = cuurent;
            // for each current node ,runner will loop through all other
            while(runner.next!=null){
                if(runner.next.value==cuurent.value){
                    runner.next = runner.next.next;
                }else{
                    runner=runner.next;
                }
            }
            cuurent = cuurent.next;
        }
        return cuurent;
    }



    // O(N) , O(1)
    public static Node<Integer> removeDuplicatesInSortedList(Node<Integer> head) {
        if(head==null)return head;
        Node<Integer> node = head;
        while (node.next != null) {
            if(node.value.equals(node.next.value)) {
                node.next = node.next.next; // skip next node
            }else {
                node = node.next;
            }
        }
        return node;
    }
    public static void main(String[] args) {

        SinglyLinkedList<Integer> sorteList = new SinglyLinkedList<>();
        sorteList.add(1);
        sorteList.add(1);
        sorteList.add(2);
        sorteList.add(2);
        sorteList.add(2);
        sorteList.add(2);
        sorteList.add(3);
        sorteList.add(3);
        sorteList.add(4);

        sorteList.display();

        removeDuplicatesInSortedList(sorteList.getHead());

        sorteList.display();

        System.out.println(" in unsorted ");

        SinglyLinkedList<Integer> unsortedList = new SinglyLinkedList<>();
        unsortedList.add(2);
        unsortedList.add(4);
        unsortedList.add(1);
        unsortedList.add(5);
        unsortedList.add(2);
        unsortedList.add(1);
        unsortedList.add(3);
        unsortedList.add(1);
        unsortedList.add(6);

        unsortedList.display();

        removeDuplicatesInUnSortedListWithoutExtraBuffer(unsortedList.getHead());
        unsortedList.display();

        System.out.println("unsorted 2");

        SinglyLinkedList<Integer> unsortedList2 = new SinglyLinkedList<>();
        unsortedList2.add(3);
        unsortedList2.add(2);
        unsortedList2.add(3);
        unsortedList2.add(4);
        unsortedList2.add(2);
        unsortedList2.add(3);
        unsortedList2.add(-1);

        unsortedList2.display();

        removeDuplicatesInUnSortedList(unsortedList2.getHead());

        unsortedList2.display();
    }

}
