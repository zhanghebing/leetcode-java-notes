<p>给定一个<strong>没有重复</strong>数字的序列，返回其所有可能的全排列。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> [1,2,3]
<strong>输出:</strong>
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]</pre>
<div><div>Related Topics</div><div><li>回溯算法</li></div></div>

## 题解

```java
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
```