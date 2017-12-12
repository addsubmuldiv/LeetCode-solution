package easy;

import java.util.Stack;


/**
 * 递归和迭代两种方式，不过他们的遍历顺序不一样，因为迭代算法是进去一个出来一个，然后去看它旁边所有的，都入栈，然后把最后进栈的那个取出来，
 * 再看它旁边所有的
 *
 * 而递归算法是，进去一个，然后把它旁边所有的放进去，在放进去的第一个那里继续相同的过程，然后等到递归栈退回到最初的那个，才开始对第二个进行相同的过程
 *
 * 换句话说，迭代的是后序，递归的是先序
 */
public class Max_Area_of_Island_695 {
    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};

        int ans = 0;
        for (int r0 = 0; r0 < grid.length; r0++) {
            for (int c0 = 0; c0 < grid[0].length; c0++) {
                if (grid[r0][c0] == 1 && !seen[r0][c0]) {   //这个点是陆地而且没有被访问过
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[]{r0, c0});  //当前点入栈，设置为已访问
                    seen[r0][c0] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int r = node[0], c = node[1];
                        shape++;
                        for (int k = 0; k < 4; k++) {   //每次取一个方向,在一个while里面把4个方向都访问一遍
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < grid.length &&
                                    0 <= nc && nc < grid[0].length &&
                                    grid[nr][nc] == 1 && !seen[nr][nc]) {   //当下标没有越界，且是陆地而且没访问过
                                stack.push(new int[]{nr, nc});  //入栈并设置为已访问
                                seen[nr][nc] = true;
                                System.out.println(nr+"  "+nc);
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }
//        1  7
//        1  8
//        1  9
//        3  1
//        2  2
//        4  1
//        3  4
//        4  4
//        3  5
//        4  5
//        4  8
//        4  9
//        4  10
//        5  10
//        3  10
//        7  7
//        6  8
//        7  8
//        6  9



    static int[][] grid;
    static boolean[][] seen;

    public static int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        System.out.println(r+"  "+c);
        return (1 + area(r+1, c) + area(r-1, c)
                + area(r, c-1) + area(r, c+1));
    }

    public static int maxAreaOfIsland_recursive(int[][] grid1) {
        grid = grid1;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
//        0  2
//        0  7
//        1  7
//        1  8
//        1  9
//        2  1
//        3  1
//        4  1
//        2  2
//        2  4
//        3  4
//        4  4
//        4  5
//        3  5
//        3  8
//        4  8
//        4  9
//        4  10
//        5  10
//        3  10
//        6  7
//        7  7
//        7  8
//        6  8
//        6  9








    public static void main(String[] args) {
        int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,1,1,0,1,0,0,0,0,0,0,0,0},
                     {0,1,0,0,1,1,0,0,1,0,1,0,0},
                     {0,1,0,0,1,1,0,0,1,1,1,0,0},
                     {0,0,0,0,0,0,0,0,0,0,1,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res=maxAreaOfIsland_recursive(grid);
        System.out.println(res);
    }
}
