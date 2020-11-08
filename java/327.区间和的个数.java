/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {

        //归并排序 O(nlogn)
        int n = nums.length;
        long[] sums = new long[n + 1];
        for(int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    public int countWhileMergeSort(long[] sums, int low, int high, int lower, int upper) {
        if (high - low <= 1) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int count = countWhileMergeSort(sums, low, mid, lower, upper) 
                  + countWhileMergeSort(sums, mid, high, lower, upper);
        count += countWhileMerge(sums, low, mid, high, lower, upper);
        return count;
    }
    
    public int countWhileMerge(long[] sums, int low, int mid, int high, int lower, int upper) {
        int j = mid, k = mid, t = mid, count = 0;
        long[] cache = new long[high - low];
        for (int i = low, r = 0; i < mid; ++i, ++r) {
            while (k < high && sums[k] - sums[i] < lower) {
                k++;
            }
            while (j < high && sums[j] - sums[i] <= upper) {
                j++;
            }
            while (t < high && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r] = sums[i];
            count += (j - k);
        }
        System.arraycopy(cache, 0, sums, low, t - low);
        return count;
    }
}
// @lc code=end

