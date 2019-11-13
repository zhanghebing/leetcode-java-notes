//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

        List<Integer> list = Arrays.asList(2,4,3);
        ListNode listNode1 = null;
        for (Integer value : list){
            listNode1 = ListNode.createListNodeToTail(listNode1,value);
        }
        ListNode.display("listNode1",listNode1);

        List<Integer> list2 = Arrays.asList(5,6,4);
        ListNode listNode2 = null;
        for (Integer value : list2){
            listNode2 = ListNode.createListNodeToTail(listNode2,value);
        }
        ListNode.display("listNode2",listNode2);

        ListNode listNode3 = solution.addTwoNumbers(listNode1,listNode2);
        ListNode.display("listNode3",listNode3);
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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (l1 != null){
                    l1 = l1.next;
                }
                if (l2 != null){
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }
}