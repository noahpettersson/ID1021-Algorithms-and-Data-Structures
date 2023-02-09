import java.util.LinkedList;

public class quicksort {
    /*public static void quicksort(linkedlist.Node low, linkedlist.Node high){
        linkedlist.Node pivot = high;

        linkedlist.Node leftPointer = low;
        linkedlist.Node rightPointer = high;


    }*/

    /*public Linkedlist.Node paritionLast(Linkedlist.Node start, Linkedlist.Node end) {
        if (start == end || start == null || end == null)
            return start;

        linkedlist.Node pivot_prev = start;
        linkedlist.Node curr = start;
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

        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }*/

}
