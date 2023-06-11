package binarysearch;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/unique-element-in-sorted-array_1112654
 *
 *  find the number which is repeated only once in sorted array , there will always be 1 number that is not repeated.
 *
 *  sol == since only one element will be single so before that element in left sub array every element will be in {event,odd} position .
 *          and similar elements after single will be in right sub-array will be in {odd,even} position.
 *          so we will find element and will check if its previous and next are same or not , if any one is true means that element is not single .
 *          and by comparing that we will reduce the array
 *
 * @Author saurabh vaish
 * @Date 11-06-2023
 */
public class SigleElementInSortedArray {

    public static void main(String[] args) {
        int[] ar = {1,1,2,2,3,3,4,5,5,6,6};

        int el = singleInSortedArray(ar,ar.length);

        System.out.println("single elem == "+el);
    }

    private static int singleInSortedArray(int[] ar, int length){
        if(length==1)return ar[0];
        if(ar[0]!=ar[1])return ar[0];
        if(ar[length-1]!=ar[length-2])return ar[length-1];

        int low=1, high = length-2;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(ar[mid]!=ar[mid-1] && ar[mid]!=ar[mid+1])return ar[mid]; // if prev and next elem are not same then return that

            // in left
            if((ar[mid]==ar[mid-1] && mid%2==1 ) //mid in even
                    || (ar[mid]==ar[mid+1] && mid%2==0) // mid in odd position
            ){
                low=mid+1; // we are in left so remove left part
            }else {
                high=mid-1; // we are in right so remove right part
            }
        }

        return -1;
    }
}
