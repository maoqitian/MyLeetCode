/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {

        //使用 List 存储链表每个节点 双指针匹配是否回文 
        //时间复杂度 O(n)

        if(head == null || head.next == null) return true;

        List<ListNode> list = new ArrayList<>();

        while(head != null){
             list.add(head);
             head = head.next;
        }

        int start = 0,end = list.size()-1;

        while(start < end){
           if(list.get(start).val == list.get(end).val){
              start++;
              end--;
           }else{
               return false;
           }
        }

        return true;

    }
}
// @lc code=end

