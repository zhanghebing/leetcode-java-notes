package com.leetcode.editor.cn;

/**
 * <pre>
 *    Description： 公共链表类
 * </pre>
 *
 * @author zhanghebing
 * @version 1.0
 * @since 2019/11/13 12:10 下午
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }

    /**
     * 打印链表
     *
     * @param lable
     * @param head
     */
    public static void display(String lable, ListNode head) {

        ListNode start = head;

        StringBuilder stringBuilder = new StringBuilder();

        while(start != null) {
            stringBuilder.append("->");
            stringBuilder.append(start.val);
            start = start.next;
        }

        System.out.println(lable+":"+stringBuilder.substring(2));
    }


    /**
     * 尾插法创建单链表，每次节点都放到链表的末尾
     *
     * @param listNodeHead
     * @param value
     * @return
     */
    public static ListNode createListNodeToTail(ListNode listNodeHead, int value){

        ListNode listNode = new ListNode(value);
        ListNode p=listNodeHead;
        if (listNodeHead == null){
            listNode.next = listNodeHead;
            listNodeHead = listNode;
        } else {
            while (p.next != null){
                p = p.next;
            }

            p.next = listNode;
        }
        return listNodeHead;
    }

    /**
     * 头插法创建单链表，每次节点放到链表的头部
     * @param listNodeHead
     * @param value
     * @return
     */
    public static ListNode createListNodeToHead(ListNode listNodeHead, int value){
        ListNode listNode = new ListNode(value);
        listNode.next = listNodeHead;
        listNodeHead = listNode;
        return listNodeHead;
    }
}
