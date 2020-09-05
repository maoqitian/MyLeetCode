/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {

        // 减枝 找到会在某个数开头 使用数组模拟 时间复杂度 O(n^2)
        // 相当于在 n 个数字的全排列中找到下标为 k - 1 的那个数，因此 k 先减 1
        k--;

        int[] f = new int[n];

        f[0] = 1;
        //计算所有位置阶乘枝 保持在数组中
        for(int i = 1;i<n;i++){
           f[i] = f[i-1]*i;
        }

        //使用链表记录位置
        List<Integer> nums = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            nums.add(i);
         }


         StringBuilder s = new StringBuilder();

         for(int i = n -1;i>=0;i--){ //i 标识剩余可选数字个数 初始为 n -1
            int index = k/f[i];
            s.append(nums.remove(index));

            k = k - index*f[i];
         }

         return s.toString();
    }
}
// @lc code=end

