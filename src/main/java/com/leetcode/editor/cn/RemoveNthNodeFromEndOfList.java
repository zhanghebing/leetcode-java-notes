//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListNode listNode1 = null;
        for (Integer value : list) {
            listNode1 = ListNode.createListNodeToTail(listNode1, value);
        }
        ListNode.display("listNode1", listNode1);

        ListNode removedListNode = solution.removeNthFromEnd(listNode1, 2);

        ListNode.display("removedListNode", removedListNode);
    }


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

}