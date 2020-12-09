/*
 * @lc app=leetcode.cn id=842 lang=java
 *
 * [842] 将数组拆分成斐波那契序列
 */

// @lc code=start
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {

        //递归回溯算法 O(nlog^2 C)
        List<Integer> res = new ArrayList<>();

        backTrack(S.toCharArray(),0,res);
        return res;
    }
    boolean backTrack(char[] digit,  int index,List<Integer> res){
       //递归结束条件
       //如果超过数组长度或者 单个已经收集完成
       if(index == digit.length&&res.size()>=3) return true;
       //逻辑处理进入下层循环

       for(int i = index ; i < digit.length;i++){
          //不能以零开头
          if(digit[index] == '0' && i > index) break;
          //将截取的字符转为为数字
          long num = subStrDigit(digit,index,i+1);

          ///如果截取的数字大于int的最大值，则终止截取
          if (num > Integer.MAX_VALUE) {
            break;
          }

          int size = res.size();
          // 相加大于 不满足条件
          if(size>=2 && num > res.get(size-1) + res.get(size-2)) break;
          
          if(size<=1 || num ==  res.get(size-1) + res.get(size-2)){
              //满足条件 保存结果
              res.add((int) num);
              //继续操作
              if(backTrack(digit,i+1,res)) return true;

              //回溯清除上一步不合格结果
              res.remove(res.size()-1);
          }
       }
       return false;
    }

    long subStrDigit(char[] digit,int start,int end){
        long num = 0;

        for(int i = start;i<end;i++){
            //字符剪零 = 数字
            num = num*10 + digit[i] - '0';
        }

        return num;
    }
}
// @lc code=end

