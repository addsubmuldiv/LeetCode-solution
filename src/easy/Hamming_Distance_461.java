package easy; /**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 0:22 2017/10/12
 * @Modified_by:
 */

/**
 *
 问题如下，就是求两个整数的二进制表示有几个不同的地方
 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 */
public class Hamming_Distance_461 {
    public int hammingDistance(int x, int y) {
        // int count=0;
        // int res=x^y;
        // while(res!=0)
        // {
        //     // if((res&1)==1)
        //     //     count++;
        //     count+=res&1;
        //     res=res>>1;
        // }
        // return count;
        return Integer.bitCount(x^y);
    }
}
/**
 * 这里只要把两个数异或一下然后移位和1按位与进行统计就能算出有几个不同了,也可以直接调库函数,bitCount就是统计有几个1的
 */
