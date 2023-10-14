package data_structure;

import java.util.LinkedList;

/**
 * 前缀树
 */
public class Trie {
    private final TrieNode root;                // 根节点
    private final static Character EOF = '\0';  // 结束符

    public Trie() {
        root = new TrieNode('#');
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (Character c : word.toCharArray()) {
            TrieNode child = null;
            if ((child = temp.findChildren(c)) != null) {
                temp = child;
            } else {
                temp = temp.addChild(c);
            }
        }

        if (temp.firstChild() == null || temp.firstChild().val != EOF) {
            temp.addEOF();
        }
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode temp = root;
        for (Character c : word.toCharArray()) {
            TrieNode child = null;
            if ((child = temp.findChildren(c)) != null) {
                temp = child;
            } else {
                return false;
            }
        }
        return temp.firstChild() == null || temp.firstChild().val == EOF;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode temp = root;
        for (Character c : prefix.toCharArray()) {
            TrieNode child = null;
            if ((child = temp.findChildren(c)) != null) {
                temp = child;
            } else {
                return false;
            }
        }
        return true;
    }

    static class TrieNode {
        char val;
        LinkedList<TrieNode> children;
        public TrieNode(Character c) {
            this.val = c;
            children = new LinkedList<>();
        }
        public TrieNode findChildren(Character target) {
            for (TrieNode child : children) {
                if (child.val == target) {
                    return child;
                }
            }
            return null;
        }

        public TrieNode addChild(Character target) {
            children.add(new TrieNode(target));
            return children.getLast();
        }

        public TrieNode firstChild() {
            return children.size() == 0 ? null : children.getFirst();
        }

        /**
         *  标志着该节点是一个完整的字符串
         *  比如插入: "abc" 则会在children中插入 "EOF"
         */
        public void addEOF() {
            children.add(0, new TrieNode(EOF));
        }
    }
}


