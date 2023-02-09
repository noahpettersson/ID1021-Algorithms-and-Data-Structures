public class Queue {
    Node head;

    public class Node {
        public Integer item;
        public Node tail;

        public Node(Integer item, Node list) {
            this.item = item;
            this.tail = list;
        }
    }

    public Queue() {
        this.head = null;
    }

    public void add(Integer item) {
        Node node = new Node(item, head);
        head = node;
    }
    public Integer remove() {
        Node nxt = head;
        while(nxt.tail.tail != null) {
            nxt = nxt.tail;
        }
        Integer temp = nxt.tail.item;
        nxt.tail = null;
        return temp;
    }
}