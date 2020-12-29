//给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都
//可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。 
//
// 示例 1: 
//
// 输入: nums = [1,3], n = 6
//输出: 1 
//解释:
//根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
//现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
//其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
//所以我们最少需要添加一个数字。 
//
// 示例 2: 
//
// 输入: nums = [1,5,10], n = 20
//输出: 2
//解释: 我们需要添加 [2, 4]。
// 
//
// 示例 3: 
//
// 输入: nums = [1,2,2], n = 5
//输出: 0
// 
// Related Topics 贪心算法 
// 👍 195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minPatches(nums: IntArray, n: Int): Int {
//假设数组元素现在可构成的和的区间为[1, total]
//插入元素number后，可构成的区间为[1,total] U [1+number, total+number] U [number], 等价于[1,total] U [number, total+number]
//可分为两种情况：
//如果 total>= number-1, 区间可合并为[1, total+number]     // [1,4] U [5,7]  -->  4>=5-1 即可合并
//否则，区间无法合并。可通过插入 total+1, 把区间扩展为 [1, 2total+1]
//注意：插入元素的范围为[1,n], 若total<n, 则total+1属于[1,n]之间
// 时间复杂度 O(n)
        var count = 0; //插入元素数目
        var total:Long = 0;

        //遍历 index
        var index =0;

        while(total < n){
            if(index < nums.size && total >= nums[index]-1){
                total += nums[index]
                index++
            }else{
                total += total+1
                count++
            }
        }
        return count
    }
}
//leetcode submit region end(Prohibit modification and deletion)
