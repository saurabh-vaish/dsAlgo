package binarysearch;

/**
 * @Link = https://www.codingninjas.com/studio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
 *
 * @Problem  == In a given sorted having duplicates find first and last occurrence of target .
 *
 * @Solution  == We can solve by calling two methods findFirst and findLast .
 *                 findFirst denotes  to "find the minimum index for which input[index] >= target"
 *                 findLast denotes  to find minimum index in given input[] array such that input[index + 1] > target.
 *
 * @Complexity ==
 *
 *
 * @author Saurabh Vaish
 * @Date 30-05-2021
 */
public class FindFirstAndLastOccurrenceOfElementInSortedArray {

    public static void main(String[] args) {
        int[] input1 = {1,1,2,2,2,3,4,4,5,6,7};
//        System.out.println(findFirst(input1,1)+" -- "+findLast(input1,1));
        System.out.println(findFirst(input1,3)+" -- "+findLast(input1,3));
        System.out.println(findFirst(input1,4)+" -- "+findLast(input1,4));

        int[] input2 = {2,2,3,4,4};
        System.out.println(findFirst(input2,2)+" -- "+findLast(input2,2));
        System.out.println(findFirst(input2,3)+" -- "+findLast(input2,3));
        System.out.println(findFirst(input2,4)+" -- "+findLast(input2,4));

        int[] input3 = {2};
        System.out.println(findFirst(input3,2)+" -- "+findLast(input3,2));
        System.out.println(findFirst(input3,3)+" -- "+findLast(input3,3));
        System.out.println(findFirst(input3,1)+" -- "+findLast(input3,1));
    }

    // lower bound
    private static int findFirst(int[] ar, int x) {
        int len=ar.length;

        if(len==0 || x<ar[0] || x>ar[len-1]){
            return -1;
        }
        if(len==1 && x==ar[0]){
            return 0;
        }
        int low=0,high = len-1;

        int first = -1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(ar[mid]==x){
                first=mid;
                high=mid-1;  // as we need to find the first occurrence so shifting high
            } else if (ar[mid]<x) {
                low=mid+1;          // if value is still less move low across mid
            }else {
                high=mid-1; // value high so move high before mid
            }
        }

        return first;
    }

    private static int findLast(int[] ar, int target) {
        int len=ar.length;

        if(len==0 || target<ar[0] || target>ar[len-1]){
            return -1;
        }
        if(len==1 && target==ar[0]){
            return 0;
        }

        int low=0,high = len-1;
        int last = -1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(ar[mid]==target){
                last=mid;
                low=mid+1;          // since we need to find last so whenever value matches move low to high
            } else if (ar[mid]<target) {  // if value is less then move low to high
                low=mid+1;
            }else {
                high=mid-1; // value is more so move high to low
            }
        }

        return last;
    }
}
