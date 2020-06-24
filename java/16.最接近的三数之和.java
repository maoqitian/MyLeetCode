import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // 排序数组 双指针 遍历 时间复杂度 O(n^2)


        //排序
        Arrays.sort(nums);
        //返回值初始化
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left =i+1,right = nums.length-1;
            while(left<right){
                //获取当前和
              int sum = nums[i]+nums[left]+nums[right];

               //比较绝对值大小 保存
               if(Math.abs(target-sum)<Math.abs(target-res)){
                res = sum;
              }
              if(sum>target){ //和值大于target 减小右指针
                  right--;
              }else if(sum<target){//和值大于target 增加左指针
                  left++;
              }else{
                  //和值等于 target
                  return target;
              }

            }
        }

        return res;

    }
}
// @lc code=end

