/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {

        //时间复杂度 O(n)

        //把一个小值放在大值的左边，就是做减法，否则为加法
        HashMap<Character,Integer> map = new HashMap();

        map.put('I',1); 
        map.put('V',5); 
        map.put('X',10); 
        map.put('L',50); 
        map.put('C',100); 
        map.put('D',500); 
        map.put('M',1000); 

        int res = 0;

        int preNum = map.get(s.charAt(0));

        for(int i = 1;i< s.length();i++){
            int currNum = map.get(s.charAt(i));
           if(preNum < currNum){
               //前一个值大于后一个值
               res -= preNum;
           }else{
               res += preNum;
           }
           //更新前一个值
           preNum = currNum;
        }

        res += preNum;

        return res;
    }
}
// @lc code=end

