package LeetCode.MergeTwoSortedLists;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode get(ListNode l, int idx) {
        if (idx == 0) {
            return l;
        }
        if (l.next != null) {
            --idx;
            return get(l.next, idx);
        } else {
            return null;
        }
    }

    // 사이트에서 풀어야함
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        boolean finished = false;
        int idx = -1;
        while (!finished) {
            idx++;
            ListNode l = get(l1, idx);
            if (l != null) {
                list1.add(l.val);
            } else {
                break;
            }
        }

        finished = false;
        idx = -1;
        while (!finished) {
            idx++;
            ListNode l = get(l2, idx);
            if (l != null) {
                list1.add(l.val);
            } else {
                break;
            }
        }

        Collections.sort(list1);
        if (list1.size() == 0) return null;
        ListNode start = new ListNode(list1.get(0));
        for (int i = 1; i < list1.size(); i++) {
            ListNode add = new ListNode(list1.get(i));
            get(start, i - 1).next = add;
        }

        return start;
    }
    public static void main(String[] args) {


    }
}
