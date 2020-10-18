/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //迭代 快慢指针 时间复杂度 O(n) n 为链表长度
        
        ListNode res =new ListNode(-1);

        res.next = head;
        ListNode pre = res;
        ListNode slow = head;
        ListNode fast = head;

        //找到位置
        while(n!=0){
          fast = fast.next;
          n --;
        }

        //移动快慢指针
        while(fast!=null){
           pre = pre.next;
           slow = slow.next;
           fast = fast.next;
        }

        pre.next = slow.next;

        return res.next;

    }
}
// @lc code=end

