/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {

        //对每个十进制的数转二进制的时候统计一下 1 的个数即可
        for(int i = 0;i<arr.length;i++){
           arr[i] += getBitsCount(arr[i]) <<14;
        }

        //排序
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){
            arr[i] &= 16383;
         }
         return arr;
    }

    //计算1 的个数
    int getBitsCount(int num){
         int bitCount = 0;
         while(num > 0){
             num &= num - 1;
             bitCount++;
         }
         return bitCount;
    }
}
// @lc code=end

