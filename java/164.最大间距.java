/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {

        //暴力使用api 排序 时间复杂度 O(n)

        int len = nums.length;
        if(len<2) return 0;

        int res = Integer.MIN_VALUE;

        //使用系统 api 排序
        //Arrays.sort(nums);

        //自己写排序

        //归并排序
        mergeSort(nums,0,len-1);

        for(int i = 1;i<len;i++){
            res = Math.max(nums[i]-nums[i-1],res);
        }

        return res;

    }
     /**
     * @param a 待排序数组
     * @param low 低位index
     * @param high 高位index
     */
    void mergeSort(int [] a,int low,int high){
         int mid = low + (high -low)/2;
         if(low<high){
            //归并左边部分
            mergeSort(a,low,mid);
            //归并右边部分
            mergeSort(a,mid+1,high);
            //左右合并
            merge(a,low,mid,high);
         }
    }
    /**
     * @param a 待排序数组
     * @param low 低位index
     * @param mid 中位数index
     * @param high 高位index
     */
    void merge(int[] a, int low, int mid, int high) {
        //存储中间结果数组
        int [] temp = new int[high - low +1];
        //左右指针
        int left = low,right = mid+1;
        //中间结果数组index
        int index = 0;
        //较小数移动到新数组
        while(left<= mid && right <= high){
            //把较小的数移动到新数组
           if(a[left] < a[right]){
               temp[index++] = a[left++];
           }else{
            temp[index++] = a[right++];
           }
        }
        //把左边剩余的数组放入temp数组
        while(left <= mid){
           temp[index++] = a [left++];
        }
        //右边剩余部分放入temp数组
        while(right <= high){
            temp[index++] = a [right++]; 
        }
        //排序一次结果覆盖原本数组
        for(int i = 0;i < temp.length;i++){
            a[i+low] = temp[i];
        }
    }
}
// @lc code=end

