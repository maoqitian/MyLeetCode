import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        
        //递归 时间复杂度 时间复杂度： O(3^N * 4^M) 其中 N 是输入数字中对应 3 个字母的数目，M 是输入数字中对应 4 个字母的数目 

        //定义返回数据数组
        

        if(digits == null  || digits.length() == 0){
            return new ArrayList<>();
        }
        //使用map 来存储存储值
        HashMap<Character,String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
    
        mixletter("",0,digits,res,map);

        return res;
    }

    /**
     * 
     * @param temp 拼接的组合
     * @param level 递归层级
     * @param digits 输入参数
     * @param res 返回值
     * @param map 获取组合值 map
     */
    void mixletter(String temp,int level,String digits,List<String> res,HashMap<Character,String> map){

        //递归结束条件
        if(level == digits.length()){
           res.add(temp);
           return;
        }
        //逻辑处理 进入下层递归
        //获取当前层可选数据
        char key = digits.charAt(level);
        String letters = map.get(key);

        for (int i = 0; i < letters.length(); i++) {
            //数据组合进入下层循环
            mixletter(temp+letters.charAt(i), level+1, digits, res, map);
        }
        //数据 reverse
    }
}
// @lc code=end

