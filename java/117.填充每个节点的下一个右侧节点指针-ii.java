/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
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

        //二叉树层序遍历 遍历同时设置 next 时间复杂度 O(n)
        //使用队列

        if(root == null) return root;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            //当前层队列元素
            int size = queue.size();
            //记录 next 指向的node
            Node nextNode = null;
            for(int i =1;i<=size;i++){
                //从第第二个开始遍历
                Node node = queue.removeLast();

                if(node.left!=null) queue.addFirst(node.left);
                if(node.right!=null) queue.addFirst(node.right);

                if(i!=1){ //第一个不记录值
                    nextNode.next = node;
                }
                nextNode = node;
            }
        }

        return root;
        
        
    }
}
// @lc code=end

