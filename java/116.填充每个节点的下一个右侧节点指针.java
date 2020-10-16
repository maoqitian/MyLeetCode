/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        //二叉树层序遍历 时间复杂度 O(n)

        if(root == null) return root;

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int count = queue.size();

            for(int i = 0 ; i<count;i++){

                Node node = queue.removeFirst();

                if(i < count -1) node.next = queue.peek();

                if(node.left != null){
                   queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

        }
        return root;
        
    }
}
// @lc code=end

