import java.util.ArrayList;

import DefaultCode.ListNode;

class PartitionList86 {

    public ListNode partition(ListNode head, int x) {
        ListNode lessThan = null;
        ListNode moreThan = null;
        ListNode lessThanF = null;
        ListNode moreThanF = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (lessThan == null) {
                    ListNode starter = new ListNode(curr.val);
                    lessThan = starter;
                    lessThanF = starter;
                } else {
                    ListNode newnew = new ListNode(curr.val);
                    lessThan.next = newnew;
                    lessThan = lessThan.next;
                }
            } else {
                if (moreThan == null) {
                    ListNode starter = new ListNode(curr.val);
                    moreThan = starter;
                    moreThanF = starter;
                } else {
                    ListNode newnew = new ListNode(curr.val);
                    moreThan.next = newnew;
                    moreThan = moreThan.next;
                }
            }
            curr = curr.next;
        }

        if (lessThan != null) {
            lessThan.next = moreThanF;
        } else {

            if (moreThan != null) {
                moreThan.next = null;
            }

        }

        return lessThanF == null ? moreThanF : lessThanF;
    }

    public ListNode partitionLegacy(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ArrayList<ListNode> greaterThan = new ArrayList<>();
        ArrayList<ListNode> lessThan = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                lessThan.add(curr);
                if (lessThan.size() > 1) {
                    ListNode prevL = lessThan.get(lessThan.size() - 2);
                    prevL.next = curr;
                }
            } else {
                greaterThan.add(curr);
                if (greaterThan.size() > 1) {
                    ListNode prevG = greaterThan.get(greaterThan.size() - 2);
                    prevG.next = curr;
                }
            }
            curr = curr.next;
        }
        ListNode firstNode = null;
        ListNode lastSmallest = lessThan.isEmpty() ? null : lessThan.get(lessThan.size() - 1);
        ListNode greatestFirst = greaterThan.isEmpty() ? null : greaterThan.get(0);

        if (lastSmallest != null) {
            // lessThan not empty
            if (greatestFirst != null) {
                // greatherThan and lessThan not empty
                lastSmallest.next = greatestFirst;
                greaterThan.get(greaterThan.size() - 1).next = null;
            }
            // greaterThan empty
            firstNode = lessThan.get(0);
        } else {
            // lessThan empty;
            if (greatestFirst != null) {
                firstNode = greaterThan.get(0);
            }
        }

        return firstNode;
    }

    public static void main(String[] args) {
        PartitionList86 test = new PartitionList86();
        ListNode ans = test.partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2)))), 2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}