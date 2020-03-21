/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {

        //参考 ：https://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
        //时间复杂度应该为 0(n)

        if(head  == null || k == 1) return head;

        ListNode result = new ListNode(0);

        result.next = head;
        ListNode pre = result;
        
        //记录遍历链表的值
        int i = 0;

        while(head != null){
            i++;

            if(i%k == 0){
               //翻转当前链表段
               pre = reverse(pre, head.next);
               head = pre.next;
            }else{
                //继续遍历
                head = head.next;
            }
        }

        return result.next;
    }

    //单转链表操作
    private static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next){
          last.next = cur.next;
          cur.next = pre.next;
          pre.next = cur;
          cur = last.next;
        }
        return last;
    }
}
// @lc code=end

