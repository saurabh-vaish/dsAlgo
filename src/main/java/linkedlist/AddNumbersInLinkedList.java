package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.Arrays;

/**
 * @Link ==  https://aaronice.gitbook.io/lintcode/linked_list/add-two-numbers  , https://leetcode.com/problems/add-two-numbers/submissions/ , https://takeuforward.org/data-structure/add-two-numbers-represented-as-linked-lists/
 *
 * @Problem == You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *              You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @Author saurabh vaish
 * @Date 14-06-2022
 */
public class AddNumbersInLinkedList {

    public static void main(String[] args) {

        SinglyLinkedListNormal<Integer> list1 = new SinglyLinkedListNormal<>();
//        list1.addAll(Arrays.asList(2,4,3));
        list1.addAll(Arrays.asList(9,9,9,9,9,9,9));
        SinglyLinkedListNormal<Integer> list2 = new SinglyLinkedListNormal<>();
//        list2.addAll(Arrays.asList(5,6,4));
        list2.addAll(Arrays.asList(9,9,9,9));

        Node<Integer> sumHead = addTwoNumbersOptimized(list1.getHead(),list2.getHead());
        while (sumHead!=null){
            System.out.print(sumHead.value + "-> ");
            sumHead=sumHead.next;
        }

    }

    // Time Complexity ==  O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively, so it iterates at most max(m,n) times.
    //
    //Space Complexity =  O(max(m,n)). The length of the new list is at most max(m,n)+1.
    public static Node<Integer> addTwoNumbersOptimized(Node<Integer> head1,Node<Integer> head2){
        if(head1==null)return head2;
        if(head2==null)return head1;

        Node<Integer> dummy = new Node<>(); // create dummy node for new list
        Node<Integer> curr = dummy;  // create a temp node for traversal
        int carry = 0; // carry to calculate for next

        // if any one head is not null and carry is not 0
        while (head1!=null || head2!=null || carry>0){

            int sum=0;
            if(head1!=null){
                sum +=head1.value;
                head1 = head1.next;
            }

            if(head2!=null){
                sum +=head2.value;
                head2 = head2.next;
            }

            sum += carry;  // add remaining carry
            carry = sum / 10; // carry calculation
            curr.next = new Node<>(sum%10);    // new node in list
            curr=curr.next;
        }
        return dummy.next;

    }


    // Time Complexity ==  O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively, so it iterates at most max(m,n) times.
    //
    //Space Complexity =  O(max(m,n)). The length of the new list is at most max(m,n)+1.
    public static Node<Integer> addTwoNumbers(Node<Integer> head1,Node<Integer> head2){
        if(head1==null)return head2;
        if(head2==null)return head1;

        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;
        Node<Integer> dummy = new Node<>();
        Node<Integer> curr = dummy;

        int carry = 0;

        while (temp1!=null && temp2!=null){

            int sum= temp1.value + temp2.value + carry;
            carry = sum / 10;
            curr.next = new Node<>(sum%10);
            temp1 = temp1.next;
            temp2= temp2.next;
            curr=curr.next;
        }

        while (temp1!=null){
            int sum = temp1.value + carry;
            carry = sum/10;
            curr.next = new Node<>(sum%10);
            curr=curr.next;
            temp1 = temp1.next;
        }

        while (temp2!=null){
            int sum = temp2.value + carry;
            carry = sum/10;
            curr.next = new Node<>(sum%10);
            curr=curr.next;
            temp2 = temp2.next;
        }

        if(carry>0){
            curr.next = new Node<>(carry);
        }
        return dummy.next;

    }

}
