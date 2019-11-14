<p>给定一个链表，删除链表的倒数第&nbsp;<em>n&nbsp;</em>个节点，并且返回链表的头结点。</p>

<p><strong>示例：</strong></p>

<pre>给定一个链表: <strong>1-&gt;2-&gt;3-&gt;4-&gt;5</strong>, 和 <strong><em>n</em> = 2</strong>.

当删除了倒数第二个节点后，链表变为 <strong>1-&gt;2-&gt;3-&gt;5</strong>.
</pre>

<p><strong>说明：</strong></p>

<p>给定的 <em>n</em>&nbsp;保证是有效的。</p>

<p><strong>进阶：</strong></p>

<p>你能尝试使用一趟扫描实现吗？</p>
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

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            int length = 0;
            ListNode first = head;
            while (first != null) {
                first = first.next;
                length++;
            }

            length -= n;
            first = dummy;
            while (length > 0) {
                length--;
                first = first.next;
            }

            first.next = first.next.next;

            return dummy.next;
        }

    }
```