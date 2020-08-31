/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
class Solution {

    //使用数组记录该节点是否访问过
    boolean [] vis;
    int len = 0;//遍历长度

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //深度优先遍历 时间复杂度 O(m+n)
        // int n = rooms.size();
        // vis = new boolean[n];

        // dfs(rooms,0);

        // return len == n; //是否全部遍历完

        //广度优先 遍历 使用队列 先进先出
        int n = rooms.size();
        vis = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        vis[0] = true;
        queue.addFirst(0);

        while(!queue.isEmpty()){

           int temp = queue.removeLast();

           len++;

           for(int i : rooms.get(temp)){
            if(!vis[i]){
                //没有遍历过
                vis[i] = true;
                queue.addFirst(i);
            }
         }

        }

        return len == n; //是否全部遍历完
    }

    void dfs(List<List<Integer>> rooms,int index){

        //递归结束条件
        vis[index] = true;
        //逻辑处理 进入下层循环 
        len++;

        for(int i : rooms.get(index)){
            if(!vis[i]){
                //没有遍历过
                vis[i] = true;
                dfs(rooms,i);
            }
        }
        //数据 reverse

    }
}
// @lc code=end

