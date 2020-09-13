/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

    //         (x-1,y)
    //  (x,y-1) (x,y) (x,y+1)
    //         (x+1,y)
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    //是的访问过
    boolean [][] marked;

    int m=0,n=0 ; //多少行 、列
    
    public boolean exist(char[][] board, String word) {

        //深度优先遍历 上下左右匹配

        //行 列 赋值
        m = board.length;
        if(m == 0) return false;
        n = board[0].length;

        marked = new boolean[m][n];

        for(int i = 0;i<m;i++){

            for(int j = 0;j<n;j++){
               if(dfs(board, word,i,j,0)){ //如果匹配成功
                  return true;
               }
            }
        }

        return false;

    }

    boolean dfs(char[][] board, String word,int i,int j,int start){
          //递归结束条件
          if(start == word.length()-1){
              return board[i][j] == word.charAt(start);
          }
          //逻辑处理 进入下层循环
          if(board[i][j] == word.charAt(start)){
             //如果匹配到 ,记录 当前位置 已经访问
             marked[i][j] = true;
             //查找上下左右位置
             for(int k =0;k<4;k++){
                int newX = i+direction[k][0];
                int nexY = j+direction[k][1];
                if(inArea(newX,nexY) && !marked[newX][nexY]){
                    //如果没有超过边界 并且没有访问过
                    if(dfs(board,word,newX,nexY,start+1)){
                         return true;
                    }
                }
             }
             //回溯
             marked[i][j] = false;
          }

          //数据 reverse
          return false;
    }

    boolean inArea(int x,int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
}
// @lc code=end

