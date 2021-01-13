//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1478 👎 0


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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        //方法一 递归合并 时间复杂度 O(max(n,m)) m n 为两个链表的长度
        if (l1 == null){
            return l2
        }else if (l2 == null){
            return l1
        }else if(l1.`val` > l2.`val`){
            //继续比较l1 和 l2.next 下一位谁大
            l2.next = mergeTwoLists(l1,l2.next)
            return l2
        }else{
            //l1.`val` < l2.`val`
            l1.next = mergeTwoLists(l1.next,l2)
            return l1
        }

        //方法二 迭代
        val prehead = ListNode(0)

        var node1 = l1
        var node2 = l2

        var prev: ListNode = prehead

        while (node1 != null && node2 !=null) {
            if (node1.`val` < node2.`val`){
                prev.next = node1
                node1 = node1.next
            }else{
                prev.next = node2
                node2 = node2.next
            }
            prev = prev.next
        }

        //找到最后没有比较的那一个数据加入到链表中
        //找到最后没有比较的那一个数据加入到链表中
        prev.next = if (node1 == null) node2 else node1

        return prehead.next

    }
}
//leetcode submit region end(Prohibit modification and deletion)
