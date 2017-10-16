package easy;

/**
 * @Author: Lighters_c
 * @Discrpition: 自己造了个轮子reverse(),很快，打败80%+,原理就是先把字符串转换成char数组，然后每次固定i，移动j,让i和j分别标识
 * 一个单词的首字母和尾字母，然后用自己造的reverse()把这个单词反过来，然后把j的值给i,当前循环结束，i=i+1,然后继续重复上述，将所有的
 * 单词否反过来就ok了
 * @Date: Created in 23:54 2017/10/16
 * @Modified_by:
 */
public class Reverse_Words_in_a_String_III_557 {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}





/*  和我想法一样但是换了API写的，打败50%
    String words[] = s.split(" ");
    StringBuilder res=new StringBuilder();
    for (String word: words)
        res.append(new StringBuffer(word).reverse().toString() + " ");
    return res.toString().trim();
 */






/*  自己写的，打败18%
    public String reverseWords(String s) {
        String[] a=s.split(" ");
        String b="";
        for(int i=0;i<a.length;i++) {
            a[i]=reverse(a[i]);
            b+=a[i];
        }
        return b;
    }
    public static String reverse(String s) {
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString();
    }
 */