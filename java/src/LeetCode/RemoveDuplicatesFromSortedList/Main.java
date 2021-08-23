package LeetCode.RemoveDuplicatesFromSortedList;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 사이트 에서 풀어야함.
    // n 이 null 일 경우 생각해야함.
    void search(ListNode n) {
        // 다음 값이 없으면 마지막이니까 리턴
        if (n == null || n.next == null) return;
        // 현재 값과 다음 값이 같으면
        if (n.val == n.next.val) {
            // 다다음 것과 이어 붙이기
            // 다다음게 없으면 널
            if (n.next.next == null) {
                n.next = null;
            } else {
                n.next = n.next.next;
            }
            // 재귀 호출
            search(n);
        } else {
            // 현재 값과 다음 값이 다르면
            search(n.next);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        search(head);
        return head;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 300; i++) {
            list.add(i % 100);
        }
        Collections.sort(list);
        System.out.println(list.toString());
    }
}
