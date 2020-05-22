import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n ;i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();

        dfs(board,0,res);
        return res;
    }

    private void dfs(char[][] board,int collIndex,List<List<String>> res){
         //递归结束条件
         if(collIndex == board.length){
            res.add(construct(board));
            return;
         }

         //逻辑处理 进入下层循环
         for (int i = 0; i < board.length; i++) {
             if(validate(board,i,collIndex)){
                
                board[i][collIndex] = 'Q';
                dfs(board, collIndex+1, res);
                board[i][collIndex] = '.';
             }
         }

         //reverse status
    }
    //验证数据是否合法
    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 'Q' && (x+j == y+i || x+y == i+j || x == i)){
                    return false;
                }
            }
        }
        return true;
    }

    // 构造结果
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
// @lc code=end

