import java.util.Scanner;

class Main {
  static int N = 0;
  static int M = 0;
  static int[] dy = { -1, 1, 0, 0 };
  static int[] dx = { 0, 0, -1, 1 };

  static int[][] copyMap(int[][] map) {
    int[][] copyMap = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        copyMap[i][j] = map[i][j];
      }
    }

    return copyMap;
  }

  static int virus(int[][] map) {
    for (int y = 0; y < N; y++) {
      for (int x = 0; x < M; x++) {
        if (map[y][x] == 2) {
          spread(map, y, x);
        }
      }
    }

    return safe(map);
  }

  static void spread(int[][] map, int y, int x) {
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
        continue;
      }

      if (map[ny][nx] == 0) {
        map[ny][nx] = 2;
        spread(map, ny, nx);
      }
    }
  }

  static int safe(int[][] map) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0)
          count++;
      }
    }

    return count;
  }

  static int wall(int[][] map, int count) {
    int result = 0;
    if (count == 3) {
      int[][] copyMap = copyMap(map);
      return virus(copyMap);
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          int safe = wall(map, count + 1);

          map[i][j] = 0;

          if (safe > result)
            result = safe;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 세로
    M = sc.nextInt(); // 가로
    int[][] map = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int m = sc.nextInt();
        map[i][j] = m;
      }
    }

    System.out.println(wall(map, 0));
  }
}