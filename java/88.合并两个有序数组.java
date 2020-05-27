import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //方法一 暴力破解 例如Java 提供好的函数 O((n+m)log(n+m))

        // System.arraycopy(nums2, 0, nums1, m, n);
        // Arrays.sort(nums1);

        //方法二 ： 双指针 从后指针从后往前

        //原始数组指针
        int p1 = m-1;
        int p2 = n-1;

        //新数组指针
        int p = m + n -1;

        while((p1 >= 0) && (p2 >= 0)){
           //比较两个指针指向的值 将较大的值加入目标数组
           nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--]:nums1[p1--];
        }
          
        //将nums2剩下数据加入数组
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }
}
// @lc code=end

