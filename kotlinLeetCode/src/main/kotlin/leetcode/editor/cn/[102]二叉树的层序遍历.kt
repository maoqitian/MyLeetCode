import java.util.*
import kotlin.collections.ArrayList

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 718 👎 0


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
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        //二叉树层序遍历 使用队列先进先出
        val res : ArrayList<ArrayList<Int>> = ArrayList<ArrayList<Int>>()
        if(root == null) return res

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (!queue.isEmpty()){
            val count = queue.size
            val temp = ArrayList<Int>()
            for (i in 0 until count){
                val node = queue.removeFirst()
                temp.add(node.`val`)
                if(node.left != null) queue.addLast(node.left)
                if(node.right != null) queue.addLast(node.right)
            }
            //保存一次遍历结果
            res.add(temp)
        }
        return res
    }

}
//leetcode submit region end(Prohibit modification and deletion)
