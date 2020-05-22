import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {

        //方法一 迭代 遍历 链表每一个节点保存到 hashset 如果有环肯定会在set中包含 时间复杂度 O(n)

        // HashSet<ListNode> hashSet = new HashSet<>();

        // ListNode node = head;
        // while(node!=null){
        //    if(hashSet.contains(node)){
        //      return node;
        //    }
        //    hashSet.add(node);
        //    node = node.next;
        // }

        // return null;

        
        //方法二 双指针 时间复杂度 O(n)
        
        //快慢指针 这类链表题目一般都是使用双指针法解决的，例如寻找距离尾部第K个节点、寻找环入口、寻找公共尾部入口等
        
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            if(fast == null || fast.next == null) return null;
            
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
               break;
            }
        }

        fast = head;

        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;

        
    }
}
// @lc code=end

