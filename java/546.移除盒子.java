/*
 * @lc app=leetcode.cn id=546 lang=java
 *
 * [546] 移除盒子
 */

// @lc code=start
class Solution {
    public int removeBoxes(int[] boxes) {

        //动态规划？盒子消消乐 递归

        int [][][] dp = new int[100][100][100];

        return dpPoint(boxes,dp,0,boxes.length-1,0);
    }

    int dpPoint(int[] boxes,int [][][] dp,int left,int right,int k){
         //递归结束条件
        if(left > right) return 0;

        if(dp[left][right][k] != 0) return dp[left][right][k];

        //逻辑处理 进入下层循环
        while(right > left && boxes[right] == boxes[right - 1]){
            right --;
            k++;
        }

        //计算积分
        dp[left][right][k] = dpPoint(boxes,dp,left,right-1,0)+(k+1)*(k+1);

        for(int i= left; i<right;i++){
           if(boxes[i] == boxes[right]){
              dp[left][right][k] = Math.max(dp[left][right][k],dpPoint(boxes,dp,left,i,k+1)+dpPoint(boxes,dp,i+1,right-1,0));
           }
        }

        return dp[left][right][k];
        //数据 reverse
    }
}
// @lc code=end

