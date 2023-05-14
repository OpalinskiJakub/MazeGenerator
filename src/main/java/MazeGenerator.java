import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MazeGenerator extends Canvas {

    private final Generator generator;

    private final int width;

    private final int height;

    private final int cellSize;

    private Color backgroundColor;

    private Color lineColor;

    private List<Edge> edges = new ArrayList<>();

    private List<Edge> subMaze = new ArrayList<>();

    Timer timer;

    public MazeGenerator(int width, int height, int cellSize, Color backgroundColor,Color lineColor) {
        this.generator = new Generator(width, height, cellSize);
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
    }

    public void paint(Graphics g) {

        super.paint(g);

        g.setColor(backgroundColor);
        g.fillRect(0, 0, width * cellSize, height * cellSize);
        g.setColor(lineColor);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int up = (y * width) + x;
                int down = ((y + 1) * width) + x;
                if (!Edge.contains(subMaze,up,down)){
                    g.drawLine(x * cellSize, (y + 1) * cellSize, (x + 1) * cellSize, (y + 1) * cellSize);
                }
                int right = (y * width) + x;
                int left = right+1;
                if (!Edge.contains(subMaze,right,left)){
                    g.drawLine((x + 1) * cellSize, y * cellSize, (x + 1) * cellSize, (y + 1) * cellSize);
                }


            }

        }

    }


    public void createMaze() {

        edges = generator.generate();
        ActionListener actionListener = new ActionListener() {
            int size = 0 ;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (size < edges.size()) {
                    size++;
                    subMaze = edges.subList(0,size);
                    repaint();

                } else {
                    timer.stop();
                }
            }
        };
        timer = new Timer(70,actionListener);


        timer.start();
    }

    public static void main(String[] args) {

        
    }
}
