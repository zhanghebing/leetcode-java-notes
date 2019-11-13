//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例:
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
// Related Topics 堆 链表 分治算法

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();

        List<Integer> list = Arrays.asList(2, 3, 4);
        ListNode listNode1 = null;
        for (Integer value : list) {
            listNode1 = ListNode.createListNodeToTail(listNode1, value);
        }
        ListNode.display("listNode1", listNode1);

        List<Integer> list2 = Arrays.asList(4, 5, 6);
        ListNode listNode2 = null;
        for (Integer value : list2) {
            listNode2 = ListNode.createListNodeToTail(listNode2, value);
        }
        ListNode.display("listNode2", listNode2);

        list = Arrays.asList(1, 2, 4);
        ListNode listNode3 = null;
        for (Integer value : list) {
            listNode3 = ListNode.createListNodeToTail(listNode3, value);
        }
        ListNode.display("listNode3", listNode3);

        list2 = Arrays.asList(1, 3, 4);
        ListNode listNode4 = null;
        for (Integer value : list2) {
            listNode4 = ListNode.createListNodeToTail(listNode4, value);
        }
        ListNode.display("listNode4", listNode4);

        ListNode[] lists = new ListNode[]{listNode1, listNode3, listNode2, listNode4};

        ListNode sortList = solution.mergeKLists(lists);
        ListNode.display("sortList", sortList);
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

}