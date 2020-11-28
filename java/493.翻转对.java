/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {

        //使用 归并排序 时间复杂度 O(nlogn)
        if(nums.length == 0) return 0;
        return mergeSort(nums,0,nums.length-1);

    }
    /**
     * @param a 待排序数组
     * @param low 低位index
     * @param high 高位index
     */
    int mergeSort(int [] a,int low,int high){
        //获取中位数
        int mid = (high-low)/2 + low;
        if(low < high){
            //mid 左边归并
            int n1 = mergeSort(a,low,mid);
            int n2 = mergeSort(a,mid+1,high);
            int res = n1+n2;
            //根据题目给出条件，统计下标对的数量
            int i = low;
            int j = mid+1;
            while(i <= mid){
                while(j <= high && (long)a[i]>2*(long)a[j]){
                    j++;
                }
                res += j - mid -1;
                i++;
            }
            //左右归并两个排序好数组
            merge(a,low,mid,high);
            return res;
        }else {
            return 0;
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
        int temp[] = new int[high-low+1];
        //合并左右数组的左右指针
        int left = low,right = mid+1;
        //当前中间记录结果数组 index
        int index=0;
        
        //较小数移动到新数组
        while(left <=mid && right <= high){
             if(a[left] < a[right]){
                 //记录左边小数值
                 temp[index++] = a[left++];
             }else{
                 //右边部分小数
                 temp[index++] = a[right++];
             }
        }
        //把剩下左右两边数记录到中间结果数组
        while(left<= mid){
           temp[index++] = a[left++];
        }
        while(right<=high){
           temp[index++] = a[right++];
        }
        //中间结果数组此时已经完成一次归并排序 覆盖原待排序数组
        for(int i = 0; i < temp.length;i++){
            a[i+low] = temp[i];
        }
    }

}
// @lc code=end

