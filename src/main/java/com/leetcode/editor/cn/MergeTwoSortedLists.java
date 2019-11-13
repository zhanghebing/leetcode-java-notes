//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();

        List<Integer> list = Arrays.asList(1, 2, 4);
        ListNode listNode1 = null;
        for (Integer value : list) {
            listNode1 = ListNode.createListNodeToTail(listNode1, value);
        }
        ListNode.display("listNode1", listNode1);

        List<Integer> list2 = Arrays.asList(1, 3, 4);
        ListNode listNode2 = null;
        for (Integer value : list2) {
            listNode2 = ListNode.createListNodeToTail(listNode2, value);
        }
        ListNode.display("listNode2", listNode2);

        // ListNode listNode3 = solution.mergeTwoLists1(listNode1, listNode2);
        // ListNode.display("listNode3", listNode3);

        ListNode listNode4 = solution.mergeTwoLists2(listNode1, listNode2);
        ListNode.display("listNode4", listNode4);
    }

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

}