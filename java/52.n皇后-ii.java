/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
//递归回溯 时间复杂度 O(n!) n的阶层

char[][] board = new char[n][n];

//构造数组
for(int i = 0;i<n;i++){
   for(int j = 0;j<n;j++){
       board[i][j] = '.';
   }
}

List<List<String>> res = new ArrayList<>();

//dfs深度优先

dfs(board,0,res);

return res.size();
    }

    void dfs(char[][] board,int index,List<List<String>> res){

        //递归结束条件 
        if(index == board.length){
           res.add(construct(board));
           return;
        }
        //逻辑处理 进入下层循环
        for(int i = 0; i< board.length;i++){
            if(validate(board,i,index)){
               board[i][index] = 'Q';
               dfs(board,index+1,res);
               board[i][index] = '.';
            }
        }
        //数据 reverse
    }

    //判断是否可以放入
    boolean validate(char[][] board,int x, int y){
        for(int i = 0;i<board.length;i++ ){
            for(int j = 0;j<board.length;j++){
              if(board[i][j] == 'Q' &&(x+j == y+i || x+y == i+j || x == i )){
                 return false;
              }
            }
        }
        return true;
    }
    
    //构造结果字符串集
    List<String> construct(char[][] board){
       List<String> res = new LinkedList<>();

       for(int i = 0; i< board.length;i++){
          String s = new String(board[i]);
          res.add(s);
       }
       return res;
    }
}
// @lc code=end

