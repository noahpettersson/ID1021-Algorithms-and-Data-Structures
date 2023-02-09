public class arrayQueue {
    BinaryTree.Node[] queue;

    int front = -1;
    int rear = -1;

    int size = 7;
    int test = 5;

    public arrayQueue() {
        this.queue = new BinaryTree.Node[this.size];
    }
    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public void enqueue(BinaryTree.Node node) {
        if((rear + 1) % size == front) {
            BinaryTree.Node[] array = new BinaryTree.Node[this.size*2];
            int temp = 0;
            int i = 0;
            for(i = front; i != rear; i = (i + 1) % size) {
                System.out.println("i: " + i);
                array[temp++] = queue[i];
            }
            array[temp] = queue[i];
            size *= 2;
            front = 0;
            rear = temp;
            queue = array;
            return;
        }
        if(isEmpty())
            front = rear = 0;
        else rear = (rear + 1) % size;
        queue[rear] = node;
    }

    public BinaryTree.Node dequeue() {
        BinaryTree.Node temp = queue[front];
        if(isEmpty())
            return null;
        else if(front == rear)
            front = rear = -1;
        else
            front = (front + 1) % size;
        return temp;
    }
}
