import javax.swing.tree.TreeNode

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 1384 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numTrees(n: Int): Int {
        //动态规划
        //将 1……(i−1) 序列作为左子树，将 (i+1)……n作为右子树
        var intArray = IntArray(n + 1)
        intArray[0] =1
        intArray[1] = 1

        for (i in 2..n){
            for (j in 1..i){
                intArray[i] += intArray[j-1]*intArray[i-j]
            }
        }
        return intArray[n]
    }


}
//leetcode submit region end(Prohibit modification and deletion)
