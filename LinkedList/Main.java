// Small demonstration method of some of the classes' functionality

public class Main {
    public static void main(String[] args) {
        LinkedList newList = new LinkedList();

        newList.addLast(new Node(50, null));
        System.out.println(newList.getSize());
    }
}
