
//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 585 👎 0


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
    //定义 之前结点记录 和需要交换值的节点
    var pre: TreeNode? = null
    //定义 之前结点记录 和需要交换值的节点
    var first:  TreeNode? = null
    //定义 之前结点记录 和需要交换值的节点
    var second: TreeNode? = null
    fun recoverTree(root: TreeNode?): Unit {

        //中序遍历二叉搜索应该是顺序递增
        dfs(root)
    }

    private fun dfs(root: TreeNode?) {
        root ?: return
        var first: TreeNode? = null
        var second: TreeNode? = null
        var prev: TreeNode? = null
        var x = root
        while (x != null) {
            if (x.left == null) {
                if (prev != null && x.`val` < prev.`val`) {
                    if (first == null) {
                        first = prev
                    }
                    second = x
                }
                prev = x
                x = x.right
            } else {
                var predecessor = x.left!!
                while (predecessor.right != null && predecessor.right != x) {
                    predecessor = predecessor.right!!
                }
                if (predecessor.right == null) {
                    predecessor.right = x
                    x = x.left
                } else {
                    if (prev != null && x.`val` < prev.`val`) {
                        if (first == null) {
                            first = prev
                        }
                        second = x
                    }
                    prev = x
                    predecessor.right = null
                    x = x.right
                }
            }
        }
        if (first != null && second != null) {
            var tmp = first.`val`
            first.`val` = second.`val`
            second.`val` = tmp
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
