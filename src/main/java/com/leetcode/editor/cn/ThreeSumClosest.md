<p>给定一个包括&nbsp;<em>n</em> 个整数的数组&nbsp;<code>nums</code><em>&nbsp;</em>和 一个目标值&nbsp;<code>target</code>。找出&nbsp;<code>nums</code><em>&nbsp;</em>中的三个整数，使得它们的和与&nbsp;<code>target</code>&nbsp;最接近。返回这三个数的和。假定每组输入只存在唯一答案。</p>

<pre>例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
</pre>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div>

## 题解

```java
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
```