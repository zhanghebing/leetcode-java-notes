<p>给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> 123
<strong>输出:</strong> 321
</pre>

<p><strong>&nbsp;示例 2:</strong></p>

<pre><strong>输入:</strong> -123
<strong>输出:</strong> -321
</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入:</strong> 120
<strong>输出:</strong> 21
</pre>

<p><strong>注意:</strong></p>

<p>假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为&nbsp;[&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。</p>
<div><div>Related Topics</div><div><li>数学</li></div></div>

## 题解

```java
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;

                if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) {
                    return 0;
                }
                rev = rev * 10 + pop;
            }
            return rev;
        }
```