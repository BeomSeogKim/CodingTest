## List

> ArrayList, LinkedList 로 구성됨.

### ArrayList

- `ArrayList`는 내부적으로 배열을 사용하여 데이터를 저장합니다.
- 인덱스를 통한 빠른 요소 접근이 가능합니다 (무작위 접근, Random Access).
- 하지만 요소를 추가하거나 삭제할 때, 배열을 재조정해야 하므로 해당 연산이 느릴 수 있습니다.
- 크기가 동적으로 조정됩니다. 필요에 따라 내부 배열의 크기가 증가합니다.

### LinkedList

- LinkedList는 양방향 연결 리스트(Double-Linked List)로 구현됩니다.
- 각 요소는 자신의 이전 및 다음 요소에 대한 참조를 가지고 있습니다.
- 리스트의 중간에 요소를 추가하거나 삭제하는 경우 효율적입니다.
- 하지만 특정 인덱스의 요소에 접근하려면 처음이나 끝에서부터 요소를 순차적으로 탐색해야 하므로 시간이 더 걸릴 수 있습니다.

--- 
사용 예시

```java
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
// 여기에 더 많은 ArrayList 관련 작업들을 수행할 수 있습니다.
    }
}
```

```java
import java.util.LinkedList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("HTML");
        linkedList.add("CSS");
        linkedList.add("JavaScript");
        // 여기에 더 많은 LinkedList 관련 작업들을 수행할 수 있습니다.
    }
}

```

