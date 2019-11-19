//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组

package com.leetcode.editor.cn;

public class SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }


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

}