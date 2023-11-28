import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currnet = head;
            while (currnet.next != null) {
                currnet = currnet.next;
            }
            currnet.next = newNode;
        }
    }

    public T get(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("잘못된 인덱스");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("범위를 벗어난 인덱스");
            }
            current = current.next;
        }

        return current.data;
    }

    public void delete(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("잘못된 인덱스");
        }
        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("범위를 벗어난 인덱스");
            }
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        int count = 1;

        Node<T> current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T data = current.data;
            current = current.next;

            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }
}
