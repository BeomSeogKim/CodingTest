package ktw.algorithm.graph;

import java.util.LinkedList;

public class GraphExample {
    public static void main(String[] args) {
        Vertex jake = new Vertex("Jake");
        Vertex ben = new Vertex("Ben");
        Vertex joy = new Vertex("Joy");
        Vertex ivy = new Vertex("Ivy");
        Vertex elin = new Vertex("Elin");
        Vertex anna = new Vertex("Anna");
        Vertex david = new Vertex("David");

        jake.addAdjacentVertex(ben);
        ben.addAdjacentVertex(jake);
        joy.addAdjacentVertex(ben);
        joy.addAdjacentVertex(ivy);
        ivy.addAdjacentVertex(joy);
        ivy.addAdjacentVertex(ben);
        elin.addAdjacentVertex(ivy);
        elin.addAdjacentVertex(anna);
        anna.addAdjacentVertex(ben);
        anna.addAdjacentVertex(david);
        anna.addAdjacentVertex(elin);
        david.addAdjacentVertex(anna);
        System.out.println(anna.adjacent_vertices);
        anna.removeAdjacentVertex(david);
        System.out.println(anna.adjacent_vertices);

    }

}

class Vertex{
    private final String value;
    public final LinkedList<Vertex> adjacent_vertices;

    public Vertex(String value) {
        this.value = value;
        adjacent_vertices = new LinkedList<>();
    }

    public void addAdjacentVertex(Vertex vertex) {
        this.adjacent_vertices.add(vertex);
    }

    public void removeAdjacentVertex(Vertex vertex) {
        this.adjacent_vertices.remove(vertex);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value='" + value + '\'' +
                '}';
    }
}
