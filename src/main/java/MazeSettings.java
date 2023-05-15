import java.awt.*;

class MazeSettings {
    private int mazeSize;
    private int cellSize;

    private Color lineColor;

    private Color backgroundColor;

    int time;

    public MazeSettings(int mazeSize, int cellSize, Color lineColor, Color backgroundColor, int time) {
        this.mazeSize = mazeSize;
        this.cellSize = cellSize;
        this.lineColor = lineColor;
        this.backgroundColor = backgroundColor;
        this.time = time;
    }

    public int getMazeSize() {
        return mazeSize;
    }

    public void setMazeSize(int mazeSize) {
        this.mazeSize = mazeSize;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}