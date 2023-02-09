import java.util.Random;

public class dList {
    Node head;

    public class Node {
        public Node prev, next;

        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void remove2(Node node) {
        if (node == head) {
            head = head.next;
            //node.next = null;
        }
        else if (node.next == null) {
            node.prev.next = null;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void add(int data) {
        if (head == null)
            head = new Node(data);
        else {
            Node node = new Node(data);
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public static dList gen(int n) {
        Random rnd = new Random();
        dList d = new dList();
        for (int i = 0; i <= n; i++) {
            d.add(rnd.nextInt(5 * n));
        }
        return d;
    }

    public void printout() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

}