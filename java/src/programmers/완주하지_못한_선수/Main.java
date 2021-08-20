package programmers.완주하지_못한_선수;

import java.util.*;

public class Main {

  static String solution(String[] participant, String[] completion) {
    List<String> pl = new ArrayList<>(Arrays.asList(participant));
    List<String> cl = new ArrayList<>(Arrays.asList(completion));

    Collections.sort(pl);
    Collections.sort(cl);

    for (int i = 0; i < pl.size() - 1; i++) {
      if (!pl.get(i).equals(cl.get(i))) {
        return pl.get(i);

      }
    }
    return pl.get(pl.size() - 1);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String participant = in.nextLine().trim();
    String completion = in.nextLine().trim();


    String[] p = participant.substring(1, participant.length() - 1).split(",");
    ArrayList<String> pv = new ArrayList<>();
    for (String r : p) {
      String t = r.trim();
      pv.add(t.substring(1, t.length() - 1));
    }

    String[] c = completion.substring(1, completion.length() - 1).split(",");
    ArrayList<String> cv = new ArrayList<>();
    for (String r : c) {
      String t = r.trim();
      cv.add(t.substring(1, t.length() - 1));
    }

    System.out.println(solution(pv.toArray(new String[pv.size()]), cv.toArray(new String[cv.size()])));
  }



}
