import java.util.*
import kotlin.collections.ArrayList

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 498 👎 0


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
    fun preorderTraversal(root: TreeNode?): List<Int> {
        //方法一 深度优先 前序遍历 中左右
        var res = ArrayList<Int>()

        dfs(root,res)

        return res

        //方法二 使用栈

        var stack = LinkedList<TreeNode>()
        //当前节点
        var curr = root

        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                //当前节点不为空
                res.add(curr.`val`)
                stack.addFirst(curr)
                curr = curr.left
            }else{
                curr = stack.removeFirst()
                curr = curr.right
            }
        }
        return res

    }

    private fun dfs(root: TreeNode?,res:ArrayList<Int>) {
        //递归结束条件
        if(root == null) return
        //逻辑处理进入下层循环
        res.add(root.`val`)
        if(root.left!=null) dfs(root.left,res)
        if(root.right!=null) dfs(root.right,res)
        //数据reverse

    }
}
//leetcode submit region end(Prohibit modification and deletion)
