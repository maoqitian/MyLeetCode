/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    HashMap<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        
        //DFS 时间复杂度 O(n)

        //递归结束条件
        if(node == null) return node;

        ///逻辑处理进入下层递归
        //如果节点已经被访问则直接 hashmap 中取出
        if(map.containsKey(node)) return map.get(node);

        //克隆节点
        Node cloneNode = new Node(node.val,new ArrayList<>());

        //缓存节点
        map.put(node,cloneNode);

        //遍历相邻节点并组成 list

        for(Node neighbor:node.neighbors){
           cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        //数据 reverse
        return cloneNode;
        
    }
}
// @lc code=end

