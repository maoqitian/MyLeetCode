import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        //方法一 使用哈希表 迭代 时间复杂度 O(n)

        // Set<ListNode> hashSet = new HashSet<>();

        // while(head!=null){
        //     if(hashSet.contains(head)){
        //         //如果找到 则有环
        //        return  true;
        //     }else{
        //         hashSet.add(head);
        //     }
            
        //     head = head.next;
        // }
        // //最终遍历到链表末尾为 null ,没有环
        // return false;
        
        //方法二 进阶 双指针 相当于一条跑道上两个跑步，一个快（一次走两步），一个慢（一次走一步），如果最终快的追上慢的
        //则相当于多跑一圈，也就是形成了环 时间复杂度 O(n) 空间复杂度只用到两个节点，则为 O(1) 完成进阶

        if(head == null || head.next == null){
           return false;
        }

        ListNode slow = head,fast = head.next;
        while(slow != fast){
           if(fast == null || fast.next == null){
               //快的先走完没找到，没有环
             return false;
           }
           slow = slow.next;
           fast = fast.next.next;
        }
        //循环结束 表示找到 有环
        return true;
    }
}
// @lc code=end

