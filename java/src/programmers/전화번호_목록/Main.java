package programmers.전화번호_목록;

import java.util.*;

public class Main {
  public static boolean solution(String[] phone_book) {
    List<String> pb = new ArrayList<>(Arrays.asList(phone_book));
    pb.sort((a, b) -> {
      if (a.length() > b.length()) return 1;
      if (a.length() < b.length()) return -1;
      return 0;
    });

//    System.out.println(pb.toString());

    for (int i = 0; i < pb.size(); i++) {
      for (int j = i + 1; j < pb.size(); j++) {
        String si = pb.get(i);
        String sj = pb.get(j);
        if (si.length() == sj.length()) continue;
        String target = sj.substring(0, si.length());
//        System.out.println(si + ", " + target + " : " + target.equals(si));
        if (target.equals(si)) return false;
//        if (pb.get(j).contains(pb.get(i))) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String l = in.nextLine();
    String t = l.trim();

    String[] sl = t.substring(1, t.length() - 1).split(",");
    String[] phone_book = new String[sl.length];
    for (int i = 0; i < sl.length; i++) {
      String elem = sl[i].trim();
      phone_book[i] = elem.substring(1, elem.length() - 1);
    }

    System.out.println(solution(phone_book));
  }
}
