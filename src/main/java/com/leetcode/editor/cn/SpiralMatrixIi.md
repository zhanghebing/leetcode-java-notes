<p>给定一个正整数&nbsp;<em>n</em>，生成一个包含 1 到&nbsp;<em>n</em><sup>2</sup>&nbsp;所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> 3
<strong>输出:</strong>
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]</pre>
<div><div>Related Topics</div><div><li>数组</li></div></div>


## 题解

```java
    class Solution {

        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];

            int num = 1;

            int left = 0, right = n - 1;

            while (left <= right) {
                if (left == right) {
                    matrix[left][right] = num++;
                }

                for (int i = left; i < right; i++) {
                    matrix[left][i] = num++;
                }

                for (int i = left; i < right; i++) {
                    matrix[i][right] = num++;
                }

                for (int i = right; i > left; i--) {
                    matrix[right][i] = num++;
                }

                for (int i = right; i > left; i--) {
                    matrix[i][left] = num++;
                }
                left++;
                right--;
            }

            return matrix;
        }

    }
```