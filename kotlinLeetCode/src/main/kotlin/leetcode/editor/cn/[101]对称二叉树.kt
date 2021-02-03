import java.util.*
import javax.swing.tree.TreeNode

//给定一个二叉树，检查它是否是镜像对称的。
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1225 👎 0


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
    fun isSymmetric(root: TreeNode?): Boolean {

        //方法一： 二叉树递归 是否复杂度 O(n)

        //return checkTree(root,root)

        //方法二 二叉树层序遍历
        if (root == null) return true
        //使用队列分别记录左右
        var queue = LinkedList<TreeNode>()

        queue.addFirst(root.left)
        queue.addFirst(root.right)

        while (!queue.isEmpty() ){
            var node1 = queue.removeFirst()
            var node2 = queue.removeFirst()

            if (node1 == null && node2 == null) continue
            if (node1 == null || node2 == null || node1.`val` != node2.`val`)return false

            queue.addFirst(node1.left)
            queue.addFirst(node2.right)
            queue.addFirst(node2.left)
            queue.addFirst(node1.right)
        }

        return true

    }

    private fun checkTree(left: TreeNode?, right: TreeNode?): Boolean {
        //递归结束条件
        if(left == null && right == null) return true
        //逻辑处理 进入下层循环
        if(left == null || right == null){
            return false
        }
        return left.`val` ==  right.`val` && checkTree(left.left,right.right) && checkTree(right.left,left.right)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
