import kotlin.math.min

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 617 👎 0


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
    fun minDepth(root: TreeNode?): Int {

        //递归
        //递归结束条件
        if (root == null) return 0
        //逻辑处理进入下层循环
        //分别获取左右子树深度
        var leftlen = minDepth(root.left)
        var rightlen = minDepth(root.right)
        //如果有一个子树深度为零 说明最小深度则为当前有深度子树的深度
        if (leftlen == 0 || rightlen == 0){
            return Math.max(leftlen,rightlen)+1
        }else{
            //否则返回当前较小深度
            return Math.min(leftlen,rightlen)+1
        }
        //数据reverse

    }
}
//leetcode submit region end(Prohibit modification and deletion)
