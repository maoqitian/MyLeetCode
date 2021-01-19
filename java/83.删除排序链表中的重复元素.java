/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while(curr != null && curr.next != null){

            if(curr.val == curr.next.val){
               curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }

        return head;

    }
}
// @lc code=end

