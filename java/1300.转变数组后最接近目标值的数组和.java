import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1300 lang=java
 *
 * [1300] 转变数组后最接近目标值的数组和
 */

// @lc code=start
class Solution {
    public int findBestValue(int[] arr, int target) {
        //排序
        Arrays.sort(arr);
        //数组元素个数 数组 index
        int arrLength = arr.length,i = 0;

        while(i < arrLength && target > arr[i] * (arrLength - i)){ //计算 target 值是否 大于当前元素和数组元素个数乘积
            //继续判断下一个元素
            target -= arr[i++];
        }
        if(i == arrLength) return arr[arrLength-1];

        //否则求均值
        int res = target / (arrLength-i);

        if(target - res*(arrLength-i) > (res+1)*(arrLength-i)-target) res++;

        return res;

    }
}
// @lc code=end

