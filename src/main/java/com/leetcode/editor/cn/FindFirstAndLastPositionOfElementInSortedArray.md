<p>给定一个按照升序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。找出给定目标值在数组中的开始位置和结束位置。</p>

<p>你的算法时间复杂度必须是&nbsp;<em>O</em>(log <em>n</em>) 级别。</p>

<p>如果数组中不存在目标值，返回&nbsp;<code>[-1, -1]</code>。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 8
<strong>输出:</strong> [3,4]</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 6
<strong>输出:</strong> [-1,-1]</pre>
<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div>

## 题解

```java
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
```