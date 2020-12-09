//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5357 👎 0


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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        //两数相加 迭代 时间复杂度 O(max(m,n)) m n 为两个链表长度

        return dfs(l1, l2, 0)
    }

        fun dfs(l: ListNode?, r: ListNode?, i: Int): ListNode? {
            if (l == null && r == null && i == 0) return null
            val sum: Int = (l?.`val` ?: 0) + (r?.`val` ?: 0) + i
            val node: ListNode = ListNode(sum % 10)
            node.next = dfs(l?.next, r?.next, sum / 10)
            return node
        }

}


//leetcode submit region end(Prohibit modification and deletion)
