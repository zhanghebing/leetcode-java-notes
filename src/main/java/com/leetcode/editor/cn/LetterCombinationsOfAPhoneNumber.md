<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。</p>

<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png" style="width: 200px;"></p>

<p><strong>示例:</strong></p>

<pre><strong>输入：</strong>&quot;23&quot;
<strong>输出：</strong>[&quot;ad&quot;, &quot;ae&quot;, &quot;af&quot;, &quot;bd&quot;, &quot;be&quot;, &quot;bf&quot;, &quot;cd&quot;, &quot;ce&quot;, &quot;cf&quot;].
</pre>

<p><strong>说明:</strong><br>
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。</p>
<div><div>Related Topics</div><div><li>字符串</li><li>回溯算法</li></div></div>

## 题解

```java
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
```