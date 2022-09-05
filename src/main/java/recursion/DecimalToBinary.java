package recursion;

/**
 * @Author saurabh vaish
 * @Date 14-08-2022
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println(binary(27));
    }

    public static int binary(int num){
        if(num==0)return 0;
        return num%2 + 10*binary(num/2);
    }
}
