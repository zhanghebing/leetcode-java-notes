//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

package com.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();

        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(nums, 1));
    }


    class Solution {

        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int ans = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < nums.length; i++) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];

                    if (Math.abs(target - sum) < Math.abs(target - ans)) {
                        ans = sum;
                    }

                    if (sum > target) {
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        return ans;
                    }
                }
            }

            return ans;
        }

    }

}