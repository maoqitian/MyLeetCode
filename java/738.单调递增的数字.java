/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        //找到 nums[i-1] > nums[i] 位置 后面全部设置为 9
        //贪心算法 时间复杂度 O(n)

        char[] nums = Integer.toString(N).toCharArray();
        int flag = nums.length;
        for(int i = nums.length-1;i>0;i--){
            //设置
            if(nums[i-1]>nums[i]){
                flag = i;
                //当前数减一
                nums[i-1] --;
            }
        }
        //剩余位置转化为 9
        for(int i = flag;i<nums.length;i++){
            nums[i] = '9';
        }
        //将结果转为整数
        return Integer.parseInt(new String(nums));
    }
}
// @lc code=end

