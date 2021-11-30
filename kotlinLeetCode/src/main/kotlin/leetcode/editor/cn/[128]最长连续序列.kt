//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 984 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestConsecutive(nums: IntArray): Int {

        //使用HashSet 处理数组元素
        //时间复杂度 O(n)

        var hashset = HashSet<Int>()
        nums.forEach { hashset.add(it) }

        var res = 0 //返回值
        var removes = 0 //删除次数
        var index1 = 0 //指针1 代表当前元素
        var index2 = 0 //指针2代表加一元素



        nums.forEach {
            //不存在
            if (!hashset.contains(it)) return@forEach

            //重置参数
            removes = 0
            index1 = it
            index2 = it+1

            while (hashset.contains(index1)){
                removes++
                hashset.remove(index1)
                index1--
            }

            while (hashset.contains(index2)){
                removes++
                hashset.remove(index2)
                index2++
            }

            res = if (removes>res) removes else res
        }

        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
