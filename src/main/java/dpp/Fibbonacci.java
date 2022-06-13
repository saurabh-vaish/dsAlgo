package dpp;

import java.util.HashMap;

/**
 *
 *
 *
 * @author Saurabh Vaish
 * @Date 07-07-2021
 */
public class Fibbonacci {

    private static long[] init( long[] ar){
        for (int i = 0; i < 100; i++) {
            ar[i]=-1;
        }
        return ar;
    }

    public long fibboUsingRecursion(int n){
        if(n<=2)return 1;
        return fibboUsingRecursion(n-1)+fibboUsingRecursion(n-2);
    }

    // top down approach
    public  long fibboUsingDppMemoization(int n,long[] ar){
        if(n<=1)return n;
        if(ar[n]!=-1)return ar[n];
        ar[n]=fibboUsingDppMemoization(n-1, ar)+fibboUsingDppMemoization(n-2, ar);
        return ar[n];
    }

    // bottom up  approach
    // time - O(n) , space - O(1)
    public  long fibboUsingDppTabulation(int n){
        /* // space O(n)
        int ar[] = new int[n+2]; // considering max size as 100
//        ar = this.init(ar);
        ar[0]=ar[1]=1;
        for (int i = 2; i <n; i++) {
            ar[i]=ar[i-1]+ar[i-2];
        }
        return ar[n-1];
        */

        // space optimized - space - O(1) as no array is being used
        long prev=0;
        long prev2=1;
        for (int i = 2; i <=n ; i++) {
            long c = prev+prev2;
            prev=prev2;
            prev2=c;
        }
        return prev2;

    }

    public  long fibboUsingDppHashmap(int n, HashMap<Integer,Long> map){
        if(n<=1)return n;
        if(map.containsKey(n))return map.get(n);
        else {
            long r = fibboUsingDppHashmap(n-1, map) + fibboUsingDppHashmap(n-2, map);
            map.put(n,r);
            return r;
        }
    }

    public static void main(String[] args) {
        Fibbonacci fib = new Fibbonacci();
        int n=20;
//        long t1 = System.currentTimeMillis();
//        System.out.println("recusion = "+fib.fibboUsingRecursion(n));
//        long t2 = System.currentTimeMillis();
//        System.out.println("total time = "+(t2-t1));
        long t3 = System.currentTimeMillis();
        System.out.println("memoization = "+fib.fibboUsingDppMemoization(n,init(new long[100])));
        long t4 = System.currentTimeMillis();
        System.out.println("total time = "+(t4-t3));
        long t5 = System.currentTimeMillis();
        System.out.println("tabulization = "+fib.fibboUsingDppTabulation(n));
        long t6 = System.currentTimeMillis();
        System.out.println("total time = "+(t6-t5));
        long t7 = System.currentTimeMillis();
        System.out.println("hashmap = "+fib.fibboUsingDppHashmap(n,new HashMap<>()));
        long t8 = System.currentTimeMillis();
        System.out.println("total time = "+(t8-t7));
    }
}
