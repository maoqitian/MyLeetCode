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

        //遍历 时间复杂度 O（n）

        var resNode = ListNode(0)

        resNode.next = head
        var currNode = resNode

        while (currNode.next != null){
            var ptr = currNode.next
            //是否有重复
            var isDup = false
            while (ptr.next != null && ptr.next.`val` == currNode.next.`val`){
                ptr = ptr.next
                isDup = true
            }

            if (isDup){
                currNode.next = ptr.next
            }else{
                currNode = currNode.next
            }
        }

        return resNode.next
    }

}
//leetcode submit region end(Prohibit modification and deletion)
