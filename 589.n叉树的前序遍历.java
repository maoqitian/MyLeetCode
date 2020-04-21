import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    public List<Integer> preorder(Node root) {

        //方法一 递归 时间复杂度 O(n)

        List<Integer> result = new ArrayList<>();

        preNodeResult(root,result);

        return result;
        
    }

    void preNodeResult(Node root,List<Integer> result){
          
        if(root == null) return;

        result.add(root.val);
        for (Node node : root.children) {
            preNodeResult(node, result);
        }
    }
}
// @lc code=end

