package haffmanCoding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Saurabh Vaish
 * @Date 26-06-2021
 */

class HuffmanNode {
    char value;
    int freq;
    HuffmanNode right;
    HuffmanNode left;

    public HuffmanNode(){
        this.freq=0;
        this.right=null;
        this.left=null;
    }
}

public class HuffmanCode {

    private final static char SUMCONSTANT='_';

    private static String fileString;

    private static HuffmanNode rootNode;

    public static void setFileString(String fileString) {
        if(fileString.length()<3){
            System.out.println("Minimum length of string at least 3 chars ");
            return;
        }
        fileString = fileString;
    }

    public String getFileString(){
        return this.fileString;
    }

    public static List<Byte> getEncodedString(String str){
        setFileString(str);
        char[] chars = str.toCharArray();

        Map<Character,Integer> charFreq = getCharFrequency(chars);  // step 1

        List<HuffmanNode> orderedList =  prioritizeCharsBasedOnFreq(charFreq);  // step 2

        rootNode = getHaffmanCodesOfText(orderedList); // step 3

        Map<Character,Byte[]> haffmanCodeMap = new HashMap<>();

        convertTextToCode(rootNode, "", haffmanCodeMap);

        System.out.println("string == "+str);

        String codedString = getHaffmanCodedString(chars,haffmanCodeMap);

        System.out.println("coded string =="+codedString);

        List<Byte> list = new ArrayList<>();

        for(char ch:codedString.toCharArray()){
            list.add(Byte.valueOf(ch+""));
        }

        return list;
    }

    public String decodeString(List<Byte> list){

        String deCodedString = decodeHaffmanCodedString(list,rootNode);

        System.out.println("deCoded string=="+deCodedString);

        return deCodedString;
    }

    // method to count frequency of each char
    private static Map<Character, Integer> getCharFrequency(char[] chars) {
        Map<Character,Integer> map = new HashMap<>();
        for (char ch:chars){
            int v=map.getOrDefault(ch, 0);
            map.put(ch, ++v);
        }
        return map;
    }

    // method to get sorted map based on char freq order [ min to max]
    private static List<HuffmanNode> prioritizeCharsBasedOnFreq(Map<Character, Integer> charFreq) {
        return charFreq.entrySet().stream().sorted(Map.Entry.comparingByValue())  // sorting map based on freq
                .map(map->{                                     // mapping node
                    HuffmanNode node = new HuffmanNode();
                    node.value=map.getKey();
                    node.freq=map.getValue();
                    return node;
                })
                .collect(Collectors.toList());
    }


    private static HuffmanNode getHaffmanCodesOfText(List<HuffmanNode> nodePriorityQueue) {
        HuffmanNode root =null;
        for (int i = 1; i < nodePriorityQueue.size(); i++) {
            HuffmanNode previousNode = nodePriorityQueue.get(i-1);  // previous node
            HuffmanNode currentNode = nodePriorityQueue.get(i);     //  current node

            HuffmanNode node = new HuffmanNode();
            node.freq= previousNode.freq + currentNode.freq;  // getting sum of two least freq
            node.value=SUMCONSTANT;  //marking this node as sum node

            // min node to left and max to right
            if(currentNode.freq<previousNode.freq){
                node.left=currentNode;
                node.right=previousNode;
            }else {
                node.left=previousNode;
                node.right=currentNode;
            }

            root=node; // assigning this node to root , as we are forming tree [ bottom to top ] ,so last node will be root one
            nodePriorityQueue.remove(i-1); // removing previous node
            nodePriorityQueue.add(i,root);  // adding sum node in place of previous
            // as again we need to add this with next node
        }

        return root;
    }


    public static void convertTextToCode(HuffmanNode root, String s, Map<Character, Byte[]> codeMap) {
        if (root.left == null && root.right == null && root.value!=SUMCONSTANT) {

            System.out.println(root.value + "   |  " + s);
            Byte[] ar = new Byte[s.length()];
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                ar[i]=Byte.valueOf(ch[i]+"");
            }
            codeMap.put(root.value, ar);
            return;
        }
        convertTextToCode(root.left, s + "0", codeMap);
        convertTextToCode(root.right, s + "1", codeMap);
    }


    private static String getHaffmanCodedString(char[] chars, Map<Character, Byte[]> haffmanCodeMap) {
        StringBuilder str= new StringBuilder();
        for (char ch:chars){
            Arrays.stream(haffmanCodeMap.get(ch)).forEach(str::append);
        }
        return str.toString();
    }


    private static String decodeHaffmanCodedString(List<Byte> list, HuffmanNode rootNode) {
        StringBuffer str = new StringBuffer();
        HuffmanNode temp=rootNode;
        for(byte l:list){
            temp=l==0?temp.left:temp.right;
            if(temp.left==null && temp.right==null){
                str.append(temp.value);
                temp=rootNode;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        HuffmanCode code = new HuffmanCode();
        List<Byte> list = getEncodedString("bcaadddccacacac");

        String decode = decodeHaffmanCodedString(list, rootNode);

        System.out.println("decoded ==" +decode);

    }


}
