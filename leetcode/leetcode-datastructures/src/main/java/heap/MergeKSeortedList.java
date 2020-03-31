package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSeortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null)
                heap.add(head);
        }

        ListNode root = new ListNode(0);
        ListNode res = root;
        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            root.next = poll;
            root = root.next;
            if (poll.next != null)
                heap.add(poll.next);

        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.createSinglyLinkedList(Arrays.asList(1, 3, 5, 7, 11));
        ListNode head2 = ListNode.createSinglyLinkedList(Arrays.asList(2, 8, 12));
        ListNode head3 = ListNode.createSinglyLinkedList(Arrays.asList(4, 6, 9, 10));
        ListNode[] lists = new ListNode[]{head1, head2, head3};
        System.out.println(mergeKLists(lists));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode createSinglyLinkedList(List<Integer> listValues) {
            if (listValues == null || listValues.size() == 0) {
                throw new IllegalArgumentException(
                        "Please pass in a valid listValues to create a singly linked list.");
            }
            ListNode head = new ListNode(listValues.get(0));
            ListNode tmp = head;
            for (int i = 1; i < listValues.size(); i++) {
                ListNode next = new ListNode(listValues.get(i));
                tmp.next = next;
                tmp = tmp.next;
            }
            return head;
        }
    }

}
