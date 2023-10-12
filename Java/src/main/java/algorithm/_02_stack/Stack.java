package algorithm._02_stack;

import algorithm._01_linkedlist.LinkdedList;
import algorithm._01_linkedlist.Node;

/**
 * Stack의 추상자료형
 * push : 데이터 삽입
 * pop : 데이터 제거
 * peek : 데이터 참조
 * isEmpty : 비었는지 체크
 */
public class Stack {

    private LinkdedList linkedList;

    public Stack() {
        this.linkedList = new LinkdedList();
    }

    public void push(Integer data) {
        this.linkedList.insertAt(0, data);
    }

    public Node pop() {
        try {
            return this.linkedList.deleteAt(0);
        } catch (Exception e) {
            return null;
        }
    }

    public Node peek() {
        return this.linkedList.getNodeAt(0);
    }

    public boolean isEmpty() {
        return this.linkedList.count == 0;
    }

}
