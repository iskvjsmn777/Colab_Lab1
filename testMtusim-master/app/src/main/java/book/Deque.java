package book;

import java.util.ArrayDeque;

class Deque {
    private ArrayDeque<String> deque;

    public Deque() {
        deque = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void addToFront(String element) {
        deque.addFirst(element);
    }

    public void addToBack(String element) {
        deque.addLast(element);
    }

    public String removeFromFront() {
        return deque.pollFirst();
    }

    public String removeFromBack() {
        return deque.pollLast();
    }
}