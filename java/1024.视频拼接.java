/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */

// @lc code=start
class Solution {
    public int videoStitching(int[][] clips, int T) {

        //遍历数组 找到 [0,T] 范围
        //双指针 获取最大最小

        // if(T == 0) return true;

        // int[] res =new int[2];

        // for(int i = 0;i<clips.length;i++){
        //    int []temp = clips[i];
        //    int min = temp[0];
        //    int max = temp[1];

        //     res[0] = Math.min(min,res[0]);
        //     res[1] = Math.max(max,res[1]);

        // }

        // if(res[0] == 0 && res[1] == T){
        //      return true;
        // }else {
        //     return false;
        // }

        //动态规划

        int []dp = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);


        dp[0] = 0;

        for(int i = 1; i<= T;i++){
            for(int[]clip : clips){
                if(clip[0]<i && i <= clip[1]){
                   dp[i] = Math.min(dp[i],dp[clip[0]]+1);
                }   
            }
        }

        return dp[T] == Integer.MAX_VALUE -1? -1 : dp[T];

    }
}
// @lc code=end

