//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

package com.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(JSON.toJSONString(solution.searchRange(nums,target)));
    }


    class Solution {

        public int[] searchRange(int[] nums, int target) {
            int[] res = {-1,-1};

            for(int i=0;i<nums.length;i++){
                if(target == nums[i]){
                    res[0] = i;
                    break;
                }
            }

            if(res[0]==-1){
                return res;
            }

            for(int j=nums.length-1;j>=0;j--){
                if(target == nums[j]){
                    res[1] = j;
                    break;
                }
            }

            return res;
        }

    }

}