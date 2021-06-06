//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 933 👎 0


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
    fun swapPairs(head: ListNode?): ListNode? {

        //方法一 递归 时间复杂度 O(n)
        //递归结束条件
        if(head == null || head.next == null) return head

        var first = head
        var second = head.next

        //改变交换 逻辑除了 进入下层循环
        first.next = swapPairs(second.next)
        second.next = first
        //数据 reverse
        return second

        //方法二 迭代
//        var res = ListNode(0)
//        res.next = head
//        //指针节点
//        var pre = res
//        var temp = head
//        //进行迭代
//        while(temp != null && temp.next != null){
//            var first = temp
//            var second = temp.next
//
//            //节点交换
//            pre.next = second
//            first.next = second.next
//            second.next = first
//            //移动指针
//            pre = first
//            temp = first.next
//        }
//
//        return  res.next

    }
}
//leetcode submit region end(Prohibit modification and deletion)
