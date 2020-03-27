/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {


        //由题目意思应为数组最后一个元素移动到数组第一位，其他元素整体后移 k则为交换的次数
        
        //方法一 暴力破解 每循环一次 交换数组元素值 时间复杂度 O(n*k) 空间复杂度 O(1)

        // int temp,pre;
        // for (int i = 0; i < k; i++) {
        //     pre = nums[nums.length -1];
        //     for (int j = 0; j < nums.length; j++) {
        //        temp  = nums[j];
        //        nums[j] = pre;
        //        pre = temp;
        //     }
             
        // }


        //方法二 使用新的数组 存储排序后的值 然后拷贝回原来的数组
        //时间复杂度 O(n) 空间复杂度 O(n)


        // int[] temps = new int[nums.length];

        // for (int i = 0; i < nums.length; i++) {
        //     //确定存放位置
        //     temps[(i+k)%nums.length] = nums[i];
        // }

        // //拷贝排序好的数据到原数组
        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = temps[i];
        // }
        

        //方法三 全部反转后 前K个反转 后 n-k 个反转
        // 时间复杂度 O(n) 空间复杂度 O(1)

        k %= nums.length;
        //反转全部
        reverse(nums, 0, nums.length-1);
        //翻转前K个
        reverse(nums, 0, k-1);
        //翻转 nums.length -k 个
        reverse(nums, k, nums.length-1);
    }

    public void reverse (int[] nums,int start,int end){

        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
// @lc code=end

