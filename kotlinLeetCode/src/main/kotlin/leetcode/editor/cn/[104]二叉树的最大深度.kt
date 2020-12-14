import java.util.*
import kotlin.math.max

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 756 👎 0


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
    fun maxDepth(root: TreeNode?): Int {
        //DFS 时间复杂度 O(n)
        if (root == null) return 0
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1

        //BFS 时间复杂度 O(n)
        //遍历一层深度加一
        if (root == null) return 0
        val queue :LinkedList<TreeNode>  = LinkedList<TreeNode>()

        queue.addFirst(root)
        var res = 0
        while (!queue.isEmpty()){
            val size = queue.size
            for (i in 0 until size){
                val node = queue.removeLast()
                if (node.left != null) queue.addFirst(node.left)
                if (node.right != null) queue.addFirst(node.right)
            }
            //每遍历一层加一
            res++
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
