import java.util.*
import javax.swing.tree.TreeNode
import kotlin.collections.ArrayList


//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 614 👎 0


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
    var res: ArrayList<List<Int>> = ArrayList()
    var path: ArrayList<Int> = ArrayList()

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {

        //方法一 DFS
        //深度优先遍历
        dfs(root,targetSum)

        return res
        //方法二 BFS
        //二叉树层序遍历 时间复杂度 O(n)
        //使用两个队列，一个存储结点，一个存储从根结点到当前节点的路径
         var res = ArrayList<ArrayList<Int>>()
         if (root == null) return res
         var queue = LinkedList<TreeNode>()
         var queueList = LinkedList<ArrayList<Int>>()

         //根节点的路径入队
         val list: ArrayList<Int> = ArrayList()

         queue.addFirst(root)
         list.add(root.`val`)
         queueList.add(list)
         while (!queue.isEmpty()){
             val node = queue.removeLast()
             //获取当前队列
             val templist = queueList.removeLast()
             //符合条件 保存对应队列
             if (node.`val` == targetSum && node.left == null && node.right == null){
                 res.add(templist)
             }
             //不符合条件 继续遍历
             if (node.left != null) {
                 templist.add(node.left.`val`)
                 //加入下一层的路径list
                 queueList.addFirst(ArrayList(templist))
                 node.left.`val` += node.`val`
                 queue.addFirst(node.left)
                 //当前队列删除无用数据
                 templist.removeAt(templist.size-1)
             }
             if (node.right != null) {
                 templist.add(node.right.`val`)
                 //加入下一层的路径list
                 queueList.addFirst(ArrayList(templist))
                 node.right.`val` += node.`val`
                 queue.addFirst(node.right)
             }
         }
         return res
    }

    private fun dfs(root: TreeNode?, targetSum: Int) {
        //递归结束条件
        if (root == null) return
        //逻辑处理 进入下层循环

        var tempSum = targetSum

        path.add(root.`val`)
        tempSum -= root.`val`
        //符合条件 保存对应队列
        if (0 == tempSum && root.left == null && root.right == null){
            res.add(ArrayList<Int>(path))
        }
        //继续遍历
        dfs(root.left,tempSum)
        dfs(root.right,tempSum)
        //数据reverse
        path.removeAt(path.size -1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
