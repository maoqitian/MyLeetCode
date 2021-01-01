//假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True
//，不能则返回False。 
//
// 示例 1: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 1
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 2
//输出: False
// 
//
// 注意: 
//
// 
// 数组内已种好的花不会违反种植规则。 
// 输入的数组长度范围为 [1, 20000]。 
// n 是非负整数，且不会超过输入数组的大小。 
// 
// Related Topics 贪心算法 数组 
// 👍 263 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {

        //假设在数组左边添加0，以解决边界问题，令零累计初始为1
        //时间复杂度 O(n)
        var plant = 0
        var zeroCount = 1

        for (i in 0 until flowerbed.size){
            if (flowerbed[i] == 0){
                zeroCount++
            }else{
                zeroCount = 0
            }
            if (zeroCount == 3){//连续三个零种一颗
                plant++
                //重新假设
                zeroCount = 1
            }
        }

        if(zeroCount == 2) {plant++}

        return n <= plant

    }
}
//leetcode submit region end(Prohibit modification and deletion)
