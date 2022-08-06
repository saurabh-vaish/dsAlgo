package bitwise;

/**
 * @Author saurabh vaish
 * @Date 05-08-2022
 */
public class MissingNumber {

    //https://leetcode.com/problems/missing-number/
    //Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array
    public static void main(String[] args) {
//        int ar[] = new int[]{1, 2, 4, 6, 3, 7, 8}; // 5
//        int ar[] = new int[]{9,6,4,2,3,5,7,0,1}; // 8
        int ar[] = new int[]{0,1,2,3,5}; // 8

        System.out.println(usingBitManipulation(ar,ar.length));

        System.out.println(usingSum(ar,ar.length));
        System.out.println(usingSum2(ar,ar.length));
    }

    // since XOR of same number gives 0
    // O(n)
    private static int usingBitManipulation(int[] ar, int n) {
        int c=n;                        // as all numbers are in range
        for (int i = 0; i <n ; i++) {
            c = c ^ i ^ ar[i];
        }
        return c;
    }


    private static int usingSum(int[] ar, int length) {
        int sum=length;   // taking length as all the numbers are in range from 0 to N
        for (int i = 0; i < ar.length; i++) {
            sum = sum +i - ar[i];  /// logic sum of all numbers from 0 to n - sum of ar elements // (sum=sum+i) one loop then sum = sum-num[i] another , here optimized
        }
        return sum;
    }

    private static int usingSum2(int[] ar, int n) {
        int max= (n * (n+1))/2;         // max sum
        int sum=0;
        for (int i = 0; i < ar.length; i++) {
            sum = sum + ar[i];
        }
        return max-sum;       // max sum - element sum
    }



}
