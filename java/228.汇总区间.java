/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<String>();
        //时间复杂度 O(n)
        if(nums.length == 0) return res;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; ++i){
            //没有超过边界 并且 i 与 num[i] 相等则 
            if(!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)){
                if(sb.length() > 0) sb.append("->");
                sb.append(nums[i]);
                res.add(sb.toString());
                sb = new StringBuilder();
            } else{
                if(sb.length() == 0) sb.append(nums[i]);
            }
        }
        return res;

    }
}
// @lc code=end

