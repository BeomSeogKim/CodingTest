package algorithm._01_linkedlist;


public class Executor {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        System.out.println(node1.data);
        System.out.println(node1.next.data);
        System.out.println(node1.next.next.data);

        LinkdedList linkdedList = new LinkdedList();

        System.out.println("===== insertAt() 다섯 번 호출 =====");
        linkdedList.insertAt(0,0);
        linkdedList.insertAt(1,1);
        linkdedList.insertAt(2,2);
        linkdedList.insertAt(3,3);
        linkdedList.insertAt(4,4);

        linkdedList.printAll();

        System.out.println("===== clear() 호출 =====");
        linkdedList.clear();
        linkdedList.printAll();

        System.out.println("===== insertLast() 세번 호출 =====");
        linkdedList.insertLast(0);
        linkdedList.insertLast(1);
        linkdedList.insertLast(2);
        linkdedList.printAll();

        System.out.println("===== deleteAt() 호출 =====");
        linkdedList.deleteAt(0);
        linkdedList.printAll();
        linkdedList.deleteAt(1);
        linkdedList.printAll();

        System.out.println("===== deleteLast() 호출 =====");
        linkdedList.insertLast(5);
        linkdedList.deleteLast();
        linkdedList.deleteLast();
        linkdedList.printAll();

        System.out.println("===== getNodeAt() 호출 =====");
        linkdedList.insertLast(1);
        linkdedList.insertLast(2);
        linkdedList.insertLast(3);
        linkdedList.insertLast(4);
        linkdedList.insertLast(5);
        linkdedList.insertLast(6);

        Node node = linkdedList.getNodeAt(2);
        System.out.println(node.data);
    }
}
