import java.util.*
import javax.swing.tree.TreeNode

//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 449 👎 0


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
    fun sumNumbers(root: TreeNode?): Int {
        //方法一 dfs 前序遍历 中左右 时间复杂度 O(n)
        //return dfs(root,0)
        //方法二 二叉树层序遍历 先进先出
        //分别使用两个队列来存储节点、节点和
        var queue = LinkedList<TreeNode>()
        var queueSum = LinkedList<Int>()

        var temp = root
        queue.add(temp!!)
        queueSum.add(temp.`val`)

        var resSum = 0

        while (!queue.isEmpty()){
            var node = queue.removeLast()
            var currSum = queueSum.removeLast()
            var left = node.left
            var right = node.right

            if (left == null && right == null) {
                resSum += currSum
            }else{
                if (left!=null){
                    queue.addFirst(left)
                    queueSum.addFirst(left.`val`+currSum*10)
                }
                if (right!=null){
                    queue.addFirst(right)
                    queueSum.addFirst(right.`val`+currSum*10)
                }
            }
        }

        return resSum
    }

    private fun dfs(root: TreeNode?, preSum: Int):Int {
        //递归结束条件
        if (root == null) return 0
        //逻辑处理 进入下层循环
        var sum = root.`val` + preSum*10
        return if (root.left == null && root.right == null){
            sum
        }else{
            dfs(root.left,sum) + dfs(root.right,sum)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
