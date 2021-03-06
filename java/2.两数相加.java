/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加 迭代 时间复杂度 O(max(m,n)) 
 * 
 * 思路 : 迭代变量，就像两数相加，超过十则进位， 并保存计算的值到链表中
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //迭代 时间复杂度 O(max(m,n))
        //创建一个链表保存数据
        // ListNode result = new ListNode(0);

        // ListNode p = l1, q = l2, curr = result;

        // //进位
        // int carry= 0;

        // //迭代 两个链表数据
        // while(p != null || q != null){
        //     int x = (p!=null) ? p.val : 0;
        //     int y = (q!=null) ? q.val : 0;

        //     int sum = carry + x + y;
        //     carry = sum/10;
        //     curr.next = new ListNode(sum%10);
        //     //移动指针
        //     curr = curr.next;
        //     if(p!=null) p= p.next;
        //     if(q!=null) q= q.next;
        // }

        // //计算法完成判断是否还有进位进位

        // if(carry > 0){
        //   curr.next = new ListNode(carry);
        // }
        
        // //创建第一个节点对象值为零 从下一个节点开始返回
        // return result.next;


        // 思路 相当于两数相加 并记录进位的值 迭代两个 队列 获取值进行操作

        ListNode result = new ListNode(0);

        ListNode current = result;
        //进位
        int carry = 0;

        while(l1!=null || l2!=null){
            int x = l1==null ? 0:l1.val;
            int y = l2==null ? 0:l2.val;

            int sum = x+y +carry;
            //获取进位
            carry = sum/10;
            //存储相加的个位数
            current.next = new ListNode(sum%10);
            
            //移动指针
            current = current.next;
            if(l1 !=null) l1= l1.next;
            if(l2 !=null) l2= l2.next;
            
        }

        if(carry >0){
            current.next = new ListNode(carry);
        }

        return result.next;


    }
}
// @lc code=end

