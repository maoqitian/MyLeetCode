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

         //方法一 迭代 将链表下一个元素next 指向上一个元素, 时间复杂度 0(n)
         
         //创建新节点
         ListNode newHead = null;

         while(head!=null){
             //获取当前节点
             ListNode next = head.next;
             //当前节点下一个指向新节点 也就是前一个节点
             head.next = newHead;
             //前一个节点移动指向当前节点
             newHead = head;
             //当前节点移动指向它原本的下一个节点
             head = next;
         }
         return newHead;

         //方法二 递归 时间复杂度 0(n) 

        //  if (head == null || head.next == null) return head;
        //  ListNode p = reverseList(head.next);
        //  head.next.next = head;
        //  head.next = null;
        //  return p;


    }
}
// @lc code=end

