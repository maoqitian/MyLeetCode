import java.util.*
import kotlin.collections.ArrayList

//给定一个二叉树，返回它的 后序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 511 👎 0


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
    fun postorderTraversal(root: TreeNode?): List<Int> {
        //方法一 深度优先 后序遍历 左右中
        var res = ArrayList<Int>()

//        dfs(root,res)
//
//        return res

        //方法二

        val result = LinkedList<Int>()

        val stack = LinkedList<TreeNode>()

        stack.push(root)

        while (!stack.isEmpty()) {
            val node = stack.removeFirst()
            if (null != node) {
                result.addFirst(node.`val`)
                stack.addFirst(node.left)
                stack.addFirst(node.right)
            }
        }
        return result


    }

    private fun dfs(root: TreeNode?,res:ArrayList<Int>) {
        //递归结束条件
        if (root == null) return
        //逻辑处理进入下层循环
        if (root.left != null) dfs(root.left, res)
        if (root.right != null) dfs(root.right, res)
        res.add(root.`val`)
        //数据reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
