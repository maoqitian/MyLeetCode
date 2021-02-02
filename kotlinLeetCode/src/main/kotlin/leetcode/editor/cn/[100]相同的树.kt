//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 559 👎 0


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
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

        //递归比较比较 时间复杂度 O(n)
        //递归结束条件
        if(p == null && q == null) {
            return true
        }else if(p == null || q == null){
            return false
        }else if(p.`val` != q.`val`){
            return false
        }else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right)
        }

        //逻辑处理 进入下层循环

    }
}
//leetcode submit region end(Prohibit modification and deletion)
