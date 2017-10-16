package easy;

/**
 * @Author: Lighters_c
 * @Discrpition: 此题太简单，看557的讲解,就会了
 * @Date: Created in 0:38 2017/10/17
 * @Modified_by:
 */

/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */

/**
 * 直接转成字符数组反过来就完了，时间复杂度O(n)
 */

public class Reverse_String_344 {
    public String reverseString(String s) {
        char[] a=s.toCharArray();
        char tmp;
        for(int i=0, j=a.length-1;i<j;i++,j--) {
            tmp=a[i];
            a[i]=a[j];
            a[j]=tmp;
        }
        return new String(a);
    }
}
