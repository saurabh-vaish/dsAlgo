package recursion;

import java.util.HashMap;

/**
 *  find the sum for nth num in fib series
 *
 * @Solution -- sum = fib(num-1) + fib(num-2);
 *
 *   for n=6
 *
 *   if nth < 2 return 1
 *
 *                                    fib(5)                +                        fib(4)
 *                                      |                                              |
 *                      fib(4)           +            fib(3)                fib(3)       +     fib(2)
 *                       |                              |                      |                r 0
 *          fib(3)      +         fib(2)          fib(2) + fib(1)       fib(2) + fib(1)
 *             |                   |              r 0      r 0           r 0     r 0
 *      fib(2) + fib(1)           r 0
 *        r 0      r 0
 *
 *
 * @Complexity =  Time =  O(2^n) as pow(2,n) sol on each level
 *                Space = O(n)
 *
 * @author Saurabh Vaish
 * @Date 18-07-2021
 */
public class Fibonacci {
    public static void main(String[] args) {
        int num = 7; // nth in fibb series

        long nonOptimize = fibonacci(num);  // takes time on 47
        System.out.println("non optimize sol = "+nonOptimize);

        long optimize = fibonacciOptimizeUsingDpp(num,new HashMap<>());
        System.out.println("optimize sol = "+optimize);
    }

    private static long fibonacci(int num) {
        if(num<=2)return 1;
        return fibonacci(num-1)+fibonacci(num-2);
    }

    private static long fibonacciOptimizeUsingDpp(int num, HashMap<Integer, Long> map) {
        if(num<=2) return 1;
        if(map.containsKey(num))return map.get(num);
        else {
            long sum=fibonacciOptimizeUsingDpp(num-1, map)+fibonacciOptimizeUsingDpp(num-2, map);
            map.put(num, sum);
            return sum;
        }
    }
}
