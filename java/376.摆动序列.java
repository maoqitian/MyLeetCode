/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {

        //贪心算法 时间复杂度 O(n)
        int n = nums.length ;
        if(n <2) return n;
        
        //首先计算现在是正还是负
        int prediff = nums[1] - nums[0];
        //返回结果赋值
        int res = prediff != 0 ? 2 : 1;
        for(int i = 2;i < n;i++){
           // 差值
           int diff = nums[i] - nums[i-1];
           //判断一正一负情况 
           if( (diff> 0 && prediff<=0) || (diff< 0 && prediff>=0) ){
               res++;
               prediff = diff;
           }
        }
        return res;
    }
}
// @lc code=end

