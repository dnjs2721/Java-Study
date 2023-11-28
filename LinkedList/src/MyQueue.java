import java.util.EmptyStackException;

public class MyQueue<T> {
    private final MyLinkedList<T> linkedList;

    public MyQueue() {
        this.linkedList = new MyLinkedList<>();
    }

    public void add(T data) {
        linkedList.add(data);
    }

    public T peek() {
        if (linkedList.size() == 0) {
            throw new EmptyStackException();
        }
        return linkedList.get(0);
    }

    public T poll() {
        if (linkedList.size() == 0) {
            throw new EmptyStackException();
        }
        T data = linkedList.get(0);
        linkedList.delete(0);

        return data;
    }
}
