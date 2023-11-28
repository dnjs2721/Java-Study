import java.util.EmptyStackException;

public class MyStack<T> {
    private final MyLinkedList<T> linkedList;

    public MyStack() {
        this.linkedList = new MyLinkedList<>();
    }

    public void push(T data) {
        linkedList.add(data);
    }

    public T peek() {
        if (linkedList.size() == 0) {
            throw new EmptyStackException();
        }
        int lastIdx = linkedList.size() - 1;

        return linkedList.get(lastIdx);
    }

    public T pop() {
        if (linkedList.size() == 0) {
            throw new EmptyStackException();
        }
        int lastIdx = linkedList.size() - 1;

        T data = linkedList.get(lastIdx);
        linkedList.delete(lastIdx);

        return data;
    }
}
