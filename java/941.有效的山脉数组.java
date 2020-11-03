/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] A) {

        //变量找到第山顶 然后继续遍历看是否形成下山趋势

        int index = 0,len = A.length;

        if(len<3) return false;

        //从左开始遍历

        while(index < len -1 && A[index]<A[index+1]){
            index++;
        }

        //此时 index 指向的应该为山顶坐标
        if(index == 0 || index == len-1){
            //如果index没有走动或者已经遍历到数组末尾 则不是目标数组
            return false;
        }

        while(index< len -1 && A[index]>A[index+1]){
             index++;
        }

        //遍历完成 index 是否来到数组末尾 表明是否成功
        return index == len-1;


    }
}
// @lc code=end

