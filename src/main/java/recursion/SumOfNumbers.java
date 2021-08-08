package recursion;

/**
 *  sum of elements using recursion
 *
 * @Solution -- if ar is null or 0 return 0 and in this sol we are using index so if ar length == index return 0
 *
 *  call -> ar[0] + sum(ar-1)
 *
 *  1 + sum([5,7,-2]) => 1 + 10 =>return 11 (final ans)
 *            |
 *      5 + sum([7,-2]) => 5 + 5 => return 10;
 *            |
 *          7 + sum([-2]) => 7 + (-2) => return 5;
 *                  |
 *              -2 + sum([]) => -2 + 0 => return -2;
 *
 *
 * @Complexity == Time - O(n) as we are not using any other loops
 *                Space - O(n) no extra calls on stack
 *
 *
 * @author Saurabh Vaish
 * @Date 18-07-2021
 */
public class SumOfNumbers {
    public static void main(String[] args) {
        int ar[]={1,5,7,-2};
        int sum = sum(ar,0);
        System.out.println(sum);
    }

    private static int sum(int[] ar,int index) {
        if(ar==null)return 0;
        if(ar.length==index || ar.length==0)return 0;
        return ar[index]+sum(ar,index+1);
    }
}
