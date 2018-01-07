package easy;


/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

 Substrings that occur multiple times are counted the number of times they occur.

 Example 1:
 Input: "00110011"
 Output: 6
 Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

 Notice that some of these substrings repeat and are counted the number of times they occur.

 Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 Example 2:
 Input: "10101"
 Output: 4
 Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 Note:

 s.length will be between 1 and 50,000.
 s will only consist of "0" or "1" characters.
 */
public class Count_Binary_Substrings_696 {
    /**
     * 把每次计数1或者0的个数，和上一次的作对比，取小的加到答案上，最后一次的会由于跳出循环没加上，所以要手动加上
     * @param s
     * @return
     */
    public int countBinarySubStrings(String s) {
        int ans=0,prev=0,cur=1;
        int length=s.length();
        for(int i=1;i<length;i++) {
            if(s.charAt(i)!=s.charAt(i-1)) {
                ans+=Math.min(prev,cur);
                prev=cur;
                cur=1;
            } else {
                cur++;
            }
        }
        return ans+Math.min(prev,cur);
    }
}
