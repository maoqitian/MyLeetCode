import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        // 确定边界 螺旋打印
        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0){
         return res;
        }
        //上下左右初始化
        int left = 0,right = matrix[0].length-1,top = 0,bottom = matrix.length-1;
        
        while(true){
          //左 到 右
          for (int i = left; i <= right; i++) {
              res.add(matrix[top][i]);
          }
          //越过边界
          if(++top>bottom) break;
          // 上 到 下 
          for (int i = top; i <= bottom; i++) {
              res.add(matrix[i][right]);
          }
          //越过边界
          if(left > -- right)break;
          // 右 到 左
          for (int i = right; i >= left; i--) {
              res.add(matrix[bottom][i]);
          }
          if(top > --bottom) break;
          //下 到 上
          for (int i = bottom; i >= top; i--) {
              res.add(matrix[i][left]);
          }
          if(++left>right)break;
        }


        return res;

    }
}
// @lc code=end

