//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package com.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1,2,3};
        System.out.println(JSON.toJSONString(solution.permute(nums)));
    }


    class Solution {

        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> outputList = new ArrayList<>();

            List<Integer> numsList = new ArrayList<>();

            for(int num : nums){
                numsList.add(num);
            }

            backtrid(nums.length,numsList,outputList,0);
            return outputList;
        }

        public void backtrid(int n,List<Integer> numsList,List<List<Integer>> outputList , int first){
            if(n == first){
                outputList.add(new ArrayList<>(numsList));
            }

            for(int i=first;i<n;i++){
                Collections.swap(numsList,first,i);

                backtrid(n,numsList,outputList,first+1);

                Collections.swap(numsList,first,i);
            }
        }

    }

}