package easy;

import java.util.Arrays;

/**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 0:42 2017/10/17
 * @Modified_by:
 */

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 */

/**
 * 此题是个脑筋急转弯，问你把这么多数字组成二元组以后选取每个二元组的较小的那一个数字，求他们的和，乍看很难，其实想一想
 * 这样子就按着升序选择下标为偶数的就ok了……所以就遍历一遍加起来   时间复杂度O(n)
 */

public class Array_Partition_I_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
