/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {

        //使用 HashMap 存储对应值元素 时间复杂度 O(n)
        if(s == null) return false;
        String[] ss = s.split(" ");
        if(pattern.length()!=ss.length) return false;

        HashMap<Character,String> map = new HashMap<>();

        for(int i =0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                //前面已经有相同的值传入 查看值是否和当前相等
                //不相等说明不对应
                if(!map.get(c).equals(ss[i])) return false;
            }else{
                //key 不存在 查看是否有对应的值存在
                if(map.containsValue(ss[i])){
                  //有相同的值存在 key 不同说明也不对应
                  return false;
                }else{
                    map.put(c,ss[i]);
                }
            }
        }

        return true;
    }
}
// @lc code=end

