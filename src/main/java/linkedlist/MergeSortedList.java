package linkedlist;

import linkedlist.singly.SinglyLinkedList;

import java.util.HashSet;

/***
 * @Problem = Given two sorted linked lists, merge them such that the result is combination of both sorted list
 *
 * @Solution = Iterate both and check which node is lesser add that then another one then move on.
 *
 * @Complexity = O(n) both
 *
 */

public class MergeSortedList {

    // complexity O(n)
    public static Node<Integer> mergeUsingNodes(Node<Integer> list1hHead, Node<Integer> list2hHead) {
        Node<Integer> node = new Node<>(); // created empty node and will add the next merged nodes to it similar to add function
        Node<Integer> temp = node;      // pointer that will decide which node to insert
        while(list1hHead!=null &&list2hHead!=null) { // iterate both lists
            if(list1hHead.value<list2hHead.value) {  // checking which node value is less
                temp.next = list1hHead;  // pointing node ref to that list node
                list1hHead = list1hHead.next;  // moving list to next position
            }else {
                temp.next = list2hHead; // greater element pointed to ref
                list2hHead = list2hHead.next;
            }
            temp = temp.next; // moving ref to next variable
        }
        temp.next = list1hHead==null?list2hHead:list1hHead;  // whichever list is not empty add all elements to ref
        return node.next;
    }

    static SinglyLinkedList<Integer> mergedList = new SinglyLinkedList<>();

    public static Node<Integer> mergeUsingThirdList(Node<Integer> list1hHead, Node<Integer> list2hHead) {

        while(list1hHead!=null &&list2hHead!=null) {
            if(list1hHead.value<list2hHead.value) {
                mergedList.add(list1hHead.value);
            }else {
                mergedList.add(list2hHead.value);
            }
            list1hHead = list1hHead.next;
            list2hHead = list2hHead.next;
        }

        while (list1hHead!=null) {
            mergedList.add(list1hHead.value);
            list1hHead = list1hHead.next;
        }

        while (list2hHead!=null) {
            mergedList.add(list2hHead.value);
            list2hHead = list2hHead.next;
        }

        return mergedList.getHead();
    }



        public static void main(String[] args) {

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(6);
        list1.add(7);
        list1.add(8);

        list1.display();

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.add(2);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(9);

        list2.display();

        Node<Integer> mergedListHead = mergeUsingNodes(list1.getHead(),list2.getHead());

        Node<Integer> mergedListHead2 = mergeUsingThirdList(list1.getHead(),list2.getHead());

        list2.display(mergedListHead);
        list2.display(mergedListHead2);
    }

}
