import java.util.Random;

class LinkedList {
    Node head;
    Node end;

    class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
    }
    public void add(int new_data) {
        Node new_node = new Node(new_data);
        if(head == null)
            end = new_node;

        new_node.next = head;

        head = new_node;
    }

    public Node remove() {
        Node current = head;
        Node smallest = head;
        Node previous = null;

        while(current.next != null) {
            if(current.next.value < smallest.value) {
                smallest = current.next;
                previous = current;
            }
            current = current.next;
        }
        if(smallest == head) {
            Node temp = smallest;
            head = head.next;
            return temp;
        }
        else {
            previous.next = previous.next.next;
            return smallest;
        }
    }

    public void add2(int new_data) {
        Node new_node = new Node(new_data);
        if(head == null) {
            end = new_node;
            head = end;
        } else {
            if(new_node.value < head.value) {
                new_node.next = head;
                head = new_node;
            } else {
                Node curr = head;
                while(curr.next != null) {
                    if(new_node.value < curr.next.value) {
                        new_node.next = curr.next;
                        curr.next = new_node;
                        return;
                    }
                    curr = curr.next;
                }
                curr.next = new_node;

            }
        }
    }

    public Node remove2() {
        Node temp = head;
        head = head.next;
        return temp;
    }

    public void print() {
        Node node = head;
        System.out.print("[");
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    public LinkedList gen(int n) {
        Random rnd = new Random();
        LinkedList list = new LinkedList();
        for(int i = 0; i < n; i++) {
            list.add(rnd.nextInt(n*5));
        }
        return list;
    }

    public LinkedList gen2(int n) {
        Random rnd = new Random();
        LinkedList list = new LinkedList();
        for(int i = 0; i < n; i++) {
            list.add2(rnd.nextInt(n*5));
        }
        return list;
    }
}
