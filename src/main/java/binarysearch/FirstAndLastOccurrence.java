package binarysearch;

/**
 *
 * find first and last occurrence of an element in sorted array
 *
 * @Complexity = log(n) + log(n) = 2*log(n)
 *
 * @Author saurabh vaish
 * @Date 10-06-2023
 */
public class FirstAndLastOccurrence {

    public static void main(String[] args) {
        int[] ar = {2,5,8,8,8,11,15};
        int x=8;

        int first = first_occurrence(ar,ar.length,x);

        System.out.println("First occurrence of x = " +first);

        int last = last_occurrence(ar,ar.length,x);

        System.out.println("last occurrence of x = " +last);

    }

    private static int first_occurrence(int[] ar, int length, int x) {
        int low=0,high = length-1;
        int first = -1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(ar[mid]==x){
                first=mid;
                high=mid-1;
            } else if (ar[mid]<x) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        return first;
    }


    private static int last_occurrence(int[] ar, int length, int x) {
        int low=0,high = length-1;
        int last = -1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(ar[mid]==x){
                last=mid;
                low=mid+1;
            } else if (ar[mid]<x) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        return last;
    }
}
