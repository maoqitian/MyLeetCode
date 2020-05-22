import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

import sun.management.resources.agent;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
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
    public List<List<Integer>> levelOrder(Node root) {

        //使用队列 时间复杂度 O(n)

        //队列加入遍历的节点 先进先出

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<Node> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()){
            //保存每行数据
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }

            result.add(level);
        }

        return result;
        
    }
}
// @lc code=end

