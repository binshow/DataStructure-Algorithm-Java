//package DataStructure.Tree.trie;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author shengbinbin
// * @description:
// * @date 2023/3/48:56 PM
// */
//public class WorkBreak {
//
//    //https://leetcode.cn/problems/word-break/
//
//    //Input: s = "leetcode", wordDict = ["leet","code"]
//    //Output: true
//    //Explanation: Return true because "leetcode" can be segmented as "leet code".
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        Trie tree = new Trie();
//        for(String  word : wordDict) tree.insert(word);
//        return tree.find(s , 0);
//    }
//
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("leet");
//        list.add("code");
//
//        System.out.println(wordBreak("leetcode", list));
//        System.out.println(wordBreak("leetcodeleet", list));
//
//    }
//
//}