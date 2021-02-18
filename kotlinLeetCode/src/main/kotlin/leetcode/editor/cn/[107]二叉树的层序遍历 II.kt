import java.util.*
import kotlin.collections.ArrayList

//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 404 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {

        //二叉树层序遍历 遍历完成之后反转结果 时间复杂度 O（n）

        val res = ArrayList<ArrayList<Int>>()
        if (root == null) return res

        //使用队列保存node 先进先出

        val linkedList = LinkedList<TreeNode>()
        linkedList.addLast(root)

        while (!linkedList.isEmpty()){
            var count = linkedList.size
            var templist = ArrayList<Int>()
            for (i in 0 until count){
                var node = linkedList.removeFirst()
                if (node.left != null){
                    linkedList.addLast(node.left)
                }
                if (node.right != null){
                    linkedList.addLast(node.right)
                }
                templist.add(node.`val`)
            }
            res.add(templist)
        }
        res.reverse()
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
