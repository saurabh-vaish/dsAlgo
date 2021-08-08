package binarysearch;


/**
 * @Problem == Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *              You may assume no duplicates in the array.
 *
 * @Complexity == O(logN), same as that of Binary Search.
 *
 * @author Saurabh Vaish
 * @Date 30-05-2021
 */
public class InsertionPositionInSortedArray {

    public static void main(String[] args) {
        int ar[]={1,3,4,5,6};
        int target = 5; // -2 , 0 ,12 ,4
        int index = insertionPositionInArray(ar,target);
        System.out.println("Element index = "+index);
    }

    private static int insertionPositionInArray(int[] ar, int target) {
        int left =0;
        int right = ar.length;
        // notice that right is ar.length and NOT (ar.length - 1) because
        // when the target is greater than all items in the given array then the answer should be ar.length.
        // Similarly if the target is less than all items in the array then the answer would be index 0
        // so left is initialized to 0. and Search space = [0, ar.length]

        while(left<right){
            int mid=(left+right)/2;
            if(ar[mid]>=target){  // when target is lesser than mid then shift right right to mid
                right=mid;      // as element resides in left part
            }else{
                left=mid+1;   // element in right part
            }
        }
        return left;
    }
}
