package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @Link = https://leetcode.com/problems/intersection-of-two-linked-lists/solution/  , https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/ , https://aaronice.gitbook.io/lintcode/linked_list/intersection-of-two-linked-lists
 *
 * @Problem  = Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * @Constraints =
 *              The number of nodes of listA is in the m.
 *              The number of nodes of listB is in the n.
 *              1 <= m, n <= 3 * 104
 *              1 <= Node.val <= 105
 *              0 <= skipA < m
 *              0 <= skipB < n
 *              intersectVal is 0 if listA and listB do not intersect.
 *               intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 *
 *
 * @Solution  == There could be multiple solutions --
 *          1. BruteForce solution
 *          2. Hash table
 *          3. differences of length
 *          3. Two pointers
 *
 *
 * @Author saurabh vaish
 * @Date 15-06-2022
 */
public class IntersectionOfLists {

    public static void main(String[] args) {

        SinglyLinkedListNormal<Integer> list1 = new SinglyLinkedListNormal<>();
        list1.addAll(Arrays.asList(4,1,8,4,5));
        SinglyLinkedListNormal<Integer> list2 = new SinglyLinkedListNormal<>();
        list2.addAll(Arrays.asList(5,6,1));

        Node<Integer> head1 = list1.getHead();
        Node<Integer> refHead1 = head1;
        refHead1 = refHead1.next.next; // ie. reached to 8

        Node<Integer> head2 = list2.getHead();
        Node<Integer> refHead2 =head2;
        while (refHead2.next!=null)refHead2 = refHead2.next;

        refHead2.next=refHead1;

//        Node<Integer> node = solution1BruteForce(list1.getHead(),list2.getHead());
//        Node<Integer> node = solution2UsingHashing(list1.getHead(),list2.getHead());
//        Node<Integer> node = solution3UsingDifferences(list1.getHead(),list2.getHead());
        Node<Integer> node = solution4UsingTwoPointersBest(list1.getHead(),list2.getHead());
        System.out.println(node.value);
    }


    // solution 4 - optimized and best -- using two pointers
    // we will take two pointers and start looping the array
    // if any pointer reahes to null we will assign it another list head
    // loop till both are not null
    // check if intersection is present

    private static Node<Integer> solution4UsingTwoPointersBest(Node<Integer> head1,Node<Integer> head2){
        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;

        while (temp1!=temp2){
            temp1 = temp1==null?head2:temp1.next;
            temp2 = temp2==null?head1:temp2.next;
        }
        return temp1;
    }


    // solution 3- using references of length
    // first iterate both of the list and get the length of lists
    // get the diff of list
    // based on diff traverse that much steps in list
    // then again loop both and check for node

    // Time Complexity: O(2max(length of list1,length of list2)) + O(abs(length of list1-length of list2)) + O(min(length of list1,length of list2))
    //
    //Reason: Finding the length of both lists takes max(length of list1, length of list2) because it is found simultaneously for both of them. Moving the head pointer ahead by a difference of them. The next one is for searching.
    //
    //Space Complexity: O(1)
    private static Node<Integer> solution3UsingDifferences(Node<Integer> head1,Node<Integer> head2){
        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;

        int l1=0,l2=0;
        while (temp1!=null || temp2!=null){
            if(temp1!=null){
                l1++;
                temp1=temp1.next;
            }
            if(temp2!=null){
                l2++;
                temp2=temp2.next;
            }
        }

        int diff = l1-l2;

        temp2 = head2;
        temp1 = head1;
        if(diff<0){ // means l2 is greater
            while (diff++!=0){
                temp2=temp2.next;
            }
        }else {
            while (diff--!= 0) temp1 = temp1.next;
        }

        while (temp1!=null){
            if(temp1==temp2)return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1;

    }


    // solution 2 - hashing
    // iterate first list and hash nodes of list
    // iterate 2nd list and check if any node present in hash
    // time - O(m + n) , space - O(m)

    public static Node<Integer> solution2UsingHashing(Node<Integer> head1,Node<Integer> head2){
        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;

        HashSet<Node<Integer>> hashSet = new HashSet<>();
        while (temp1!=null){
            hashSet.add(temp1);
            temp1 = temp1.next;
        }

        while (temp2!=null){
            if(hashSet.contains(temp2))return temp2;
            temp2 = temp2.next;
        }
        return null;
    }



    // solution 1 -- using bruteforce , loop two times by taking head of both list
    // check if any node is equal to node in another list
    // if yes then intersection found

    // time - O( m * n) , space - O(1)
    private static Node<Integer> solution1BruteForce(Node<Integer> head1,Node<Integer> head2){

        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;

        boolean found = false;
        while (temp1!=null){
            temp2 = head2;
            while (temp2!=null){

                if(temp2==temp1){
                    found = true;
                    break;
                }
                temp2=temp2.next;

            }
            temp1 =temp1.next;
            if(found)break;
        }

        return found?temp2:null;

    }




}
