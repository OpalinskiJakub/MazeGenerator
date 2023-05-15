import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Generator {

    private static final Random random = new Random();
    private final List<Edge> edgeList = new ArrayList<>();
    private final HashMap<Integer, Boolean> vertices = new HashMap<>();
    private final List<Edge> actualVerticesToVisit = new ArrayList<>();

    private final int width;

    private final int height;

    private final int cellSize;

    public Generator(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
    }

    public List<Edge> generate() {


        for (int i = 0; i < width * height; i++) {
            vertices.put(i, false);
        }
        vertices.put(0, true);
        Edge initEdge = new Edge(0, 1);
        actualVerticesToVisit.add(initEdge);
        initEdge = new Edge(0, width);
        actualVerticesToVisit.add(initEdge);
        while (actualVerticesToVisit.size() > 0) {
            Edge edge = actualVerticesToVisit.remove(random.nextInt(actualVerticesToVisit.size()));
            if (!vertices.get(edge.getY())) {
                add(edge);
            }
        }

        return edgeList;
    }

    private int compareTwoIntegers(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    private void add(Edge edge) {
        if (edge.getX() > edge.getY())
            edgeList.add(new Edge(edge.getY(), edge.getX()));
        else
            edgeList.add(edge);

        vertices.put(edge.getY(), true);
        int left = edge.getY() - 1;
        int right = edge.getY() + 1;
        int up = edge.getY() - width;
        int down = edge.getY() + width;
        if ((up > 0) && (!vertices.get(up))) {
            actualVerticesToVisit.add(new Edge(edge.getY(), up));
        }
        if ((left % width != width - 1) && (!vertices.get(left))) {
            actualVerticesToVisit.add(new Edge(edge.getY(), left));
        }
        if ((right % width != 0) && (!vertices.get(right))) {
            actualVerticesToVisit.add(new Edge(edge.getY(), right));
        }

        if ((down < width * height) && (!vertices.get(down))) {
            actualVerticesToVisit.add(new Edge(edge.getY(), down));
        }


    }

    public int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    public int min(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }


}
