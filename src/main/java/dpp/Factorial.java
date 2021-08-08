package dpp;

/**
 * @author Saurabh Vaish
 * @Date 20-07-2021
 */
public class Factorial {
    public static void main(String[] args) {
        int num=10;
        System.out.println(factorial(num));
    }

    private static long factorial(int num) {
        int[] ar=new int[num+1];
        ar[0]=1;
        for (int i = 1; i <=num; i++) {
            ar[i]=i*ar[i-1];
        }
        return ar[num];
    }
}
