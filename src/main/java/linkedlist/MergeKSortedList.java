package linkedlist;

import linkedlist.singly.SinglyLinkedList;
import linkedlist.singly.SinglyLinkedListNormal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Link = https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @Problem = You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *            Merge all the linked-lists into one sorted linked-list and return it.
 *
 * @Complexity -- Time -- O(n * log(k)) , space - O(1)
 *              // complexity - com of merge sort * k/2 times dividing , so log( n * log(k));
 *
 * @Author saurabh vaish
 * @Date 13-06-2022
 */
public class MergeKSortedList {

    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list1 = new SinglyLinkedListNormal<>();
        list1.addAll(Arrays.asList(1,4,5));
        SinglyLinkedListNormal<Integer> list2 = new SinglyLinkedListNormal<>();
        list2.addAll(Arrays.asList(1,3,5));
        SinglyLinkedListNormal<Integer> list3 = new SinglyLinkedListNormal<>();
        list3.addAll(Arrays.asList(2,6));

//        List<Node<Integer>> lists = List.of(list1.getHead(), list2.getHead(), list3.getHead());
        List<Node<Integer>> lists = Collections.emptyList();
        if(lists==null) System.out.println("null");
        if(lists.size()==0) System.out.println("[]");
        Node<Integer> sortNode = mergeKLists(lists);
        while (sortNode!=null){
            System.out.println(sortNode.value);
            sortNode=sortNode.next;
        }

    }

    // using divide and conquer method
    // In this we will assume we need to sort whole list
    private static Node<Integer> mergeKLists(List<Node<Integer>> lists){
        // edge conditions
        if(lists==null)return null;
        if(lists.size()==0)return null;
        if(lists.size()==1)return lists.get(0);

        // will take two pointers , start and end for deciding mid
        return mergeHelper(lists,0,lists.size()-1);

    }

    private static Node<Integer> mergeHelper(List<Node<Integer>> lists, int start, int end) {
        if(start==end)return lists.get(start);
        int mid = (start+end)/2;
        Node<Integer> left = mergeHelper(lists,start,mid); // left sub list
        Node<Integer> right = mergeHelper(lists,mid+1,end); // right sublist
        return mergeLists(left,right);
    }

    // in place merge
    private static Node<Integer> mergeLists(Node<Integer> left, Node<Integer> right) {
        Node<Integer> dummy = new Node<>();
        Node<Integer> temp = dummy;

        while (left!=null && right!=null){
            if(left.value<right.value){
                temp.next=left;
                left=left.next;
            }else {
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }

        temp.next = left!=null?left:right;

        return dummy.next;
    }



    // another method
    public Node<Integer> mergeKLists2(List<Node<Integer>> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        if (lists.size() == 2) {
            return mergeLists(lists.get(0), lists.get(1));
        }
        return mergeLists(
                mergeKLists(lists.subList(0, lists.size() / 2)),
                mergeKLists(lists.subList(lists.size() / 2, lists.size()))
        );
    }
}
