/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
        //是否复杂度 O(n)
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            if(nums[Math.abs(nums[i]) -1]>0){
                //使用负数标记
                nums[Math.abs(nums[i]) -1] = - nums[Math.abs(nums[i])-1];
            }
        }

        for(int i = 0; i<nums.length;i++){
          if(nums[i] > 0){
              res.add(i+1);
          }
        }

        return res;

    }
}
// @lc code=end

