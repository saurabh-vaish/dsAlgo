package dpp;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement = You have been given a number of stairs. Initially, you are at the 0th stair, and you need to reach the Nth stair.
 *                      Each time you can either climb one step or two steps. You are supposed to return the number of distinct ways in which you can climb from the 0th step to Nth step.
 *
 * Constraints
 * 1 <= T <= 100
 * 0 <= N <= 10^18
 *
 * Where 'T' is the number of test cases, and 'N' is the number of stairs.
 *
 * @Author saurabh vaish
 * @Date 12-05-2022
 */
public class CountPossibleWaysForStairs {
    public static void main(String[] args) {
        int n=64;
        System.out.println(countWaysRecursion(n,new HashMap<>()));
        System.out.println(countWaysTabulation(n));
    }


    // time - O(n)
    // space - O(n) + O(n) // stack + map
    public static int countWaysRecursion(int n, Map<Integer,Integer> map){
        // since we can climb either one or two stairs at a time
        if(n==0)return 1; // when no stairs
        if(n==1)return 1; // when only one stairs
        if(map.containsKey(n))return map.get(n);
        int one = countWaysRecursion(n-1,map); // one step
        int two = countWaysRecursion(n-2,map); // two steps

        map.put(n,one+two);

        return one + two;
    }

    // time - O(n)
    // space - O(1)
    public static long countWaysTabulation(int n){
        // since we can climb either one or two stairs at a time
       int first=   1;
       int second = 1;
        for (int i = 2; i <= n; i++) {
            int c=first + second;
            first=second;
            second=c;
        }
        return second;
    }

}
