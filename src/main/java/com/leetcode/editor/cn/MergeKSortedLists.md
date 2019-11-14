<p>合并&nbsp;<em>k&nbsp;</em>个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>
[
&nbsp; 1-&gt;4-&gt;5,
&nbsp; 1-&gt;3-&gt;4,
&nbsp; 2-&gt;6
]
<strong>输出:</strong> 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6</pre>
<div><div>Related Topics</div><div><li>堆</li><li>链表</li><li>分治算法</li></div></div>

## 题解

```java
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            return mergeLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeLists(ListNode[] lists, int low, int high) {
            if (low == high) {
                return lists[low];
            }

            int mid = (low + high) >>> 1;

            ListNode left = mergeLists(lists, low, mid);
            ListNode right = mergeLists(lists, mid + 1, high);

            return mergeTwoList(left, right);
        }

        private ListNode mergeTwoList(ListNode left, ListNode right) {
            if (left == null) {
                return right;
            }

            if (right == null) {
                return left;
            }

            if (left.val < right.val) {
                left.next = mergeTwoList(left.next, right);
                return left;
            } else {
                right.next = mergeTwoList(left, right.next);
                return right;
            }
        }
    }
```