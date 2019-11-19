<p>给定一个链表，旋转链表，将链表每个节点向右移动&nbsp;<em>k&nbsp;</em>个位置，其中&nbsp;<em>k&nbsp;</em>是非负数。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL, k = 2
<strong>输出:</strong> 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
<strong>解释:</strong>
向右旋转 1 步: 5-&gt;1-&gt;2-&gt;3-&gt;4-&gt;NULL
向右旋转 2 步: 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> 0-&gt;1-&gt;2-&gt;NULL, k = 4
<strong>输出:</strong> <code>2-&gt;0-&gt;1-&gt;NULL</code>
<strong>解释:</strong>
向右旋转 1 步: 2-&gt;0-&gt;1-&gt;NULL
向右旋转 2 步: 1-&gt;2-&gt;0-&gt;NULL
向右旋转 3 步:&nbsp;<code>0-&gt;1-&gt;2-&gt;NULL</code>
向右旋转 4 步:&nbsp;<code>2-&gt;0-&gt;1-&gt;NULL</code></pre>
<div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div>

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

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }

            int len = getListNodeLength(head);

            k = k % len;

            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            fast.next = head;
            head = slow.next;
            slow.next = null;
            return head;
        }

        public int getListNodeLength(ListNode head) {
            int len = 1;
            ListNode temp = head;
            while (temp != null && temp.next != null) {
                temp = temp.next;
                len++;
            }

            return len;
        }

    }
```