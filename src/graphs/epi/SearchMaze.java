package graphs.epi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchMaze {
    private int[][] maze;
    private boolean[][] visited;
    private boolean pathExists;
    private Graph graph;

    public SearchMaze(int[][] maze) {
        this.maze = maze;
        this.graph = new Graph(maze);
        visited = new boolean[maze.length][maze[0].length];
        pathExists = false;
    }

    public boolean search(int x, int y) {
        dfs(x, y);
        return pathExists;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = x + 1; i < maze.length; i++) {
            for(int j = y; j < maze[0].length; j++) {
                if(!visited[i][j] && maze[i][j] != 1) {
                    dfs(i, j);
                } else if(maze[i][j] == 2) {
                    pathExists = true;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0},
                {0, 1, 1},
                {0, 1, 2}
        };

        SearchMaze searchMaze = new SearchMaze(maze);
        if(searchMaze.search(0, 0)) {
            System.out.println("There is path.");
        } else {
            System.out.println("Oops! There is no path.");
        }
    }

    private class Graph {
        private Map<Integer, List<Integer>> adj;

        public Graph(int[][] maze) {
            adj = new HashMap<>();
            for(int i = 0; i < maze.length; i++) {
                adj.put(i, new ArrayList<>());
            }

            for(int i = 0; i < maze.length; i++) {
                for(int j = 0; j < maze[0].length; j++) {
                    if(maze[i][j] == 0) {
                        adj.get(i).add(j);
                    }
                }
            }
        }

        public List<Integer> adj(int v) {
            return adj.get(v);
        }
    }
}
