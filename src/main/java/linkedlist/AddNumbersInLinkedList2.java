package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.Arrays;

/**
 * @Link == https://aaronice.gitbook.io/lintcode/linked_list/add_two_numbers_ii
 *
 * @Problem == You are given two non-empty linked lists representing two non-negative integers. Add the two numbers and return the sum as a linked list.
 *              You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *      ==> This problem is same as the add two numbers except the numbers are not stored in reverse order , so first we need to reverse both of the list then add
 *
 * @Author saurabh vaish
 * @Date 14-06-2022
 */
public class AddNumbersInLinkedList2 {

    public static void main(String[] args) {

        SinglyLinkedListNormal<Integer> list1 = new SinglyLinkedListNormal<>();
//        list1.addAll(Arrays.asList(2,4,3));
        list1.addAll(Arrays.asList(6,1,7));
        SinglyLinkedListNormal<Integer> list2 = new SinglyLinkedListNormal<>();
//        list2.addAll(Arrays.asList(5,6,4));
        list2.addAll(Arrays.asList(2,9,5));

        Node<Integer> sumHead = addTwoNumbersOptimized(list1.getHead(),list2.getHead());
        sumHead = reverse(sumHead);
        while (sumHead!=null){
            System.out.print(sumHead.value + "-> ");
            sumHead=sumHead.next;
        }

    }

    public static Node<Integer> reverse(Node<Integer> head){
        Node<Integer> prev = null;

        while (head!=null){
            Node<Integer> nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }

    // Time Complexity == O(head1) + O(head2) +  O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively, so it iterates at most max(m,n) times.
    //
    //Space Complexity =  O(max(m,n)). The length of the new list is at most max(m,n)+1.
    public static Node<Integer> addTwoNumbersOptimized(Node<Integer> head1,Node<Integer> head2){
        if(head1==null)return head2;
        if(head2==null)return head1;

        head1 = reverse(head1);
        head2 = reverse(head2);

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


}
