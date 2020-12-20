/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {


         //贪心 + 栈 使用数组代替栈
         boolean []visit = new boolean[26];

         int []num = new int[26];
         
         for(int i = 0; i < s.length();i++){
             num[s.charAt(i) - 'a']++;
         }

         StringBuilder sb = new StringBuilder();
         
         for(int i = 0;i < s.length();i++){
             char ch = s.charAt(i);
             if(!visit[ch - 'a']){
                while(sb.length()> 0 && sb.charAt(sb.length()-1) > ch){
                   if(num[sb.charAt(sb.length()-1)-'a'] > 0){
                    visit[sb.charAt(sb.length()-1)-'a'] = false;
                    sb.deleteCharAt(sb.length()-1);
                   }else{
                     break;
                   }
                }
                visit[ch - 'a'] = true;
                sb.append(ch);
             }
             num[ch-'a'] -= 1;
         }
         return sb.toString();
    }
}
// @lc code=end

