package binarysearch;

/**
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
        int[] input1 = {2,3,3,4};
        System.out.println(findFirst(input1,1)+" -- "+findLast(input1,1));
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

    private static int findFirst(int[] ar, int target) {
        int left=0;
        int right=ar.length-1;
        int len=ar.length;

        if(len==0 || target<ar[0] || target>ar[len-1]){
            return -1;
        }
        if(len==1 && target==ar[0]){
            return 0;
        }

        while (left<right){
            int mid=(left+right)/2;
            if(ar[mid]>=target){  // find the minimum index for which input[index] >= target
                right=mid;
            }else{
                left=mid+1;
            }
        }

        if(ar[left]!=target)return -1;

        return left;
    }

    private static int findLast(int[] ar, int target) {
        int left=0;
        int right=ar.length-1;
        int len=ar.length;

        if(len==0 || target<ar[0] || target>ar[len-1]){
            return -1;
        }
        if(len==1 && target==ar[0]){
            return 0;
        }

        while (left<right){
            int mid=(left+right)/2;
            if(ar[mid]>target){  // find the minimum index for which input[index] >= target
                right=mid;
            }else{
                left=mid+1;
            }
        }

        if(ar[left]==target)return left;
        if(ar[left-1]!=target)return -1;

        return left-1;
    }

}
