package bitwise;

/**
 * @Author saurabh vaish
 * @Date 06-08-2022
 */
public class CheckNumbersHaveSameSign {

    // program to check if two numbers have same sign
    // since negative number has 1 as msb , so if both numbers msb is same then they have same sign
    // using ^ operator we can check as if msb are same it will make then 0
    // so by checking if its greater than zero means on of msb is 1 so numbers dont have same sign
    public static void main(String[] args) {
        int a=100; int b =  -5;
        String s= (a ^ b) < 0 ? "Signs are opposite" : "Signs are not opposite";

        System.out.println(s);

    }
}
