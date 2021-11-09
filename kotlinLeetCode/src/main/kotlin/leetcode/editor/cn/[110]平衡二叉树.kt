
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 804 👎 0


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
    fun isBalanced(root: TreeNode?): Boolean {

        //后序遍历二叉树
        if (root == null) return true

        return treeHeight(root) != -1

    }

    private fun treeHeight(root: TreeNode?): Int {
        //递归结束条件
        if (root == null) return 0
        //逻辑处理 进入下层循环
        //左子树
        var left = treeHeight(root.left)
        if (left == -1) return -1
        //右子树
        var right = treeHeight(root.right)
        if (right == -1) return -1
        //计算高度差
        if (Math.abs(left-right) > 1){
            return -1
        }else{
            return Math.max(left,right) +1
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
