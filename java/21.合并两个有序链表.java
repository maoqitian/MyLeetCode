/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 方法1 递归 时间复杂度 O(n + m)、空间复杂度O(n+m) 。 因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），
 * 函数 mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。
 * 方法2 迭代 时间复杂度 O(n + m)、空间复杂度O(l)。迭代的过程只会产生几个指针，所以它所需要的空间是常数级别的
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //解法一 暴力破解 递归 时间复杂度 O(m+n)
        //首先对两个链表判空
        // if(l1 == null){
        //   return l2;
        // }else if(l2 == null){
        //   return l1;
        // }else if(l1.val < l2.val){
        //     l1.next = mergeTwoLists(l1.next, l2);
        //     return l1;

        // }else{
        //     l2.next = mergeTwoLists(l2.next,l1);
        //     return l2;
        // }

        //方法二 迭代
        ListNode prehead = new ListNode(0);

        ListNode prev = prehead;

        while(l1 != null && l2 != null){
            // 循环取值对比 直到有一个数组为空为止
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            //移动记录链表节点
            prev = prev.next;
        }
        //找到最后没有比较的那一个数据加入到链表中
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;

    }
}
// @lc code=end

