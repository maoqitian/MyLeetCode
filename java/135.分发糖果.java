/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {

        //正逆序遍历 时间复杂度 O(n)
        int len = ratings.length;

        if(len == 0) return 0;
        //保存每个孩子糖果数组
        int [] candys = new int[len];
        candys[0] = 1;
        for(int i = 1;i < len;i++){
           if(ratings[i] > ratings[i-1]){
               candys[i] = candys[i-1]+1;
           }else{
               candys[i] = 1;
           }
        }

        for(int i = len -2;i >= 0;i--){
           if(ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]){
                candys[i] = candys[i+1]+1;
           }
        }
         int res = 0;
        for(int i : candys){
           res += i;
        }

        return res;

    }
}
// @lc code=end

