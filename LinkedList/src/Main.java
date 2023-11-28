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
    }
}