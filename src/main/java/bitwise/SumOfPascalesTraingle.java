package bitwise;

/**
 * @Author saurabh vaish
 * @Date 03-08-2022
 */
public class SumOfPascalesTraingle {

//    1
//    1 1
//    1 2 1
//    1 3 3 1
//    1 4 6 4 1
//    1 5 10 10 5 1

    // program to find sum of the nth row of pascles traingle
    public static void main(String[] args) {

        int n = 5;
        int sum = 1 << (n-1); // when we do left shift it increase 1 and adds 0 from right , thats power of 2
        System.out.println(sum);

    }
}
