<p>给定一个只包括 <code>&#39;(&#39;</code>，<code>&#39;)&#39;</code>，<code>&#39;{&#39;</code>，<code>&#39;}&#39;</code>，<code>&#39;[&#39;</code>，<code>&#39;]&#39;</code>&nbsp;的字符串，判断字符串是否有效。</p>

<p>有效字符串需满足：</p>

<ol>
	<li>左括号必须用相同类型的右括号闭合。</li>
	<li>左括号必须以正确的顺序闭合。</li>
</ol>

<p>注意空字符串可被认为是有效字符串。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> &quot;()&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> &quot;()[]{}&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre><strong>输入:</strong> &quot;(]&quot;
<strong>输出:</strong> false
</pre>

<p><strong>示例&nbsp;4:</strong></p>

<pre><strong>输入:</strong> &quot;([)]&quot;
<strong>输出:</strong> false
</pre>

<p><strong>示例&nbsp;5:</strong></p>

<pre><strong>输入:</strong> &quot;{[]}&quot;
<strong>输出:</strong> true</pre>
<div><div>Related Topics</div><div><li>栈</li><li>字符串</li></div></div>

## 题解

```java
     class Solution {

        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();

            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');

            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    char topElement = stack.empty() ? '#' : stack.pop();
                    if (topElement != map.get(c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }

    }
```