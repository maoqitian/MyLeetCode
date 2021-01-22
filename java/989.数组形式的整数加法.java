/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        //遍历 取出每次遍历最后一位加入下一轮相加
        //时间复杂度 O（n）
        LinkedList<Integer> res = new LinkedList<Integer>();
        int lastNum = K;
        //数组遍历index 倒序
        int index = A.length-1;


        while(index >=0 || lastNum>0){
             if(index >=0){
               lastNum += A[index];
             }

             res.addFirst(lastNum%10);

             lastNum /= 10;
             index--;
        }
        return res;

    }
}
// @lc code=end

