package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 23:33 2017/10/18
 * @Modified_by:
 */

/*
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */

/**
 * 这个题，看连续的1最多有几个，不需要保存下每个连续1的个数，只需要遍历一遍，把1增长的次数和当前的
 * res进行比较就好了。
 */
public class Max_Consecutive_Ones_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res=0;
        int count=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1)
                count++;
            else if(nums[i]==0)
                count=0;
            res=Math.max(res,count);
        }
        return res;
    }
}
