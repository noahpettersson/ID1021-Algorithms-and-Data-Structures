import java.util.Random;

class LinkedList {
    Node head;
    Node end;

     class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
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

    /*public Node partitionLast(Node start, Node end) {
        if (start == end || start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.data < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;

        }

        // Swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;

        // Return one previous to current
        // because current is now pointing to pivot
        print();
        return pivot_prev;
    }*/

    public Node part(Node start, Node end) {
         Node pivot = start;
         Node curr = start.next;
         Node store = start;
         Node previous = store;

         while(curr != end.next) {
             if(curr.data < pivot.data) {
                 previous = store;
                 int temp = curr.data;
                 curr.data = store.next.data;
                 store.next.data = temp;

                 store = store.next;
             }
             curr = curr.next;
         }
         int temp = store.data;
         store.data = pivot.data;
         pivot.data = temp;

         return previous;
    }

    /*public Node partition(Node left, Node right) {
        Node pivot = left;
        Node storeindex = pivot; // the rightmost number (between pivot+1 and right)which is less than pivot
        Node index = pivot.next;
        Node prev = storeindex;

        while(index != right.next) {
            if(index.data < pivot.data) {
                prev = storeindex;
                int temp = storeindex.next.data;
                storeindex.next.data = index.data;
                index.data = temp;

                storeindex = storeindex.next;
            }
            index = index.next;
        }
        int temp = storeindex.data;
        storeindex.data = pivot.data;
        pivot.data = temp;

        return prev;

    }*/

    void sort(Node start, Node end) {
        if (start == null || start == end || start == end.next)
            return;

        Node pivot_prev = part(start, end);
        sort(start, pivot_prev);

        if (pivot_prev == start)
            sort(pivot_prev.next, end);

        else if (pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }

    public void print() {
         Node node = head;
        System.out.print("[");
         while(node != null){
             System.out.print(node.data + " ");
             node = node.next;
         }
        System.out.println("]");
    }

    public static LinkedList generate(int n) {
        LinkedList list = new LinkedList();
        Random rnd = new Random();

        for(int i = 0; i < n; i++) {
            list.add(rnd.nextInt(n*5));
        }
        return list;
    }


}