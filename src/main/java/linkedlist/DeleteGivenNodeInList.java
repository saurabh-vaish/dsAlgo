package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.List;

/**
 *
 * @Link = https://leetcode.com/problems/delete-node-in-a-linked-list/   , https://takeuforward.org/data-structure/delete-given-node-in-a-linked-list-o1-approach/
 *
 * @Problem = Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
 *
 *             It is guaranteed that the node to be deleted is not a tail node in the list.
 *
 * @Author saurabh vaish
 * @Date 15-06-2022
 */
public class DeleteGivenNodeInList {

    public static void main(String[] args) {

        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();
        list.addAll(List.of(1,2,3,4,5,6));
        deleteGivenNode(list.getNode(3));
        list.display(list.getHead());
    }

    // solution assign value of next node to node and next to next.next node as we are breaking link of that node
    // time & space == O(1)
    private static void deleteGivenNode(Node<Integer> node) {

        if(node.next!=null) {
            node.value = node.next.value; // assigning next value
            node.next = node.next.next; // assigning next to next.next as whole list after means breaking the link
        }
    }
}
