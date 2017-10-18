package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 0:31 2017/10/19
 * @Modified_by:
 */

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


public class Longest_Substring_Without_Repeating_Characters_3 {
    /**
     * 使用集合类Set，每次读一个字符，先检查Set中有没有，没有的话就添加到Set中，然后向后移动j，
     * 如果Set中有的话，就把这个字母从Set中移除，且让i后移
     * sliding window是一种被经常用在解决数组和字符串问题的方法，window通常是用下标标识出的数组或者字符串中的某一段
     * 然后根据需要移动这两个下标
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int res=0;
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                res=Math.max(res,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
