<p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。</p>

<p><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际的进行节点交换。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre>给定 <code>1-&gt;2-&gt;3-&gt;4</code>, 你应该返回 <code>2-&gt;1-&gt;4-&gt;3</code>.
</pre>
<div><div>Related Topics</div><div><li>链表</li></div></div>

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

        public ListNode swapPairs(ListNode head) {
            if(head == null){
                return head;
            }

            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode temp = pre;

            while(temp.next != null && temp.next.next != null){
                ListNode start = temp.next;
                ListNode end = temp.next.next;

                temp.next = end;
                start.next = end.next;
                end.next = start;
                temp = start;
            }
            return pre.next;
        }
    }
```