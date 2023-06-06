package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13460 {

    private static int[][] board;
    private static boolean[][][][] visited;
    private static Queue<Node> queue = new LinkedList<>();
    private static final int[][] ewsn = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static Ball redBallStart;
    private static Ball blueBallStart;

    static class Ball {
        int i;
        int j;

        public Ball(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class Node {
        Ball redBall;
        Ball blueBall;
        int count;

        public Node(Ball redBall, Ball blueBall, int count) {
            this.redBall = redBall;
            this.blueBall = blueBall;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char token = line.charAt(j);
                if (token == 'R') {
                    redBallStart = new Ball(i, j);
                    board[i][j] = 0;
                } else if (token == 'B') {
                    blueBallStart = new Ball(i, j);
                    board[i][j] = 0;
                } else if (token == 'O') {
                    board[i][j] = 1;
                } else if (token == '#') {
                    board[i][j] = -1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        visited[redBallStart.i][redBallStart.j][blueBallStart.i][blueBallStart.j] = true;
        br.close();

        bfs();
    }

    private static void bfs() {
        queue.add(new Node(redBallStart, blueBallStart, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.count >= 10) {
                System.out.println(-1);
                return;
            }

            for (int n = 0; n < 4; n++) {
                boolean redExit = false;
                boolean blueExit = false;
                Ball redBall = new Ball(node.redBall.i, node.redBall.j);
                Ball blueBall = new Ball(node.blueBall.i, node.blueBall.j);

                while (board[redBall.i + ewsn[n][0]][redBall.j + ewsn[n][1]] != -1) {
                    redBall.i += ewsn[n][0];
                    redBall.j += ewsn[n][1];
                    if (board[redBall.i][redBall.j] == 1) {
                        redExit = true;
                        break;
                    }
                }

                while (board[blueBall.i + ewsn[n][0]][blueBall.j + ewsn[n][1]] != -1) {
                    blueBall.i += ewsn[n][0];
                    blueBall.j += ewsn[n][1];
                    if (board[blueBall.i][blueBall.j] == 1) {
                        blueExit = true;
                        break;
                    }
                }

                if (blueExit) {
                    continue;
                } else if (redExit && !blueExit) {
                    System.out.println(node.count + 1);
                    return;
                }

                if (redBall.i == blueBall.i && redBall.j == blueBall.j) {
                    if (n == 0) {
                        if (node.redBall.j < node.blueBall.j) {
                            redBall.j--;
                        } else blueBall.j--;
                    } else if (n == 1) {
                        if (node.redBall.j < node.blueBall.j) {
                            blueBall.j++;
                        } else redBall.j++;
                    } else if (n == 2) {
                        if (node.redBall.i < node.blueBall.i) {
                            redBall.i--;
                        } else blueBall.i--;
                    } else {
                        if (node.redBall.i < node.blueBall.i) {
                            blueBall.i++;
                        } else redBall.i++;
                    }
                }

                if (!visited[redBall.i][redBall.j][blueBall.i][blueBall.j]) {
                    visited[redBall.i][redBall.j][blueBall.i][blueBall.j] = true;
                    queue.add(new Node(redBall, blueBall, node.count + 1));
                }
            }
        }
        System.out.println(-1);
        return;
    }
}
