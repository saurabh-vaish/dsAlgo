package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.List;

/**
 *
 * @Author saurabh vaish
 * @Date 11-06-2022
 */
public class RemoveAllMatchedElement {



    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();
        list.addAll(List.of(1,2,1,4,5));
        Node<Integer> temp = list.getHead();
//        temp = removeAllMatched(temp,1);
        temp = removeAllMatchedUsingRecusrion(temp,1);
        list.display(temp);
    }


    public static Node<Integer> removeAllMatched(Node<Integer> head,Integer value){
        if(head==null)return null;
        Node<Integer> dummy= new Node<>(0); // dummy node will point to head
        dummy.next=head;
        Node<Integer> nextNode = head; // used in iteration so that head wont effect
        Node<Integer> prev = dummy; // taking one more ref of dummy as if we iterate dummy it will not be on head so do process using ref
        while (nextNode!=null){
            if(nextNode.value==value){
               prev.next = nextNode.next;
            }else{
                prev = prev.next;
            }
            nextNode=nextNode.next;
        }
        return dummy.next;
    }

    public static Node<Integer> removeAllMatchedUsingRecusrion(Node<Integer> head,Integer value){
        if(head==null)return null;
        head.next = removeAllMatchedUsingRecusrion(head.next,value);
        return head.value==value?head.next:head; // while coming back from stack if value matched skip that element and reach to original state
    }

}
