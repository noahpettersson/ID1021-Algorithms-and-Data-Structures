import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private SecondQueue queue;
    public TreeIterator() {
        queue = new SecondQueue();
        queue.add(BinaryTree.root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        if (hasNext() == false)
            return null;

        BinaryTree.Node current = queue.head.item;
        Integer val = current.value;

        if(current.left != null)
            queue.add(current.left);

        if(current.right != null)
            queue.add(current.right);

        queue.remove();
        return val;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}