import java.util.Scanner;

public class Main {
  static int N = 0;
  static int L = 0;
  static int way = 0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    L = scan.nextInt();

    int[][] map = new int[N][N];
    for (int y = 0; y < N; y++) {
      for (int x = 0; x < N; x++) {
        map[y][x] = scan.nextInt();
      }
    }

    boolean[] installed = new boolean[N];
    // 세로
    for (int x = 0; x < N; x++) {
      boolean hasWay = true;
      for (int i = 0; i < N; i++) {
        // 경사로가 설치되었는지 확인
        installed[i] = false;
      }
      for (int y = 0; y < N; y++) {
        if (hasWay == false) {
          break;
        }
        if (y == N - 1) {
          way++;
          break;
        }

        int currHeight = map[y][x];
        int nextHeight = map[y + 1][x];
        if (nextHeight == currHeight) {
          continue;
        }
        // 내려가는 판단
        else {
          int diff = currHeight - nextHeight;
          if (diff == 1) {
            for (int l = 1; l <= L; l++) {
              if (y + l < N && currHeight - map[y + l][x] == 1 && (installed[y + l] == false)) {
                if (l == L) {
                  for (int i = 1; i <= L; i++) {
                    installed[y + i] = true;
                  }
                  y += L - 1;
                }
              } else {
                hasWay = false;
                break;
              }
            }
          }
          // 올라가는 판단
          else if (diff == -1) {
            for (int l = 0; l < L; l++) {
              if (y - l >= 0 && nextHeight - map[y - l][x] == 1 && (installed[y - l] == false)) {
                if (l == L - 1) {
                  for (int i = 0; i < L; i++) {
                    installed[y - i] = true;
                  }
                }
              } else {
                hasWay = false;
                break;
              }
            }
          } else {
            hasWay = false;
          }
        }
      }
    }

    // 가로
    for (int y = 0; y < N; y++) {
      boolean hasWay = true;
      for (int i = 0; i < N; i++) {
        installed[i] = false;
      }
      for (int x = 0; x < N; x++) {
        if (hasWay == false) {
          break;
        }
        if (x == N - 1) {
          way++;
          break;
        }

        int currHeight = map[y][x];
        int nextHeight = map[y][x + 1];
        if (nextHeight == currHeight) {
          continue;
        }
        // 내려가는 판단
        else {
          int diff = currHeight - nextHeight;
          if (diff == 1) {
            for (int l = 1; l <= L; l++) {
              if (x + l < N && currHeight - map[y][x + l] == 1 && (installed[x + l] == false)) {
                if (l == L) {
                  for (int i = 1; i <= L; i++) {
                    installed[x + i] = true;
                  }
                  x += L - 1;
                }
              } else {
                hasWay = false;
                break;
              }
            }
          }
          // 올라가는 판단
          else if (diff == -1) {
            for (int l = 0; l < L; l++) {
              if (x - l >= 0 && nextHeight - map[y][x - l] == 1 && (installed[x - l] == false)) {
                if (l == L - 1) {
                  for (int i = 0; i < L; i++) {
                    installed[x - i] = true;
                  }
                }
              } else {
                hasWay = false;
                break;
              }
            }
          } else {
            hasWay = false;
          }
        }
      }
    }

    System.out.println(way);
  }
}