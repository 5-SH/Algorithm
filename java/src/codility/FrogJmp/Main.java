package codility.FrogJmp;

import java.util.Scanner;

public class Main {
  public static int solumtion(int X, int Y, int D) {
    if (D == 0) return 0;
    int jump = (Y - X) / D;
    int rest = (Y - X) % D;
    return rest == 0 ? jump : jump + 1;
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    String[] arr = line.trim().split(",");

    System.out.println(solumtion(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
  }
}
