//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

package com.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();

        List<String> letters = solution.letterCombinations("23");

        System.out.println(JSON.toJSONString(letters));

    }


    class Solution {

        Map<Character, String> phoneNumber = new HashMap<>();
        List<String> list = new ArrayList<>();

        public List<String> letterCombinations(String digits) {

            phoneNumber.put('2', "abc");
            phoneNumber.put('3', "def");
            phoneNumber.put('4', "ghi");
            phoneNumber.put('5', "jkl");
            phoneNumber.put('6', "mno");
            phoneNumber.put('7', "pqrs");
            phoneNumber.put('8', "tuv");
            phoneNumber.put('9', "wxyz");

            if (digits == null || "".equals(digits)) {
                return new ArrayList<>();
            }

            dfs(digits, 0, "");

            return list;
        }

        public void dfs(String digits, int index, String ans) {
            if (index == digits.length()) {
                list.add(ans);
                return;
            }

            Character c = digits.charAt(index);
            String letter = phoneNumber.get(c);

            for (int i = 0; i < letter.length(); i++) {
                dfs(digits, index + 1, ans + letter.charAt(i));
            }
        }

    }

}