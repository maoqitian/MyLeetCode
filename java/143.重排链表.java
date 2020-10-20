/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {

        //双指针 使用list 保存链表每一个节点，方便后续获取 时间复杂度 O(n)
        if(head == null) return;

        List<ListNode> list = new ArrayList<>();

        while(head != null){
            list.add(head);
            head = head.next;
        }

        int left =0,right = list.size()-1;

        while(left<right){

            list.get(left).next = list.get(right);
            //移动左指针
            left++;
            //如果指针相等 退出
            if(left == right) break;
            //当前节点下一个指向 原本的下一个
            list.get(right).next = list.get(left);
             right--;//移动右指针
        }
        //最后末尾节点next 置空
        list.get(left).next = null; 
    }
}
// @lc code=end

