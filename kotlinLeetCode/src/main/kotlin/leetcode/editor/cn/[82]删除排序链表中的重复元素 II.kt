//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 435 👎 0


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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        //逻辑处理 进入下层循环

        //逻辑处理 进入下层循环
        var next: ListNode = head.next
        if (head.`val` === next.`val`) {
            //找到不相等为止
            while (next != null && head.`val` === next.`val`) {
                next = next.next
            }
            head = deleteDuplicates(next)
        } else {
            head.next = deleteDuplicates(next)
        }
        //数据 reverse

        //数据 reverse
        return head
    }

}
//leetcode submit region end(Prohibit modification and deletion)
