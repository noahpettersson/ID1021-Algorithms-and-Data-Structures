public class SecondQueue {
    Node head;
    Node Qtail;

    public class Node {
        public BinaryTree.Node item;
        public Node tail;

        public Node(BinaryTree.Node item, Node list) {
            this.item = item;
            this.tail = list;
        }
    }

    public SecondQueue() {
        this.head = null;
        this.Qtail = null;
    }

    public void add(BinaryTree.Node item) {
        Node node = new Node(item, null);
        if(Qtail == null) {
            head = Qtail = node;
        } else {
            Qtail.tail = node;
            Qtail = node;
        }

    }
    public BinaryTree.Node remove() {
        if(head == null)
            return null;

        BinaryTree.Node temp = head.item;
        if(head == Qtail) {
            head = null;
            Qtail = null;
            return temp;
        }

        head = head.tail;
        return temp;
    }

    public boolean isEmpty() {
        if(head != null || Qtail != null)
            return false;
        else return true;
    }
}