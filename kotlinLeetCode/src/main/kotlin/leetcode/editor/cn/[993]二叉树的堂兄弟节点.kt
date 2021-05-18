import java.util.*




//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 212 👎 0


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
     //x y 深度
     var xdeep = 0
     var ydeep = 0
     // x y 的 父 node 值
     var xpvar = 0
     var ypvar = 0
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {

        //方法一 dfs 深度优先
        if (root == null) return false
       /* dfs(root.left,x,y,1,root.`val`)
        dfs(root.right,x,y,1,root.`val`)
        return xpvar != ypvar && xdeep == ydeep*/
        //广度优先遍历 BFS 层次遍历
        var queue = LinkedList<TreeNode>()
        queue.add(root)

        //x y  父节点
        var px: TreeNode? = null
        var py: TreeNode? = null
        //是否有 x y
        var hasX = false
        var hasY = false


        while (!queue.isEmpty()){
            //获取当前层node 数量
            var size = queue.size
            for (i in 0 until size){
                var node:TreeNode = queue.removeLast()
                if(node.left != null){
                    if(node.left.`val` == x){
                        hasX = true
                        px = node
                    }else if(node.left.`val` == y){
                        hasY = true
                        py = node
                    }
                    queue.addFirst(node.left)
                }
                if(node.right != null){
                    if(node.right.`val` == x){
                        hasX = true
                        px = node
                    }else if(node.right.`val` == y){
                        hasY = true
                        py = node
                    }
                    queue.addFirst(node.right)
                }
            }
            if(px != py && hasX && hasY) return true

            hasX = false
            hasY = false
        }

        return false

    }

    //深度优先遍历
    private fun dfs(node: TreeNode?, x: Int, y: Int, deep: Int, pvar: Int) {
        //递归结束条件
        if (node == null) return
        //逻辑处理 进入下层循环
        if(node.`val` == x){
            xdeep = deep
            xpvar = pvar
        }else if(node.`val` == y){
            ydeep = deep
            ypvar = pvar
        }else{
            dfs(node.left,x,y,deep+1,node.`val`)
            dfs(node.right,x,y,deep+1,node.`val`)
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
