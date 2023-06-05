package org.hinson.leetcode;

import java.util.List;

/**
 * trie 树
 */
public class Question648 {

    class TrieNode {
        boolean isLeaf;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        add(dictionary);

        StringBuilder sb = new StringBuilder();

        for (String word : sentence.split(" ")) {
            int idx = search(word);
            String str = idx > 0 ? word.substring(0, idx) : word;
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private int search(String s) {
        TrieNode node = root;
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null && !node.isLeaf) {
                return 0;
            }
            if (node.isLeaf) {
                return idx;
            }
            idx++;
            node = node.children[c - 'a'];
        }
        return idx;
    }

    private void add(List<String> dictionary) {
        for (String d : dictionary) {
            TrieNode node = root;
            for (char c : d.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isLeaf = true;
        }
    }
}
