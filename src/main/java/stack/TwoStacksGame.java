package stack;

import java.util.*;

/**
 * @Author saurabh vaish
 * @Date 12-02-2023
 *
 * @Link = https://www.hackerrank.com/challenges/game-of-two-stacks/problem
 *
 */
public class TwoStacksGame {

    public static void main(String[] args) {
        int m = 10;
        List<Integer> a = new ArrayList<>(Arrays.asList(4,2,4,6,1));
        List<Integer> b = new ArrayList<>(Arrays.asList(2,1,8,5));

        int ans =twoStack(m,  a.toArray(),  b.toArray(),0,0) - 1; // -1 bcs we are terminating condition when sum is becoming large
        System.out.println(ans);
    }

    // chose element one by one and take max of there count
    public static int twoStack(int maxSum, Object[] a, Object[] b,int sumSoFar,int count) {
        if(sumSoFar>maxSum)return count;
        if(a.length==0 || b.length==0)return count;

        int first = twoStack(maxSum,Arrays.copyOfRange(a,1,a.length),b,sumSoFar+(int)a[0],count+1);
        int second = twoStack(maxSum,a,Arrays.copyOfRange(b,1,b.length),sumSoFar+(int)b[0],count+1);

        return Math.max(first,second);

    }
}
