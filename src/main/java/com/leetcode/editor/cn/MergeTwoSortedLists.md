<p>将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>1-&gt;2-&gt;4, 1-&gt;3-&gt;4
<strong>输出：</strong>1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4
</pre>
<div><div>Related Topics</div><div><li>链表</li></div></div>

## 题解

```java
    class Solution {

        /**
         * 递归
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists1(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists1(l1, l2.next);
                return l2;
            }
        }

        /**
         * 非递归
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            ListNode preHead = new ListNode(-1);

            ListNode current = preHead;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }

            if (l1 == null) {
                current.next = l2;
            } else {
                current.next = l1;
            }

            return preHead.next;
        }

    }
```