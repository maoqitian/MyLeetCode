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
         //将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，
         //因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用

        //  ListNode newHead = null;

        //  while(head!=null){
        //      ListNode temp = head.next;
        //      head.next = newHead;
        //      newHead = head;
        //      head = temp;
        //  }
        //  return newHead;

         //方法二 递归 时间复杂度 0(n) 

         if (head == null || head.next == null) return head;
         ListNode p = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return p;


    }
}
// @lc code=end

