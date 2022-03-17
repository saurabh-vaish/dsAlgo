package linkedlist;

import linkedlist.singly.SinglyLinkedList;

import java.util.HashSet;

/***
 * @Problem = Remove Duplicates from Sorted Linked List
 *
 * @Solution = Iterate and check next node value is same as current node value then skip next node
 *
 * @Complexity = O(n) both
 *
 */

public class RemoveDuplicates {

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

    public static Node<Integer> removeDuplicatesInUnSortedList(Node<Integer> head) {
    if(head==null)return head;
        Node<Integer> node = head;

        /***
        // approach 1 using two loops complexity O(n^2)
        while (node!=null && node.next != null) {
            Node<Integer> temp = node;

            // whenever duplicate found skip next node
            while (temp.next != null) {
                if(node.value.equals(temp.next.value)) {
                    temp.next = temp.next.next; // skip next node
                }else {
                    temp = temp.next;
                }
            }
            node=node.next;

        }
        return head;
        ***/

        // approach 2 using hashset  complexity O(n)
        HashSet<Integer> set = new HashSet<>();
        Node<Integer> prev = node; // to track previous node
        while (node.next != null) {
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

        removeDuplicatesInUnSortedList(unsortedList.getHead());

        unsortedList.display();
    }

}
