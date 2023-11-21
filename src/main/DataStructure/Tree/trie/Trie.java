package DataStructure.Tree.trie;



// https://leetcode.cn/problems/implement-trie-prefix-tree/

// 实现 前缀树、字典树

//                 []
//  [a]  [b]  [c] ...   [x]  [y] [z]
 // ...
public class Trie {

    static class TrieNode {
        boolean isWord; // 以当前节点结尾是不是一个 单词
        TrieNode[] children = new TrieNode[26]; // 26个英文字母

        public TrieNode(){}
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true; // 结尾是一个单词
        return;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (node.children[c - 'a'] == null) return false;
            else node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            if (node.children[c - 'a'] == null) return false;
            else node = node.children[c - 'a'];
        }
        return true;
    }


    // 遍历成list
    public void println(){
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null){
                System.out.println((char)(i + 'a'));
            }
        }

    }


    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("apple");
        tree.insert("app");
        tree.insert("appstore");
        tree.println();

        System.out.println(tree.search("apple"));
        System.out.println(tree.search("app"));
        System.out.println(tree.startsWith("apps"));

    }


}
