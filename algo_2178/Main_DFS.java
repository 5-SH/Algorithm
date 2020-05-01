import java.util.Scanner;

/**
 * DFS 는 모든 가능한 경로를 탐색하는데 지수 복잡도가 되어 시간초과 된다. 모든 경로를 탐색하지 않고 각 칸을 한 번씩만 방문하면
 * 처음으로 방문한 경로가 최단 경로라는 보장이 없어 틀린다. => 최단경로는 BFS 로 풀어야 한다.
 */

public class Main_DFS {
  static int N; // y
  static int M; // x

  // 상하좌우
  static int[] dy = { -1, 1, 0, 0 };
  static int[] dx = { 0, 0, -1, 1 };
  static int res = 10001;

  static void move(int[][] map, int y, int x, int step) {
    // 확인
    if (res == N + M - 2) {
      return;
    }
    if (y == N - 1 && x == M - 1) {
      if (step < res) {
        res = step;
      }
      return;
    }

    for (int d = 0; d < 4; d++) {
      // 이동전 방향설정
      int ny = y + dy[d];
      int nx = x + dx[d];
      if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
        continue;
      }

      // 이동
      if (map[ny][nx] == 1) {
        map[ny][nx] = 2;
        move(map, ny, nx, step + 1);
        map[ny][nx] = 1;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    M = scanner.nextInt();

    int[][] map = new int[N][M];

    scanner.nextLine();
    for (int y = 0; y < N; y++) {
      String line = scanner.nextLine();
      for (int x = 0; x < M; x++) {
        map[y][x] = line.charAt(x) - 48;
      }
    }

    map[0][0] = 2;
    move(map, 0, 0, 1);
    System.out.println(res);
  }
}