//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组

package com.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix =
                {
                        {1, 2, 3 },
                        {4, 5, 6 },
                        {7, 8, 9 }
                };

        List<Integer> list = solution.spiralOrder(matrix);

        System.out.println(JSON.toJSONString(list));
    }


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

}