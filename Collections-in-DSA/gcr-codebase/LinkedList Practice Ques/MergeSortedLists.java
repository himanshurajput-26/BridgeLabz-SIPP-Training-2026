class MergeSortedLists {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(3);
        a.next.next = new Node(5);
        Node b = new Node(2);
        b.next = new Node(4);
        b.next.next = new Node(6);
        Node merged = mergeLogStreams(a, b);
        for (Node n = merged; n != null; n = n.next)
            System.out.print(n.val + " ");
    }
}
