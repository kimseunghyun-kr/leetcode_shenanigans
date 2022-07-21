import java.util.ArrayList;

class ReverseLL92 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ArrayList<ListNode> NodeArr = new ArrayList<>();
        while (curr != null) {
            NodeArr.add(curr);
            curr = curr.next;
        }

        ListNode firstNode = NodeArr.get(0);
        if (left == 1 || right == NodeArr.size()) {
            ListNode prevStart;
            ListNode nextEnd;

            if (left == 1 && right == NodeArr.size()) {
                prevStart = null;
                nextEnd = null;
            } else {
                if (left == 1) {
                    prevStart = null;
                    nextEnd = NodeArr.get(right);
                } else {
                    prevStart = NodeArr.get(left - 2);
                    nextEnd = null;
                }
            }

            for (int j = left - 1; j < right; j++) {
                if (j == left - 1) {
                    ListNode current2 = NodeArr.get(j);
                    current2.next = nextEnd;

                } else {
                    ListNode current2 = NodeArr.get(j);
                    ListNode nextNode = NodeArr.get(j - 1);
                    current2.next = nextNode;
                    if(nextNode == firstNode) {
                        firstNode = current2;
                    }
                    if (prevStart != null && j == right - 1) {
                        prevStart.next = current2;
                    }
                }
            }

        } else {
            ListNode prevStart = NodeArr.get(left - 2);
            ListNode nextEnd = NodeArr.get(right);
            for (int j = left - 1; j < right; j++) {
                if (j == left - 1) {
                    ListNode current2 = NodeArr.get(j);
                    current2.next = nextEnd;
                } else {
                    ListNode current2 = NodeArr.get(j);
                    current2.next = NodeArr.get(j - 1);
                    if (j == right - 1) {
                        prevStart.next = current2;
                    }
                }
            }
        }
        return firstNode;

    }

    public static void main(String[] args) {
        ReverseLL92 test = new ReverseLL92();
        ListNode temp = test.new ListNode(5);
        ListNode head = test.new ListNode(3, temp);
        ListNode ans = test.reverseBetween(head, 1, 2);
    }

}