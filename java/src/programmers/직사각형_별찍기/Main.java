package programmers.직사각형_별찍기;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    for (int i = 1; i <= a * b; i++) {
      if ((i % a) == 0 && (i != (a * b))) {
        System.out.print('*');
        System.out.println();
      } else {
        System.out.print('*');
      }
    }
  }
}
