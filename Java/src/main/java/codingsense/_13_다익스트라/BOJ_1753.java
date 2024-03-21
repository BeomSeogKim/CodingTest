package codingsense._13_다익스트라;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753 {

    static List[] lists;
    static int[] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt() - 1;
        lists = new ArrayList[V];
        dist = new int[V];

        // Initializing
        for (int i = 0; i < V; i++) {
            lists[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            lists[u].add(new Node(v, w));
        }

        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int num : dist) {
            if (num == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(num).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int len = lists[now.value].size();
            for (int i = 0; i < len; i++) {
                Node next = (Node) lists[now.value].get(i);
                if (dist[next.value] > now.weight + next.weight) {
                    dist[next.value] = now.weight + next.weight;
                    pq.add(new Node(next.value, dist[next.value]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int value;
    int weight;

    public Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
