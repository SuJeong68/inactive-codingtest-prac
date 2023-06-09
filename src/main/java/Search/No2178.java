package Search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2178 {

    private static final int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private static int[][] maze;
    private static Queue<Room> queue = new LinkedList<>();
    private static boolean[][] visited;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = str.charAt(j - 1) == '1' ? 1 : 0;
            }
        }

        visited = new boolean[n + 1][m + 1];
        BFS(new Room(1, 1));

        bw.write(Integer.toString(maze[n][m]));

        bw.close();
        br.close();
    }

    private static void BFS(Room root) {
        visited[root.y][root.x] = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            Room room = queue.poll();
            for (int i = 0; i < 4; i++) {
                int calcX = room.x + direction[i][0];
                int calcY = room.y + direction[i][1];
                if (calcX <= m && room.y + direction[i][1] <= n && maze[calcY][calcX] != 0 && !visited[calcY][calcX]) {
                    visited[calcY][calcX] = true;
                    maze[calcY][calcX] = maze[room.y][room.x] + 1;
                    queue.add(new Room(room.x + direction[i][0], room.y + direction[i][1]));
                }
            }
        }
    }

    private static class Room {
        int x;
        int y;

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}