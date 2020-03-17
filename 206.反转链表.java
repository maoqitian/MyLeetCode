/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {

         //方法一 迭代 将链表下一个元素next 指向上一个元素

         ListNode newHead = null;

         while(head!=null){
             ListNode next = head.next;
             head.next = newHead;
             newHead = head;
             head = next;
         }
         return newHead;
    }
}
// @lc code=end

