package recursion;

/**
 * @Problem == Program to revere linked list
 *
 *
 * @author Saurabh Vaish
 * @Date 21-07-2021
 */
public class ReverseLinkedList {

    // time O(n) , space O(1)
    public static Node reverseListIterative(Node head){
        if(head==null){
            System.out.println("list is empty");
            return head;
        }
        Node prev=null;
        Node curr = head;
        while (curr!=null){
            Node next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static Node reverseListRecursive(Node head){
        return _reverseListRecursive(head,null);
    }


    // time & space both O(n)
    private static Node _reverseListRecursive(Node curr, Node prev) {
        if(curr==null)return prev;
        Node next=curr.next;
        curr.next=prev;
        return _reverseListRecursive(next, curr);
    }

    public static void main(String[] args) {
        LinkedListUsingRecursion list = new LinkedListUsingRecursion();
        list.append("4");
        list.append("5");
        list.append("6");
        list.append("3");
        list.append("9");

        System.out.println("before reverse = ");
        list.print();
//        list.head = reverseListIterative(list.head);
        list.head = reverseListRecursive(list.head);
        System.out.println("after reverse = ");
        list.print();
    }
}
