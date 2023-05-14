import java.util.List;
import java.util.Objects;

public class Edge {

    private int x;

    private int y;

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int max() {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    public int min() {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    public static boolean contains(List<Edge> list, int x, int y) {
        Edge edge = new Edge(x, y);
        return list.contains(edge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return x == edge.x && y == edge.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
