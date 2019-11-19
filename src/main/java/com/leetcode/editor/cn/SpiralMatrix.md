<p>给定一个包含&nbsp;<em>m</em> x <em>n</em>&nbsp;个元素的矩阵（<em>m</em> 行, <em>n</em> 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong>
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
<strong>输出:</strong> [1,2,3,6,9,8,7,4,5]
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong>
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
<strong>输出:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
</pre>
<div><div>Related Topics</div><div><li>数组</li></div></div>

## 题解

```java
    class Solution {

        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> list = new ArrayList<>();

            if(matrix == null || matrix.length == 0){
                return list;
            }

            int row = matrix.length-1;
            int col = matrix[0].length-1;

            int r = 0;
            int c = 0;

            while(r <= row && c <= col){
                for(int i = c;i<=col; i++){
                    list.add(matrix[r][i]);
                }

                for(int i = r+1;i<=row;i++){
                    list.add(matrix[i][col]);
                }

                if(r < row && c < col){
                    for(int i=col-1;i > c ;i--){
                        list.add(matrix[row][i]);
                    }

                    for(int i= row ; i > r ; i--){
                        list.add(matrix[i][c]);
                    }
                }

                r++;
                row--;
                c++;
                col--;
            }

            return list;
        }

    }
```