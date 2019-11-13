//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();

        List<Integer> list = Arrays.asList(2,4,3,5);
        ListNode listNode1 = null;
        for (Integer value : list){
            listNode1 = ListNode.createListNodeToTail(listNode1,value);
        }
        ListNode.display("listNode1",listNode1);

        ListNode swapListNode = solution.swapPairs(listNode1);
        ListNode.display("swapListNode",swapListNode);
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

}