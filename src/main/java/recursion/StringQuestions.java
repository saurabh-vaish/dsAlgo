package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Saurabh Vaish
 */
public class StringQuestions {
    

    public static void main(String[] args) {
        StringQuestions questions = new StringQuestions();

        // System.out.println(questions.skipChar("ghhscaftta"));
        // System.out.println(questions.skipSring("gggapplecclett"));
        // System.out.println(questions.skipSringInMiddle("gggapplecclett"));

        System.out.println("----- all subsequences -----");
        questions.stringSubSet("", "abc");
        
        System.out.println("----- all subsequences as array -----");
        List<String> result = new ArrayList<String>();
        questions.stringSubSetArray("", "abc", result);
        System.out.println(result);

        System.out.println("----- all subsequences as returning array -----");
        List<String> resultList = questions.stringSubSetArrayReturn("", "abc");
        System.out.println(resultList);
        
        System.out.println("----- all subsequences as returning array of subsquences -----");
        List<List<String>> resultArray = new ArrayList<>();
        questions.stringSubSetArrayReturnType2("", "abc",resultArray);
        System.out.println(resultArray);
    }
    

    /**
     * @Problem == Skip the character in given string
     * @Complexity = O(n)  as at a time only one recursion is called until length of string 
     * @param str
     * @return
     */
    public String skipChar(String str) {
        if (str.length() == 0) {
            return "";
        }
        char curr = str.charAt(0);
        if (curr == 'a') {
           return skipChar(str.substring(1)); // if char mathces then skip it by removing from string 
        } else {
           return curr + skipChar(str.substring(1)); // if char does not match then add char and remove one from old
        }
    }

    /**
     * @Problem == Skip the string in given string
     * @Complexity = O(n)  as at a time only one recursion is called until length of string 
     * @param str
     * @return
     */
    public String skipSring(String str) {
        if (str.length() == 0) {
            return "";
        }
        char curr = str.charAt(0);
        if (str.startsWith("apple")) {
            return skipSring(str.substring(5)); // if string starts with given string then skip it by removing that no of chars from string
        } else {
            return curr + skipSring(str.substring(1)); // if string does not match then add char and remove one from old
        }
    }
    
    /**
     * @Problem == Skip the string in given string but not the requied one
     * @Complexity = O(n)  as at a time only one recursion is called until length of string 
     * @param str
     * @return
     */
    public String skipSringInMiddle(String str) {
        if (str.length() == 0) {
            return "";
        }
        char curr = str.charAt(0);
        if (str.startsWith("app") && !str.startsWith("apple")) {
            return skipSring(str.substring(3)); // if string starts with given string then skip it by removing that no of chars from string
        } else {
            return curr + skipSring(str.substring(1)); // if string does not match then add char and remove one from old
        }
    }
    


    // =================================== string subset questions ==========================================================


    /***
     * @Problem == Given a string find all the subsequences of string
     * @param sub
     * @param str
     */
    public void stringSubSet(String sub, String str) {
        if (str.length() == 0) {
            System.out.println(sub);
            return;
        }
        char curr = str.charAt(0);
        stringSubSet(sub + curr, str.substring(1)); // taking the element
        stringSubSet(sub, str.substring(1)); // not taking the element
    }
    

    public void stringSubSetArray(String sub, String str, List<String> list) {
        if (str.length() == 0) {
            list.add(sub);
            return;
        }
        char curr = str.charAt(0);
        stringSubSetArray(sub + curr, str.substring(1),list); // taking the element
        stringSubSetArray(sub, str.substring(1),list); // not taking the element
    }
    
    public List<String> stringSubSetArrayReturn(String sub, String str) {
        if (str.length() == 0) {
            List<String> result = new ArrayList<>();
            result.add(sub);
            return result;
        }
        char curr = str.charAt(0);
        List<String> left = stringSubSetArrayReturn(sub + curr, str.substring(1)); // taking the element
        List<String> right = stringSubSetArrayReturn(sub, str.substring(1)); // not taking the element

        left.addAll(right);
        return left;
    }

    public List<List<String>> stringSubSetArrayReturnType2(String sub, String str,List<List<String>> result) {
        if (str.length() == 0) {
            List<String> list = new ArrayList<String>(); // creating new list everytime
            list.add(sub);
            result.add(list);
            return result;
        }
        char curr = str.charAt(0);
        stringSubSetArrayReturnType2(sub + curr, str.substring(1),result);  // taking the element
        stringSubSetArrayReturnType2(sub, str.substring(1), result); // not taking the element
        
        return result;
    }

}
