import java.util.List;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {

        //方法一 ： 递归 first second 代表第一个节点和第二个节点 真实交换
        //最终返回 second ,因为第一次交换头结点已经换成 second

        //时间复杂度

        // if(head == null || head.next == null){
        //     return head;
        // }

        // ListNode first = head;

        // ListNode second = head.next;
 
        // //递归继续交换下一组 
        // first.next = swapPairs(second.next);
        
        // second.next = first;

        // return second;

        //方法二 迭代 每次交换 并记录到新的链表中 时间复杂度 O(n)

        ListNode result = new ListNode(-1);

        result.next = head;
        
        //记录要交换头位置
        ListNode pre = result;

        while(head !=null && head.next != null){

            ListNode first = head;
            ListNode second = head.next;

            //确定头节点
            pre.next = second; 
            //真正交换 next
            first.next = second.next;
            second.next = first;
            //移动指针 继续下一次循环
            pre = first;
            head =first.next;
        }

        return result.next;
       
    }
}
// @lc code=end

