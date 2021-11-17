import javax.swing.tree.TreeNode

//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 
// 👍 973 👎 0


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
    fun flatten(root: TreeNode?): Unit {

        //前序遍历 中左右
        if(root == null) return

        var nodeList = ArrayList<TreeNode>()

        preDFS(root,nodeList)
        //获取前序遍历集合，遍历集合将节点指向右子树

        for (i in 1 until nodeList.size){
            //前一个节点
            var preNode = nodeList.get(i-1)
            //下一个节点
            var currNode = nodeList.get(i)
            //左子树为空
            preNode.left = null
            //指向右子树
            preNode.right = currNode
        }
    }

    private fun preDFS(root: TreeNode?, nodeList: java.util.ArrayList<TreeNode>) {

        if (root!=null){
          nodeList.add(root)
          preDFS(root.left,nodeList)
          preDFS(root.right,nodeList)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
