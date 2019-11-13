//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package com.leetcode.editor.cn;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

        String[] strs = new String[]{"flower","flow","flight"};

        System.out.println(solution.longestCommonPrefix1(strs));
        System.out.println(solution.longestCommonPrefix2(strs));
        System.out.println(solution.longestCommonPrefix3(strs));
        System.out.println(solution.longestCommonPrefix4(strs));
    }

    class Solution {

        /**
         * 水平扫描法
         *
         * @param strs
         * @return
         */
        public String longestCommonPrefix1(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }

            return prefix;
        }

        /**
         * 优化水平扫描法
         *
         * @param strs
         * @return
         */
        public String longestCommonPrefix2(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }

        /**
         * 算法三：分治
         *
         * @param strs
         * @return
         */
        public String longestCommonPrefix3(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int minLen = Integer.MAX_VALUE;
            for (String str : strs) {
                minLen = Math.min(minLen, str.length());
            }
            int low = 1;
            int high = minLen;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (isCommonPrefix(strs, middle)) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
            return strs[0].substring(0, (low + high) / 2);
        }

        private boolean isCommonPrefix(String[] strs, int len) {
            String str1 = strs[0].substring(0, len);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(str1)) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 算法四：前缀树
         *
         * @param strs
         * @return
         */
        public String longestCommonPrefix4(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            Trie trie = new Trie();
            for (int i = 1; i < strs.length; i++) {
                trie.insert(strs[i]);
            }
            String q = strs[0];
            return trie.searchLongestPrefix(q);
        }
    }

    /**
     * 前缀树
     */
    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                if (!node.containsKey(currChar)) {
                    node.put(currChar, new TrieNode());
                }
                node = node.get(currChar);
            }
            node.setEnd();
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char currChar = prefix.charAt(i);
                if (node.containsKey(currChar)) {
                    node = node.get(currChar);
                } else {
                    return null;
                }
            }

            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.getEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);

            return node != null;
        }

        public String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter) && (node.getSize() == 1) && (!node.getEnd())) {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                } else {
                    return prefix.toString();
                }

            }
            return prefix.toString();
        }

    }


    class TrieNode {

        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        // 非空子节点的数量
        private int size;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
            size++;
        }

        public int getSize() {
            return size;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean getEnd() {
            return isEnd;
        }

    }

}