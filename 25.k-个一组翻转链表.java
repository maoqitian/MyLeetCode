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

    //单转反转操作 原地反转
    private static ListNode reverse(ListNode pre, ListNode next){
        // 获取当前节点，也就是反转之后最后一个节点
        ListNode last = pre.next;
        //当前结点指向最后一个节点的后继
        ListNode cur = last.next;

        //如果当前结点不等于反转组的最后一个节点
        while(cur!= next){
           //last连接下一次需要反转的节点
          last.next = cur.next;
           //当前节点插入到头结点原本位置 反转节点cur
           cur.next = pre.next;
           //纠正头结点指向
           pre.next = cur;
           //当前节点继续指向下一个需要反转的节点
           cur = last.next;
        }

        return last;
    }
}
// @lc code=end

