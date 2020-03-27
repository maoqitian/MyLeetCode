/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        //方法一 : 找规律
        // 一层 一种方法
        //二层 两种方法
        //三层 等于 一层方法加上二层方法
        
        // n层 等于 （n-1）+ （n-2）
        
        //直接判断 前两种情况
        if(n <=2) return n;

        //定义三个变量值 分别代表前三层 方法数

        int f1 = 1;
        int f2 = 2;
        int f3 = 3;

        for (int i = 3; i < n+1; i++) {

            f3 = f1+f2;
            //直接赋值 不必新建数组保存变量
            f1 = f2;
            f2 = f3;
        }

        return f2;


    }
}
// @lc code=end

