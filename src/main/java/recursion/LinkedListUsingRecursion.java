package recursion;

/**
 *  Implement Linked List using recursive approach
 *
 * @Complexity --- Insert O(1) , search O(n) , deletion O(n)
 *                  space -- O(n) [ recursive ] , O(1) [ iterative ]
 *
 *
 *
 * @author Saurabh Vaish
 * @Date 21-07-2021
 */

class Node{
    public String value;
    public Node next;

    Node(String value){
        this.value=value;
        this.next=null;
    }
}


public class LinkedListUsingRecursion {

    public Node head;

    public void append(String value){
        if(head==null){
            this.head=new Node(value);
            return;
        }
        this._append(value,this.head);
    }

    private void _append(String value,Node curr){
        if(curr.next==null){
            curr.next=new Node(value);
            return;
        }
        this._append(value,curr.next);
    }


    public void print(){
        if (this.head==null) System.out.println("List is empty");
        else System.out.println(this._print(this.head));
    }

    private String _print(Node curr) {
        if(curr==null)return "";
        return curr.value+"->"+this._print(curr.next);
    }

    public boolean contains(String target){
        return this._contains(this.head, target);
    }

    private boolean _contains(Node curr,String target) {
        if(curr==null)return false;
        if(curr.value.equals(target))return true;
        return this._contains(curr.next,target);
    }

    public String sum(){
        return this._sum(this.head);
    }

    private String _sum(Node curr) {
        if(curr==null)return "";
        return curr.value+this._sum(curr.next);
    }

    public String delete(String target){
        if(this.head==null)return "list is empty"; // if empty
        else if(this.head.value.equals(target)){
            this.head=this.head.next; // if deleting first element
            return target;
        }

        boolean found=false;
        Node curr = head;

        // iterative sol
//        Node prev = null;
//        while ((curr!=null)){
//            if(curr.value.equals(target)){
//                prev.next=curr.next; // setting previous node next to deleting node next node
//                found=true;
//                break;
//            }
//            prev=curr;
//            curr=curr.next;
//        }
//        return found?target:"element not found";

        // recursive sol
        found = this._delete(curr,null,target);
        return found?target:"element not found";
    }

    private boolean _delete(Node curr, Node prev, String target) {
        if(curr==null)return false;
        if(curr.value.equals(target)){
            prev.next=curr.next;
            return true;
        }
        return this._delete(curr.next, curr, target);
    }

    public static void main(String[] args) {

        LinkedListUsingRecursion list = new LinkedListUsingRecursion();
        list.append("4");
        list.append("5");
        list.append("6");
        list.append("3");
        list.append("9");
        list.print();
        System.out.println(list.contains("5"));
        System.out.println(list.sum());

        System.out.println("before deletion = ");
        list.print();
        System.out.println(list.delete("5"));
        System.out.println("after deletion = ");
        list.print();

    }
}
