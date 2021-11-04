import javax.swing.tree.TreeNode

//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 1027 👎 0


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
    fun generateTrees(n: Int): List<TreeNode?> {

        if(n == 0) return ArrayList<TreeNode?>()

        return generateBinaryTrees(1,n)
    }

    private fun generateBinaryTrees(start: Int, end: Int): ArrayList<TreeNode?> {
        var res = ArrayList<TreeNode?>()
        //递归结束条件
        if (start > end){
            res.add(null)
            return res
        }
        //逻辑处理 进入下层循环
        //遍历可行根节点
        for (i in start..end){
            //左子树
            var leftTree = generateBinaryTrees(start, i - 1)
            //右子树
            var rightTree = generateBinaryTrees(i+1,end)

            //从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            leftTree.forEach { leftNode->
                rightTree.forEach { rightNode->
                    var node = TreeNode(i)
                    node.left = leftNode
                    node.right = rightNode
                    res.add(node)
                }
            }
        }
        //数据 reverse
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
