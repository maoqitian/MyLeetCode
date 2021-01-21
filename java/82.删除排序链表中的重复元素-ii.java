/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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

        //递归 时间复杂度 O(n)
        //递归结束条件
        if(head == null || head.next == null ) return head;
        
        //逻辑处理 进入下层循环
        ListNode next = head.next;
        if(head.val == next.val){
            //找到不相等为止
            while(next!=null && head.val == next.val){
                next = next.next;
            }
            head = deleteDuplicates(next);
        }else{
            head.next = deleteDuplicates(next);
        }
        //数据 reverse

        return head;


    }
}
// @lc code=end

