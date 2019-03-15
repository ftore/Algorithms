package arrays;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        int numIslands = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;

                    bfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private static void bfs(char[][] grid, int m, int n) {
        if(!(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == '1')) {
            return;
        }

        grid[m][n] = '0';

        int[][] dir = {{-1,0,1,0}, {0,-1,0,1}};
        for (int k = 0; k < 4; k++) {
            bfs(grid, m + dir[1][k], n + dir[0][k]);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }
}
