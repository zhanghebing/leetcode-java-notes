<p>给定一个整数数组 <code>nums</code>&nbsp;，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> [-2,1,-3,4,-1,2,1,-5,4],
<strong>输出:</strong> 6
<strong>解释:</strong>&nbsp;连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6。
</pre>

<p><strong>进阶:</strong></p>

<p>如果你已经实现复杂度为 O(<em>n</em>) 的解法，尝试使用更为精妙的分治法求解。</p>
<div><div>Related Topics</div><div><li>数组</li><li>分治算法</li><li>动态规划</li></div></div>

## 题解

```java
    class Solution {

        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];

            dp[0] = nums[0];
            int max = nums[0];

            for(int i=1;i<n;i++){
                if(dp[i-1] < 0){
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i-1]+nums[i];
                }
                max = Math.max(dp[i],max);
            }

            return max;
        }

    }
```