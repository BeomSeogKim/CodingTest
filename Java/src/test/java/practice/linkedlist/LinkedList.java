package practice.linkedlist;

import practice.Node;

/**
 * 연결리스트의 추상자료형
 * 1. 모든 데이터 출력 -> printAll()
 * 2. 모든 데이터 제거 -> clear()
 * 3. 인덱스 삽입 -> insertAt(index, data)
 * 4. 마지막 삽입 -> insertLast(data)
 * 5. 인덱스 삭제 -> deleteAt(index)
 * 6. 마지막 삭제 -> deleteLast()
 * 7. 인덱스 읽기 -> getNodeAt(index)
 */
public class LinkedList {

    private Node head;
    public Integer count;

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    public void insertAt(Integer index, Integer data) {
        if (index < 0 || index > this.count) {
            throw new IllegalArgumentException("out of index");
        }
        Node newNode = new Node(data);

        if (this.count == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node currentNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

        this.count++;
    }

    public void insertLast(Integer data) {
        this.insertAt(count, data);
    }

    public Node deleteAt(Integer index) {
        if (index < 0 || index > this.count) {
            throw new IllegalArgumentException("out of index");
        }

        if (index == 0) {
            Node deletedNode = this.head;
            this.head = this.head.next;
            this.count--;
            return deletedNode;
        } else {
            Node currentNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            Node deletedNode = currentNode.next;
            currentNode.next = deletedNode.next;
            this.count--;
            return deletedNode;
        }
    }

    public Node deleteLast() {
        return this.deleteAt(this.count - 1);
    }

    public void printAll() {
        var currentNode = this.head;
        StringBuilder sb = new StringBuilder("[");
        while (currentNode != null) {
            sb.append(currentNode.data);
            currentNode = currentNode.next;

            if (currentNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void clear() {
        this.head = null;
        this.count = 0;
    }
}
