//package DataStructure.Tree.trie;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author shengbinbin
// * @description: 前缀树
// * @date 2023/3/47:18 PM
// */
//public class Trie {
//
//    //https://leetcode.cn/problems/implement-trie-prefix-tree/
//
//    static class TrieNode {
//        boolean isWord;
//        TrieNode[] children;
//        public TrieNode(){
//            children = new TrieNode[26];    //26个英文字母
//        }
//    }
//
//    TrieNode root;
//    public Trie(){
//        root = new TrieNode();
//    }
//
//    // 向前缀树中插入一个单词
//    public void insert(String word){
//        TrieNode node = root;
//        for (char c : word.toCharArray()){
//            if (node.children[c - 'a'] == null)  node.children[c - 'a'] = new TrieNode();
//            node = node.children[c - 'a'];
//        }
//        node.isWord = true; //标记当前节点结尾是一个单词
//    }
//
//    public boolean search(String word){
//        TrieNode node = root;
//        for (char c : word.toCharArray()){
//            if (node.children[c - 'a'] == null) return false;
//            else node = node.children[c - 'a'];
//        }
//        return node.isWord;
//    }
//
//    public boolean startsWith(String word){
//        TrieNode node = root;
//        for (char c : word.toCharArray()){
//            if(node.children[c - 'a'] == null) return false;
//            node = node.children[c - 'a'];
//        }
//        return true;
//    }
//
//
//
//
//    // for other question , word 是否可以被多个字典树上面的单词组成
//    public boolean find(String word , int k){
//        if (k == word.length()) return true;
//        TrieNode p = root;
//        while (k < word.length()){
//            char c  = word.charAt(k);
//            p = p.children[c - 'a']; // 注意更新p节点
//            if (p == null) return false;
//            if (p.isWord && find(word , k + 1)) return true;
//            k++;
//        }
//        return false;
//    }
//
//    //v2 加入回溯结合记忆
//
//
//
//
//    public static void main(String[] args) {
//        Trie DataStructure.Tree = new Trie();
//        tree.insert("apple");
//        tree.insert("app");
//        tree.insert("appstore");
//
//        System.out.println(tree.search("apple"));
//        System.out.println(tree.search("app"));
//        System.out.println(tree.startsWith("apps"));
//
//        Map<Integer , Character[]> map = new HashMap<>();
//        Character[] nums = new Character[2];
//        map.put(1 , new Character[]{'a' , 'b'});
//        char a = '1';
//
//        int l1 = a;
//        System.out.println(l1);
//
//    }
//
//
//
//}
