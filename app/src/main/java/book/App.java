import java.util.ArrayDeque;

public class Main {
    private ArrayDeque<String> deque;

    public BookDeque() {
        deque = new ArrayDeque<>();
    }

    public void addToBack(String element) {
        deque.addLast(element);
    }

    public String removeFromFront() {
        return deque.pollFirst();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void insertInOrder(String element) {
        ArrayDeque<String> tempDeque = new ArrayDeque<>();

        while (!deque.isEmpty() && deque.peekFirst().compareTo(element) < 0) {
            tempDeque.addLast(deque.pollFirst());
        }

        deque.addFirst(element);

        while (!tempDeque.isEmpty()) {
            deque.addFirst(tempDeque.pollLast());
        }
    }
}