import java.util.Scanner;

public class Main {
  static int[][] move(int[][] dice, int direction) {
    if (direction == 1) {
      // 동
      int buf = dice[1][0];
      dice[1][0] = dice[3][1];
      dice[3][1] = dice[1][2];
      dice[1][2] = dice[1][1];
      dice[1][1] = buf;

    } else if (direction == 2) {
      // 서
      int buf = dice[1][0];
      dice[1][0] = dice[1][1];
      dice[1][1] = dice[1][2];
      dice[1][2] = dice[3][1];
      dice[3][1] = buf;
    } else if (direction == 3) {
      // 북
      int buf = dice[0][1];
      dice[0][1] = dice[1][1];
      dice[1][1] = dice[2][1];
      dice[2][1] = dice[3][1];
      dice[3][1] = buf;
    } else {
      // 남
      int buf = dice[0][1];
      dice[0][1] = dice[3][1];
      dice[3][1] = dice[2][1];
      dice[2][1] = dice[1][1];
      dice[1][1] = buf;
    }

    return dice;
  }

  static int[] moveCurPos(int x, int y, int N, int M, int direction) {
    if (direction == 1) {
      // 동
      if (x + 1 <= M - 1) {
        x += 1;
      }
    } else if (direction == 2) {
      // 서
      if (x - 1 >= 0) {
        x -= 1;
      }
    } else if (direction == 3) {
      // 북
      if (y - 1 >= 0) {
        y -= 1;
      }
    } else {
      // 남
      if (y + 1 <= N - 1) {
        y += 1;
      }
    }
    int[] ret = { x, y };
    return ret;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int maxN = sc.nextInt();
    int maxM = sc.nextInt();
    int curPosY = sc.nextInt();
    int curPosX = sc.nextInt();
    int orderSize = sc.nextInt();

    int[][] map = new int[maxN][maxM];
    for (int i = 0; i < maxN; i++) {
      for (int j = 0; j < maxM; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    int[] order = new int[orderSize];
    for (int i = 0; i < orderSize; i++) {
      order[i] = sc.nextInt();
    }

    int[][] dice = { { -1, 0, -1 }, { 0, 0, 0 }, { -1, 0, -1 }, { -1, 0, -1 }, };
    for (int i = 0; i < orderSize; i++) {
      int direction = order[i];
      int[] pos = moveCurPos(curPosX, curPosY, maxN, maxM, direction);

      if (pos[0] != curPosX || pos[1] != curPosY) {
        curPosX = pos[0];
        curPosY = pos[1];

        int[][] moveDice = move(dice, direction);
        dice = moveDice;
        if (map[curPosY][curPosX] == 0) {
          map[curPosY][curPosX] = dice[3][1];
        } else {
          dice[3][1] = map[curPosY][curPosX];
          map[curPosY][curPosX] = 0;
        }

        System.out.println(dice[1][1]);
      }
    }
  }
}