//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1132 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        //k 个一组来翻转链表 时间复杂度 O（n）
        if(head == null || k == 1) return head

        var tempHead : ListNode? = head

        var res = ListNode(-1)
        res.next = tempHead



        //前一个节点
        var pre : ListNode = res
        var index = 0
        while(tempHead !=null){
            //记录 K 段
            index ++
            if(index % k == 0){
                //满足K 段 翻转
                pre = reverseListNode(pre,tempHead.next)
                //重置head 值
                tempHead = pre.next
            }else{
                tempHead = tempHead.next
            }
        }

        return res.next

    }
    //翻转了链表
    private fun reverseListNode(pre: ListNode, next: ListNode): ListNode {
        //方法返回值也就是翻转后链表段的最后一个node
        //获取当前节点 也就是翻转之后的最后一个节点
        var last = pre.next
        var cur = last.next
        //如果当前节点不等于没翻转之前的链表段最后一个节点
        while (cur != next){
            //翻转
            //last连接下一次需要反转的节点
            last.next = cur.next
            //当前节点插入到头结点原本位置 反转节点cur
            cur.next = pre.next
            //记录指针指向当前 更新
            pre.next = cur
            //更新 下一个要翻转的结点
            cur = last.next
        }

        return last
    }
}
//leetcode submit region end(Prohibit modification and deletion)
