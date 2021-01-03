/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {

        //两个链表分别记录小于 X 和大于 X 的节点随后拼接 时间复杂度 O(n)

        ListNode dyNode1 = new ListNode(0);
        ListNode dyNode2 = new ListNode(0);

        ListNode node1 = dyNode1;
        ListNode node2 = dyNode2;

        while(head != null){
            if(head.val < x){
               dyNode1.next = head;
               dyNode1 = dyNode1.next;
            }else{
                dyNode2.next = head;
                dyNode2 = dyNode2.next;
            }
            //移动原本链表指针
            head = head.next;
        }
        dyNode2.next = null;
        dyNode1.next = node2.next;
        return node1.next;


    }
}
// @lc code=end

