import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {


        //方法一 迭代 双层循环 不行
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if(nums[i] == nums[j]){
                    
        //         }
        //     }
        // }
        // return nums.length;


        //双指针 快慢指针 迭代数组 不同元素则放回到数据组中 时间复杂度 O(n)

        // if(nums.length == 0 ) return 0;
        
        // int slow = 0; //慢指针
        // //快指针从 1 开始遍历
        // for (int i = 1; i < nums.length; i++) {
        //     if(nums[i] != nums[slow]){
        //        //先移动，要不然先复制则多出一位
        //         slow ++ ;
        //         nums[slow] = nums[i];
               
        //     }
        // }
        
        // return slow+1;

        //快慢指针

        int x = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=nums[x]){
               x++;
               //将不重复的放入数组位置
               nums[x] = nums[i];
            }
        }

        return x+1;

        


    }
}
// @lc code=end

