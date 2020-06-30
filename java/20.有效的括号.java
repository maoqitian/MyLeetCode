import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {


        //思路一 ：暴力破解 迭代替换 将符合成对的字符串替换成 “” 

        // if(s.length()%2 != 0 ){
        //    return false;
        // }

        // while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
        //     s = s.replace("()", "");
        //     s = s.replace("{}", "");
        //     s = s.replace("[]", "");
        //     }

        // return s.isEmpty();


        //方法二 使用 栈 先进后出 使用一个栈来存放 遍历的元素 

        //使用栈 先进后出特点 时间复杂度 O（n）
        Stack<Character> stack = new Stack<>();

        //开始先遍历 存入相对立的括号符

        for(char c : s.toCharArray()){
            
            if(c == '('){
               stack.push(')');
            }else if (c == '['){
               stack.push(']');
            }else if (c == '{'){
               stack.push('}');
            }else if (stack.isEmpty() || stack.pop()!=c){
                //如果栈为空，说明前面没有匹配到任何符合
                //如果出栈之后的元素没有对等，说明不是闭合
                return false;
            }
        }
        //如果栈为空 说明匹配成功 
        return stack.isEmpty();

    }



    }
}
// @lc code=end

