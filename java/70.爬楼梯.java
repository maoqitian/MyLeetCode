/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        //方法一 : 找规律 时间复杂度 O(n)
        // 一层 一种方法
        //二层 两种方法
        //三层 等于 一层方法加上二层方法
        
        // n层 等于 （n-1）+ （n-2）
        
        //直接判断 前两种情况
        // if(n <=2) return n;

        // //定义三个变量值 分别代表前三层 方法数

        // int f1 = 1;
        // int f2 = 2;
        // int f3 = 3;

        // for (int i = 3; i < n+1; i++) { 
        //     f3 = f1 + f2;
        //     //直接赋值继续下一层循环
        //     f1 = f2;
        //     f2 = f3;
        // }

        // return f2;


        //方法二 使用暴力 递归  时间复杂度 O(2^n) 超时

        //创建数组保存计算过的数据
        int[] temp = new int[n+1];

        return count(n,0,temp);

    }
    /**
     * 
     * @param n 台阶级数
     * @param position 保存数据数组 position
     * @param temp 保存数据数组
     * @return
     */
    int count(int n,int position,int[] temp){

        //退出递归条件
        if(position > n){
          return 0;
        }
        
        if(position == n){
           return 1;
        }
        if(temp[position]>0){ //如果存在则不再计算
          return temp[position];
        }
        // 逻辑处理 继续下一层次递归
        temp[position] = count(n, position+1, temp) + count(n, position+2, temp);
        return temp[position];
        //清理数据

    }
}
// @lc code=end

