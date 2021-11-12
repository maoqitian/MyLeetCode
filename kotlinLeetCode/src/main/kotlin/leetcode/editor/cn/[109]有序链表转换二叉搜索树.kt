//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 
// 👍 612 👎 0


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
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var currNode : ListNode? = null
    fun sortedListToBST(head: ListNode?): TreeNode? {
        //递归 中序遍历 时间复杂度 O(n)
        //先计算链表长度 然后递归构造, 二分查找 中间值二根节点 左边为左子树 右边为右子树
        if (head == null) return null
        var len = 0
        currNode = head
        var temp = head
        while(temp != null){
            len++
            temp = temp.next
        }

        return buildBTS(0,len-1)
    }

    private fun buildBTS(left: Int, right: Int): TreeNode?  {
        //递归结束条件
        if(left>right) return null
        //逻辑处理 进入下层循环
        //寻找中间值
        var mid = left + (right-left)/2
        var leftNode = buildBTS(left,mid-1)

        val root = TreeNode(0)

        root.left = leftNode
        root.`val` = currNode?.`val`!!
        currNode = currNode?.next
        root.right = buildBTS(mid+1,right)
        //数据reverse
        return root
    }
}
//leetcode submit region end(Prohibit modification and deletion)
