import java.util.ArrayList;
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

    boolean[] visited = new boolean[N];

    // 세로
    for (int x = 0; x < N; x++) {
      boolean check = true;
      for (int i = 0; i < N; i++) {
        visited[i] = false;
      }
      for (int y = 0; y < N; y++) {
        if (check == false) {
          break;
        }
        if (y == N - 1) {
          way++;
          // System.out.println("---------------------------세로" + x + ", " + way);
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
              if (y + l < N && currHeight - map[y + l][x] == 1 && (visited[y + l] == false)) {
                if (l == L) {
                  for (int i = 1; i <= L; i++) {
                    // map[y + i][x] += 10;
                    visited[y + i] = true;
                  }
                  y += L - 1;
                }
              } else {
                check = false;
                break;
              }
            }
          }

          // 올라가는 판단
          else if (diff == -1) {
            for (int l = 0; l < L; l++) {
              if (y - l >= 0 && nextHeight - map[y - l][x] == 1 && (visited[y - l] == false)) {
                if (l == L - 1) {
                  for (int i = 0; i < L; i++) {
                    // map[y - i][x] += 10;
                    visited[y + i] = true;
                  }
                }
              } else {
                check = false;
                break;
              }
            }
          }

          else {
            check = false;
          }
        }
      }
    }

    // 가로

    for (int y = 0; y < N; y++) {
      boolean check = true;
      for (int i = 0; i < N; i++) {
        visited[i] = false;
      }
      // System.out.println("-----------------------------------" + y);
      for (int x = 0; x < N; x++) {
        if (check == false) {
          break;
        }
        if (x == N - 1) {
          // System.out.println("count: " + y);
          way++;
          // System.out.println("---------------------------가로" + y + ", " + way);
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

          // if (y == 2) {

          // System.out.println("diff: " + diff);
          // }

          if (diff == 1) {
            for (int l = 1; l <= L; l++) {

              if (y == 2) {

                // System.out
                // .println("down if: " + (x + l < N) + (currHeight - map[y][x + l] == 1) +
                // (visited[x + l] == false));
              }

              if (x + l < N && currHeight - map[y][x + l] == 1 && (visited[x + l] == false)) {
                if (l == L) {
                  for (int i = 1; i <= L; i++) {
                    visited[x + i] = true;
                    // map[y][x + i] += 10;
                  }
                  x += L - 1;
                }
              } else {
                check = false;
                break;
              }
            }
          }

          // 올라가는 판단
          else if (diff == -1) {
            for (int l = 0; l < L; l++) {

              // if (y == 2) {

              // System.out
              // .println("up if: " + (x - l >= 0 && nextHeight - map[y][x - l] == 1 &&
              // (visited[x - l] == false)));

              // System.out.println("x + l: " + (x + l));
              // for (int j = 0; j < N; j++) {
              // System.out.print(visited[j] + ", ");
              // }
              // System.out.println();
              // }

              if (x - l >= 0 && nextHeight - map[y][x - l] == 1 && (visited[x - l] == false)) {
                if (l == L - 1) {
                  for (int i = 0; i < L; i++) {
                    visited[x + i] = true;
                    // map[y][x - i] += 10;
                  }
                }
              } else {
                check = false;
                break;
              }
            }
          }

          else {
            check = false;
          }
        }
      }
    }

    System.out.println(way);
    // for (int y = 0; y < N; y++) {
    // for (int x = 0; x < N; x++) {
    // System.out.print(map[y][x]);
    // }
    // System.out.println();
    // }
  }
}