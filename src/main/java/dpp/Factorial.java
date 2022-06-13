package dpp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Saurabh Vaish
 * @Date 20-07-2021
 */
public class Factorial {
    public static void main(String[] args) {
        int num=50;
        System.out.println(factorial(num));
        System.out.println(factorialUsingRecursion(num,new HashMap<>()));
        System.out.println(factorialUsingRecursionAndArray(num,init(num)));
    }

    private static long[] init(int num) {
        long ar[] = new long[num+1];
        for (int i = 0; i < num+1; i++) {
            ar[i]=-1;
        }
        return ar;
    }

    // using Tabulation -- bottom up approach as going from base case to n
    // Time comp == O(n) , space = O(n)
    private static long factorial(int num) {
        // O(n) as we are taking array
//        int[] ar=new int[num+1];
//        ar[0]=1;
//        for (int i = 1; i <=num; i++) {
//            ar[i]=i*ar[i-1];
//        }
//        return ar[num];

        // space O(1) as not using any array
        long prev=1;
        for (int i = 1; i <=num ; i++) {
            long cur = i*prev;
            prev=cur;
        }
        return prev;

    }


    // using recursion and memoization
    // Time comp == O(n) , space =O(n) + O(n)  [ stack + map ]
    private static long factorialUsingRecursion(int num, Map<Integer,Long>map) {
        if(num<=1)return 1;
        if(map.containsKey(num))return map.get(num);
        long fa=num*factorialUsingRecursion(num-1,map);
        map.put(num,fa);
        return fa;
    }

    // using 1d array as cache , its not tabulation here we are using array as cache
    private static long factorialUsingRecursionAndArray(int num, long[] ar) {
        if(num<=1)return 1;
        if(ar[num]!=-1)return ar[num];
        long fa=num*factorialUsingRecursionAndArray(num-1,ar);
        ar[num]=fa;
        return fa;
    }
}
