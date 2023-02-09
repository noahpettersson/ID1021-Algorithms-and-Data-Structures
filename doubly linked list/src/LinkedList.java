import java.util.Random;

public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }

    public int head() {
        return this.head;
    }

    public LinkedList tail() {
        return this.tail;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public static LinkedList generate (int n) {
        Random rnd = new Random();
        LinkedList b = new LinkedList(rnd.nextInt(n*5), null);
        for(int i = 0; i < n-1; i++) {
            b.append(new LinkedList(rnd.nextInt(n*5),null));
        }
        return b;
    }

    public int pop() {
        int a = main.top.head;
        main.top = main.top.tail;
        return a;
    }

    public void push (int a) {
        LinkedList n = new LinkedList(a, main.top);
        main.top = n;
    }

    public static void printout(LinkedList a){
        while (a.tail != null) {
            System.out.println(a.head) ;
            a = a.tail;
        }
        System.out.println(a.head) ;
    }

    public void add (LinkedList list, int index) {
        LinkedList nxt = this;
        int temp = 0;

        if (index == 0) {
            list.tail = main.top;
            main.top = list;
            return;
        }

        while (nxt.tail != null) {
            temp++;
            if(index == temp) {
                list.tail = nxt.tail;
                nxt.tail = list;
                return;
            }
            nxt = nxt.tail;
        }
        nxt.tail = list;
    }

    public void remove (int index) {
        LinkedList nxt = this;
        int temp = 0;

        if(index == 0) {
            main.top = main.top.tail;
            return;
        }

        while(nxt.tail != null) {
            temp++;
            if(temp == index) {
                nxt.tail = nxt.tail.tail;
                return;
            }
            nxt = nxt.tail;
        }
    }

}
