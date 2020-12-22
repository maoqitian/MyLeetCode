import java.util.*
import kotlin.collections.ArrayList

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 355 👎 0


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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        //二叉树层序遍历 使用 队列
        //时间复杂度 O(n)
        val res = ArrayList<ArrayList<Int>>()

        if(root == null) return  res

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        //遍历层级
        var level = 0

        while (!queue.isEmpty()){
            val count = queue.size
            val temp = ArrayList<Int>()
            for (i in 0 until count){
                val node = queue.removeLast()
                if(node.left!=null) queue.addFirst(node.left)
                if(node.right!=null) queue.addFirst(node.right)
                temp.add(node.`val`)
            }
            if(level % 2 !=0){
                //奇数行反转
                temp.reverse()
            }
            level++
            res.add(temp)
        }

        return  res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
