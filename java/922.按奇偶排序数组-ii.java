/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        //找到不在合适位置的 数 替换
        //双指针 时间复杂度 O(n)

        int j = 1;

        for(int i=0; i< A.length;i+= 2){
            if(A[i] % 2 == 1 ){ //当前位置为奇数
                while(A[j] % 2 == 1){
                    //找到对应奇数位置 移动index
                    j+= 2;
                }
                //数字替换
                swap(A,i,j);
            }
        }
        return A;
    }
    void swap(int[]nums,int i,int j){
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
    }
}
// @lc code=end

