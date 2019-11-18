//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组

package com.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

public class RotateImage {

    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();

        int[][] matrix = {
                 {1,2,3},
                 {4,5,6},
                 {7,8,9}
        };

        solution.rotate(matrix);

        System.out.print(JSON.toJSONString(matrix));
    }


    class Solution {

        public void rotate(int[][] matrix) {
            transpose(matrix);
            reverse(matrix);
        }

        public void transpose(int[][] matrix){
            for(int i=0;i<matrix.length;i++){
                for(int j=i;j<matrix[i].length;j++){
                    int temp = matrix[i][j];

                    matrix[i][j] = matrix[j][i];

                    matrix[j][i] = temp;
                }
            }
        }

        public void reverse(int[][] matrix){

            for(int i=0; i<matrix.length;i++){

                for(int j=0;j<matrix.length /2;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-j-1];
                    matrix[i][matrix.length-j-1] = temp;
                }

            }

        }

    }

}