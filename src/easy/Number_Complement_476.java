package easy; /**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 0:01 2017/10/12
 * @Modified_by:
 */

/**
 问题如下：
 Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:
 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.
 Example 1:
 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 Example 2:
 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output
 */

public class Number_Complement_476 {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);

        /**
         * 同样效果的C语言代码
         * int mask = INT_MAX;
         * while (mask & num) mask <<= 1;
         * return ~mask & ~num;
         */
    }
}
/**
 * 这里使用了一个库函数，Integer.highestOneBit(int) 能返回传入参数除最高位的1以外其他全部置0的整数，所以
 * 只要把这个整数左移1位再减1之后，低位就全1了，再和要求的整数进行按位与运算，就只会把低位的部分取反了
 */
