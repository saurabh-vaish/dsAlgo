package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Link = https://takeuforward.org/data-structure/check-if-given-linked-list-is-plaindrome/ , https://aaronice.gitbook.io/lintcode/linked_list/palindrome-linked-list, https://leetcode.com/problems/palindrome-linked-list/
 *
 * @Problem = Given the head of a singly linked list, return true if it is a palindrome.
 *
 * @Author saurabh vaish
 * @Date 18-06-2022
 */
public class PalindromicLinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list1 = new SinglyLinkedListNormal<>();
        list1.addAll(Arrays.asList(1,2,3,2,1));

//        System.out.println(palindromicBasic(list1.getHead()));
        System.out.println(palindromic(list1.getHead()));

    }

    private static boolean palindromicOptimized(Node<Integer> head){
        if(head==null)return false;

        Node<Integer> slow = head;
        Node<Integer> fast = head;
        Node<Integer> prev = null;

        while(fast!=null && fast.next!=null){ //reverse till midpoint denoted by slow pointer.
            fast = fast.next.next; //fast here in this line is imp because after this we are reversing the pointer.
            Node<Integer> temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        if(fast!=null){//if odd palindrome
            slow = slow.next;
        }
        while(prev!=null && slow!=null){
            if(prev.value!=slow.value){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }


    /// Time Complexity: O(N/2)+O(N/2)+O(N/2)
    //
    //  Reason: O(N/2) for finding the middle element, reversing the list from the middle element, and traversing again to find palindrome respectively.
    //
    //Space Complexity: O(1)
    //Reason: No extra data structures are used.
    private static boolean palindromic(Node<Integer> head){
        if(head==null)return false;

        Node<Integer> dummy = head;
        Node<Integer> slow = dummy;
        Node<Integer> fast = dummy;

        /// find the middle of the list
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node<Integer> mid= slow.next;

        // reverse the list after middle
        mid = reverse(mid);

        // start iterating from mid again and match next elem from starting
        while (mid!=null){
            if (dummy.value!=mid.value)return false;
            dummy=dummy.next;
            mid=mid.next;
        }

        return true;
    }

    private static Node<Integer> reverse(Node<Integer> mid) {
        Node<Integer> prev = null;

        Node<Integer> curr = mid;
        while (curr!=null){
            Node<Integer> nextNode = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }

        return prev;

    }


    // in this solution we will take an array with same size as linked and iterate list and add into array then
    // check if that array is palindromic or not
    // time - O(n) + O(n/2)
    // space - O(N) as storing in new array
    private static boolean palindromicBasic(Node<Integer> head) {

        if(head==null)return false;

        List<Integer> arrayList = new ArrayList<>(); // taking arraylist instead of array as we dont need size otherwise first we will find length of linked list

        Node<Integer> temp = head;

        while (temp!=null){
            arrayList.add(temp.value);
            temp = temp.next;
        }

        for (int i = 0; i < arrayList.size()/2; i++) { // till half as we are comparing first and last elem
            if(!arrayList.get(i).equals(arrayList.get(arrayList.size()-1-i)))return false;
        }

        return true;

    }
}
