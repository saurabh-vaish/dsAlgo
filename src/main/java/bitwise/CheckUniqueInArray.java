package bitwise;

/**
 * Program to find the unique number in array [ assuming array has only one unique number ]
 *
 * @Author saurabh vaish
 * @Date 31-07-2022
 */
public class CheckUniqueInArray {

    public static void main(String[] args) {
        System.out.println(uniqueWhenRepeatedEvenTimes(new int[]{2,3,1,3,6,1,2}));  // repeated even times (2)  // ans = 6
        System.out.println(uniqueWhenRepeatedOddTimes(new int[]{2,2,4,2,7,8,7,7,8,8})); // repeated odd times (3)  // ans = 4
    }

    // complexity == O(n) , 0(1)
    // when we do ^ (XOR) with same number it returns 0 and ^ with 0 gives that number
    // order does not matter
    // so all duplicate with return 0 then the number ^ 0 will return unique number
    // this will only work when array has only one unique
    private static int uniqueWhenRepeatedEvenTimes(int [] ar){
        int ans=0;
        for (int a:ar){
            ans ^=a;
        }
        return ans;
    }

    // complexity == O(n) , 0(1)
    // not completed
    private static int uniqueWhenRepeatedOddTimes(int [] ar){
        int ans=ar[0];
        for (int i = 1; i < ar.length; i++) {
            ans += ar[i];

        }
        return ans %3;
    }

}
