package ktw.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieExample {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("고등어");
        trie.insert("김치");
        trie.insert("김치찜");
        trie.insert("김치찌개");

        System.out.println("==== 두부 검색 ====");
        System.out.println(trie.search("두부"));
        System.out.println("==== 김치 검색 ====");
        System.out.println(trie.search("김치"));

        System.out.println("==== 모든 단어 검색 ====");
        for (String word : trie.getAllWords(null, "", null)) {
            System.out.println(word);
        }

        System.out.println("==== 자동 완성 ====");
        List<String> words = trie.autoComplete("김");
        for (String word : words) {
            System.out.println("word = " + word);
        }
    }

}

class Trie{
    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node currentNode = this.root;
        for (char c : word.toCharArray()) {
            if (currentNode.children.get(c) != null) {
                currentNode = currentNode.children.get(c);
            } else {
                Node newNode = new Node();
                currentNode.children.put(c, newNode);
                currentNode = newNode;
            }
        }
        currentNode.children.put('*', null);   // 마지막
    }

    public Node search(String word) {
        Node currentNode = this.root;
        for (char c : word.toCharArray()) {
            if (currentNode.children.get(c) != null) {
                currentNode = currentNode.children.get(c);
            } else {
                return null;
            }
        }
        return currentNode;
    }

    // 해당 노드부터 시작해 하위 모든 노드를 순회하며 단어를 출력하는 함수
    public List<String> getAllWords(Node startNode, String word, List<String> words) {
        if (words == null) {
            words = new ArrayList<>();
        }
        Node currentNode = this.root;
        if (startNode != null) {
            currentNode = startNode;
        }

        for (char key : currentNode.children.keySet()) {
            if (key == '*') {
                words.add(word);
            } else {
                Node childNode = currentNode.children.get(key);
                this.getAllWords(childNode, word + key, words);
            }
        }
        return words;
    }

    // 자동 완성 기능
    public List<String> autoComplete(String word) {
        Node currentNode = this.search(word);
        if (currentNode == null) {
            return null;
        }
        return this.getAllWords(currentNode, word, null);
    }
}

class Node {
    public Map<Character, Node> children;

    public Node() {
        this.children = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "children=" + children +
                '}';
    }
}
