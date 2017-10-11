package easy; /**
 * @Author: Lighters_c
 * @Discrpition:
 * @Date: Created in 0:30 2017/10/12
 * @Modified_by:
 */


/**
 *
 问题如下：
 Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

 The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

 Example 1:
 Input: "UD"
 Output: true
 Example 2:
 Input: "LL"
 Output: false
 */


public class Judge_Route_Circle_657 {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        int length=moves.length();
        for(int i=0;i<length;i++){
            char chari=moves.charAt(i);
            switch (chari){
                case 'L':x--;break;
                case 'U':y++;break;
                case 'R':x++;break;
                case 'D':y--;break;
                default:break;
            }
        }
        return x==0&&y==0;
    }
}

/**
 * 使用两个变量来解决，简单……不多提了
 */
