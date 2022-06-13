package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.Arrays;
import java.util.List;

/**
 * @Link  = https://leetcode.com/problems/sort-list/
 *
 * @Problem = Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * @Complexity - O(n * logN)
 *
 * @Author saurabh vaish
 * @Date 12-06-2022
 */
public class SortList {

    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();
//        list.addAll(List.of(4,1,3,2,6,5));
        list.addAll(List.of(-1,5,3,4,0));
        Node<Integer> temp = list.getHead();
        list.display(sortList(temp));

        list.display(sortList2(temp));

    }

    private static Node<Integer> getMiddle(Node<Integer> head) {
        Node<Integer> slow=head;
        Node<Integer> fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> sortList(Node<Integer> head){
        if(head==null || head.next==null) return head;

        Node<Integer> mid = getMiddle(head);
        Node<Integer> right = sortList(mid.next);
        mid.next=null;
        Node<Integer> left = sortList(head);

       return mergeListInPlace(left,right);

    }

    private static Node<Integer> mergeListInPlace(Node<Integer> left, Node<Integer> right) {
        Node<Integer> node = new Node<>(0);
        Node<Integer> temp = node;

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

        return node.next;
    }


    // another method [ copied ]
    private static Node<Integer> sortList2(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        int minInList = head.value;
        int maxInList = minInList;
        Node<Integer> cur = head;

        while (cur != null) {
            int curValue = cur.value;
            if (curValue < minInList) minInList = curValue;
            else if (curValue > maxInList) maxInList = curValue;

            cur = cur.next;
        }

        int range = maxInList - minInList + 1;

        Node[] heads = new Node[range];
        Node[] tails = new Node[range];

        cur = head;
        while (cur != null) {
            int idx = cur.value - minInList;
            if (heads[idx] == null) {
                heads[idx] = cur;
            } else {
                tails[idx].next = cur;
            }
            tails[idx] = cur;
            cur = cur.next;
        }
        Node<Integer> dummyHead = new Node<Integer>(0);
        cur = dummyHead;
        for (int i = 0; i < range; i++) {
            if (heads[i] != null) {
                cur.next = heads[i];
                cur = heads[i];
            }
        }
        cur.next = null;
        return dummyHead.next;

//        int count=0;
//
//        Node<Integer> temp=head;
//
//        while(temp !=null){
//            count++;
//            temp=temp.next;
//        }
//        int arr[]=new int[count];
//        temp=head;
//        int f=0;
//        while(temp !=null){
//            arr[f++]=temp.value;
//            temp=temp.next;
//        }
//        Arrays.sort(arr);
//
//        temp=head;
//        f=0;
//        while(temp !=null){
//            temp.value=arr[f++];
//            temp=temp.next;
//        }
//
//        return head;
    }



}
