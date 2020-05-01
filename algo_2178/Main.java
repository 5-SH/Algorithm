import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
  private int y;
  private int x;
  private int step;

  Pair(int y, int x, int step) {
    this.y = y;
    this.x = x;
    this.step = step;
  }

  int getY() {
    return y;
  }

  int getX() {
    return x;
  }

  int getStep() {
    return step;
  }
}

public class Main {
  static int[] dy = { -1, 1, 0, 0 };
  static int[] dx = { 0, 0, -1, 1 };
  static int N;
  static int M;

  static Pair visited(Queue<Pair> queue, int[][] map) {
    // 방문 완료
    Pair visit = queue.poll();
    map[visit.getY()][visit.getX()] = 2;

    return visit;
  }

  // 중복 방문을 막기 위해 방문 예정인 곳이 큐에 있는지 확인
  static boolean checkQueue(Queue<Pair> queue, Pair pos) {
    boolean result = true;
    for (Pair p : queue) {
      if (p.getY() == pos.getY() && p.getX() == pos.getX()) {
        result = false;
      }
    }
    return result;
  }

  static void checkVisit(Pair visit, int[][] map, Queue<Pair> queue) {
    for (int d = 0; d < 4; d++) {
      // 방문할 곳 설정
      int ny = visit.getY() + dy[d];
      int nx = visit.getX() + dx[d];
      if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
        continue;
      }

      // 방문할 곳 추가
      if (map[ny][nx] == 1) {
        if (checkQueue(queue, new Pair(ny, nx, visit.getStep()))) {
          Pair pos = new Pair(ny, nx, visit.getStep() + 1);
          queue.add(pos);
        }
      }
    }
  }

  static int search(Queue<Pair> queue, int[][] map) {
    while (!queue.isEmpty()) {
      // 방문 완료
      Pair visit = visited(queue, map);

      // 최단경로 확인
      if (visit.getY() == N - 1 && visit.getX() == M - 1) {
        return visit.getStep();
      }

      // 방문할 곳 가져오기
      checkVisit(visit, map, queue);
    }

    // 경로 없는 경우
    return -1;
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

    Queue<Pair> queue = new LinkedList<Pair>();
    Pair start = new Pair(0, 0, 1);
    queue.add(start);

    // 탐색
    System.out.println(search(queue, map));
  }
}