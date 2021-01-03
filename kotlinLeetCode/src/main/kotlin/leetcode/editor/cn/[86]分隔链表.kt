//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 334 👎 0


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
    fun partition(head: ListNode?, x: Int): ListNode? {
        //两个链表分别记录小于 X 和大于 X 的节点随后拼接 时间复杂度 O(n)

        var dyNode1 = ListNode(0)
        var dyNode2 = ListNode(0)

        var head1: ListNode? = head

        var node1: ListNode = dyNode1
        var node2: ListNode = dyNode2

        while(head1 != null){
            if(head1.`val` < x){
                dyNode1.next = head1
                dyNode1 = dyNode1.next
            }else{
                dyNode2.next = head1
                dyNode2 = dyNode2.next
            }
            head1 = head1.next
        }

        dyNode2.next = null
        dyNode1.next = node2.next
        return node1.next

    }
}
//leetcode submit region end(Prohibit modification and deletion)
