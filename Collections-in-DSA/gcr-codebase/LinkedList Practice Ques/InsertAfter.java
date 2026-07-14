class InsertAfter {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    static void insertAfter(Node current, int trackId) {
        if (current == null) return;
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        insertAfter(head, 2);
        for (Node n = head; n != null; n = n.next)
            System.out.print(n.val + " ");
    }
}
