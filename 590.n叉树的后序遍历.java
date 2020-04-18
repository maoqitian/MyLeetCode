/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
         //方法一 递归 时间复杂度 O(n)

         List<Integer> result = new ArrayList<>();

         postNodeResult(root,result);
 
         return result;
        
    }

    void postNodeResult(Node root,List<Integer> result){
          
        if(root == null) return;
        for (Node node : root.children) {
            postNodeResult(node, result);
        }
        result.add(root.val);
    }
}
// @lc code=end

