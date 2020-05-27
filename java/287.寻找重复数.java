/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {

        //想法 双指针夹逼 遍历

        int left = 0,right = nums.length -1;
        
        while(left < right){
            
            if(nums[left] != nums[right]){
                //当前左右指针值不相等
                right -- ;
                if(left +1 == right){
                 //如果 右指针减一 相当于 当前左指针值
                if(nums[left] == nums[right]){
                    
                   return nums[left];
                }else{
                    //重置循环
                   left ++ ;
                   right = nums.length-1;
                }
                }
                
            }else{
               return nums[left];
            }

        }
        return 0;

    }
}
// @lc code=end

