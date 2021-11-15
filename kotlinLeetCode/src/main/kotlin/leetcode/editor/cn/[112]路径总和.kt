import java.util.*
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 717 👎 0


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
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        //方法一
        //深度优先遍历  时间复杂度 O(n)
        //递归结束条件
        if (root == null) return false
        //逻辑处理 进入下层循环
        //如果左右子树为空，判断当前值是否等于 targetsum
        if (root.left == null && root.right == null) return root.`val` == targetSum
        //数据reverse
        //继续判断左右子树
        return hasPathSum(root.left,targetSum - root.`val`) || hasPathSum(root.right,targetSum - root.`val`)
        //方法二 广度优先遍历 二叉树层序遍历
        //使用队列先进先出 时间复杂度 O(n)
        if (root == null) return false
        val queue = LinkedList<TreeNode>()
        queue.addFirst(root)

        while (!queue.isEmpty()){
            for (i in 0 until queue.size){
                var node = queue.removeLast()
                //当前节点为子节点并且没有左右子树 说明符合
                if (node.`val` == targetSum && node.left == null && node.right == null) return true
                //否则左右节点各自值累加 继续下一层次遍历
                if (node.left != null) {
                    node.left.`val` += node.`val`
                    queue.addFirst(node.left)
                }
                if (node.right != null) {
                    node.right.`val` += node.`val`
                    queue.addFirst(node.right)
                }
            }
        }

        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
