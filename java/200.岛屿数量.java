/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int y;          // The height of the given grid
    int x;          // The width of the given grid
    char[][] g;
    public int numIslands(char[][] grid) {

        //想法 遇到1 则变成 0，然后寻找相邻的1 也变成零，直到相邻1全部变成零为止
        //重复上面步骤 相当于 DFS思想 递归
        //返回值
        int res=0;
        g = grid;

        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;
        //遍历二维字符数组
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                //如果当前为零 跳过
                if(g[i][j] == '1') {
                //否则遍历周报相邻的节点是否为1
                sink(i,j);
                res ++;
                }
            }
        }
        return res;    
    }
    
    /**
     * //递归找到当前位置相邻的1变成零
     * @param i 
     * @param j
     * @return
     */
    void sink(int i,int j){
          
        //递归退出条件 
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;

        //逻辑处理 进入下层递归
        
        //当前 i，j 位置为 1则变成零
        g[i][j] = 0;

        sink(i+1, j);
        sink(i-1, j);
        sink(i, j+1);
        sink(i, j-1);
        //数据 reverse
    }
}
// @lc code=end

