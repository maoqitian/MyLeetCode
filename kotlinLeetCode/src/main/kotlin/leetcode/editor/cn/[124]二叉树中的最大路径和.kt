//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 递归 
// 👍 844 👎 0


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
    var maxSum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {

        //递归 获取路径最大值 分别计算 当前节点 和左右子树相加
        //时间空间复杂度 O(n)

        maxPath(root)

        return maxSum

    }

    private fun maxPath(root: TreeNode?) :Int{
        //递归结束条件
        if(root == null) return 0
        //逻辑处理 进入下层循环
        var leftmax = Math.max(maxPath(root.left),0)
        var rightmax = Math.max(maxPath(root.right),0)

        //当前层最大值
        var curMax = root.`val` + leftmax + rightmax

        //更加最大值记录
        maxSum = Math.max(curMax,maxSum)
        //返回最大值
        return root.`val`+Math.max(leftmax,rightmax)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
