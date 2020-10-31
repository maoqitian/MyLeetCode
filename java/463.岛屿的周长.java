/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {


        //扩散 计算面积
        //+--+     +--+                   +--+--+
        //|  |  +  |  |          ->       |     |
        //+--+     +--+                   +--+--+
        //4 + 4 - ? = 6  -> ? = 2

        //陆地数量 和邻居数量
        int islands = 0 , neighbours = 0;

        for(int i = 0;i < grid.length;i++){
 
             for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                   islands ++;
                   //向下
                   if(i < grid.length-1 && grid[i+1][j] == 1) neighbours++;
                   //向右
                   if(j < grid[i].length-1 && grid[i][j+1] == 1) neighbours++;

                }
            }

        }

        return islands*4 - neighbours*2;
    }
}
// @lc code=end

