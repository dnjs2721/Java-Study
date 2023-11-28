public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);

        int val = myLinkedList.get(2);

        myLinkedList.delete(1);

        for (int value : myLinkedList) {
            System.out.println(value);
        }

//        System.out.println(myLinkedList.size());
        System.out.println("---------------");

        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

//        System.out.println(myStack.pop());

        System.out.println("---------------");

        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.add(1);
        myQueue.add(2);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

//        System.out.println(myQueue.poll());
    }
}

//##Main#######################################