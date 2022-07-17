package design.trie_tree;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/implement-trieByArray-prefix-tree/
 * @date 2022/7/1111:14 PM
 */
public class implement_trie_tree {

    // 实现前缀树: 用于快速查询某个字符串、字符前缀 是否存在的数据结构
    // 其核心是使用「边」来代表有无字符，使用「点」来记录是否为「单词结尾」以及「其后续字符串的字符是什么」。
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488490&idx=1&sn=db2998cb0e5f08684ee1b6009b974089&scene=21#wechat_redirect

    // 使用二维数组来实现前缀树
    // 时间复杂度：取决于入参字符串的长度，复杂度为 O （len
    // 空间复杂度：二维数组高度为n，字符集大小为k，O nk
    static class TrieByArray {
        int N = 8;
        int[][] trieByArray;
        int[] count;     //使用  数组记录某个格子被「被标记为结尾的次数」
        int index;       // 自增记录我们到底用了多少个格子

        public TrieByArray(){
            trieByArray = new int[N][26];
            count = new int[N];
            index = 0;
        }

        public void insert(String s){
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trieByArray[p][u] == 0) trieByArray[p][u] = ++index;
                p = trieByArray[p][u];
            }
            printArray(trieByArray);
            count[p]++;
        }

        public boolean search(String s){
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trieByArray[p][u] == 0) return false;
                p = trieByArray[p][u];
            }
            return count[p] != 0;
        }

        public boolean startsWith(String s){
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trieByArray[p][u] == 0) return false;
                p = trieByArray[p][u];
            }
            return true;
        }

    }


    // 建立 TrieNode 节点
    static class Trie{
        class TrieNode{
            boolean end;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String s){
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.children[u] == null) p.children[u] = new TrieNode();
                p = p.children[u];
            }
            p.end = true;
        }

        public boolean search(String s){
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.children[u] == null) return false;
                p = p.children[u];
            }
            return p.end;
        }

        public boolean startWith(String s){
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.children[u] == null) return false;
                p = p.children[u];
            }
            return true;
        }



    }


    public static void main(String[] args) {
        TrieByArray trieByArray = new TrieByArray();
        trieByArray.insert("apple");
        System.out.println(trieByArray.search("apple")); // true
        System.out.println(trieByArray.search("app"));  // false
        System.out.println(trieByArray.startsWith("app")); // true
        trieByArray.insert("app");
        System.out.println(trieByArray.search("app")); // true

    }


    public static void printArray(int[][] nums){
        for(int [] num : nums){
            System.out.println(Arrays.toString(num));
        }
        System.out.println();
    }


}
