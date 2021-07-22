//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 589 👎 0


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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {

        if(head == null || head.next == null || k == 0) return head

        var curr = head
        var len = 1
        //遍历找到尾结点
        while (curr!!.next !=null){
            curr = curr.next
            len++
        }
        //此时 curr 指向链表最后一个节点

        //K刚好旋转等于长度余数为零
        if(k%len == 0) return head
        //有余数
        curr.next = head
        // 3. 找到倒数第 k 个节点的前驱节点
        curr = head
        for (index in 0 until len - (k % len) - 1) {
            curr = curr!!.next
        }
        // 4. 断开 preK
        val preK = curr
        val kP = preK!!.next
        preK.next = null
        return kP
    }
}
//leetcode submit region end(Prohibit modification and deletion)
