package easy;

import java.util.HashSet;
import java.util.Set;

/**
 *  Given an array of integers, every element appears twice except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_136 {
    /**
     * 超屌的位运算，
     * a^0=a
     * a^a=0
     * a^b^a=b
     *
     * 所以我们可以看出，偶数个数在全部异或起来以后会变成0，
     * 这样的话，只有一个数的那个，在全部异或完就凸显出来了。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a=0;
        for(int x:nums) {
            a^=x;
        }
        return a;
    }
}
