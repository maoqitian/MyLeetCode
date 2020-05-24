/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


         // 二分查找 取 两个数组中位数 为 （m+n+1）/2，加一是应对奇数情况，就是左半边最大的元素小于等于右半边最小的元素

         


         //如果 m > n  交换两个数组 

         if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
         }
         int m = nums1.length;
         int n = nums2.length;
        
        int start = 0;
        int end = m;
        int mid = (m + n + 1) / 2;

        int ansi = -1;
        
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;
         while(start <= end){
             // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]

             int i = (start+end)/2;

             // 第二个数组中位数下标

             int j = mid - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0? Integer.MIN_VALUE : nums1[i-1]);
            int nums_i = (i == m? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0? Integer.MIN_VALUE : nums2[j-1]);
            int nums_j = (j == n? Integer.MAX_VALUE : nums2[j]);

            if(nums_im1 <= nums_j){ //当前左数组值太小 右移
               ansi = i;
               median1 = Math.max(nums_im1, nums_jm1);
               median2 = Math.min(nums_i, nums_j);
               start = i+1;
            }else{
                end = i-1;
            }
         }

         //判断数组长度奇偶数
         return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;

    }
}
// @lc code=end

