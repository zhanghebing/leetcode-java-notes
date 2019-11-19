//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class RotateList {

    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListNode listNode1 = null;
        for (Integer value : list) {
            listNode1 = ListNode.createListNodeToTail(listNode1, value);
        }
        ListNode.display("listNode1", listNode1);

        ListNode rotateRight = solution.rotateRight(listNode1, 2);
        ListNode.display("rotateRight", rotateRight);
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

}