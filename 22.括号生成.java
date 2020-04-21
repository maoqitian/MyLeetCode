import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {

        //使用递归 时间复杂度 O(2^n)

        //思想 最终3对括号就表明字符串最大值为 n*2, 每个括号的最大值小于n

        List<String> result = new ArrayList<>();

        generateString(n,0,0,"",result);

        return result;
    }

    /**
     * 
     * @param max 每个括弧的最大值
     * @param left 左括号的个数
     * @param right 右括号的个数
     * @param s 括号组成的字符串
     * @param result 返回值
     */
    void generateString(int max,int left,int right,String s,List<String> result){
         //递归四步骤
         //1 处理递归停止条件
         if(left == max && right == max){
            result.add(s);
            return;
         }

         //2逻辑处理 3 调用函数本身进入下一层递归
         if(left<max){
            generateString(max, left+1, right, s+"(", result);
         }
         //保证成对
         if(right<left){
            generateString(max, left, right+1, s+")", result);
         }


         //4 数据释放 状态清理


    }
}
// @lc code=end

