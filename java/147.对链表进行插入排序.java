/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        //插入排序
        //创建一个头结点假定头结点往后的链表都是排好序的
        //从老链表不断获取节点选择插入排序到新建链表中
        //时间复杂度 O(n^2)
        if(head ==null) return head;

        //记录排序后链表
        ListNode temp = new ListNode(-1);
        temp.next = head;
        //当前节点指针和最后指向的排序链表指针
        ListNode currNode = head.next,lastSortNode = head;
        
        while(currNode!=null){
            //如果当前节点大于最后排序节点
            if(lastSortNode.val <= currNode.val){
               lastSortNode = lastSortNode.next;
            }else{
                //当前值小于，找到合适位置插入
                ListNode pre = temp;
                while(pre.next.val < currNode.val){
                    //是否有介于最后节点前面    
                    pre = pre.next;
                }
                //插入节点 pre -> lastSortNode 转换为 pre -> curr-> lastSortNode
                lastSortNode.next = currNode.next;
                currNode.next = pre.next;
                pre.next = currNode;
            }
            currNode = lastSortNode.next;
        }
        return temp.next;
    }
}
// @lc code=end

