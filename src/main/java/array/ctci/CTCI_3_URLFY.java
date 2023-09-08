package array.ctci;

/**
 *  Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 *
 * @Author saurabh vaish
 * @Date 30-06-2023
 */
public class CTCI_3_URLFY {

    // comp - O( n )
    // we will use char[] instead of string as strings are immutable and need to form new string every time
    // first we will count white space from string , then will traverse reverse and replace whitespace
    private static void urlify(char [] str, int truelength){
        int countSpace = 0;

        // counting white space in string without trailing [ internal spaces ]
        for(int i=0; i<truelength; i++){
            if(str[i]==' ')countSpace++;
        }

        int index = truelength + countSpace*2;  // multiplying by 2 as we need to replace with %20 which are 3 chars but already one space is there so need 2 more

        if(truelength < str.length) { // if string is having trailing whitespaces, then length will be less as truelength is without trailing spaces
            str[truelength] = '\0';  // indicating all chars are completed only whitespaces left
        }

        // now traverse from last
        for(int i= truelength -1; i>=0;i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';

                index = index - 3; // as 3 indexes utilized
            }else{
                str[index-1] = str[i];
                index--;
            }
        }

    }


    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        urlify(arr, trueLength);
        System.out.println("\"" + new String(arr) + "\"");
    }
}
