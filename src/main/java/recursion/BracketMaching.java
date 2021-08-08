package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem  == In a given string , return 1 if all the brackets are correctly matched else 0
 *
 * @Complexity == For both sol Time and Space - O(n)
 *
 * @author Saurabh Vaish
 * @Date 21-07-2021
 */
public class BracketMaching {

    public static void main(String[] args) {
//        String str="He((llo))";
//        String str="He()(llo";
        String str="He)((llo)()";
        System.out.println(match(str)?1:0);
    }

    private static boolean match(String str) {
        List<Character> list=new ArrayList<>();
        int index=0;
//        for (int i = 0; i < str.length(); i++) {
//            char ch=str.charAt(i);
//            if(Character.isLetterOrDigit(ch))continue;
//            if(ch=='('){
//                list.add(ch);
//                index++;
//            }
//            else if(ch==')'){
//                if(list.isEmpty()){return false;} // early check if at first we are getting ) means wrong
//                else {
//                    list.remove(index - 1);
//                    index--;
//                }
//            }
//        }
//        return list.isEmpty();
        return _match(str,list,index);
    }

    private static boolean _match(String str, List<Character> list,int index) {
        if(str.length()==0)return list.isEmpty();
        char ch=str.charAt(0);
        if(ch=='('){
            list.add(ch);
            index++;
        }
        else if(ch==')'){
            if(list.isEmpty()){return false;} // early check if at first we are getting ) means wrong
            else {
                list.remove(index - 1);
                index--;
            }
        }
        return _match(str.substring(1), list, index);
    }
}
