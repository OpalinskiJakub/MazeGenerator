import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private String mazeSize;
    private String cellSize;

    private String lineColor;

    private String backColor;

    private String time;


    public Menu() {
        setTitle("Maze settings");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel mazeSizeLabel = new JLabel("Maze size:");
        String[] mazeSizeOptions = {"Small", "Medium", "Large"};
        JComboBox<String> mazeSizeComboBox = new JComboBox<>(mazeSizeOptions);
        JLabel cellSizeLabel = new JLabel("Cell size:");
        String[] cellSizeOptions = {"Small", "Medium", "Large"};
        JComboBox<String> cellSizeComboBox = new JComboBox<>(cellSizeOptions);
        JLabel timeLabel = new JLabel("Time per step[sec]:");
        String[] timeOptions = {"0.01", "0.02", "0.04", "0.1", "1", "2"};
        JComboBox<String> timeComboBox = new JComboBox<>(timeOptions);
        JLabel lineColorChoose = new JLabel("Line color:");
        String[] linecolorOptions = {"White", "Green", "Blue", "Black"};
        JComboBox<String> lineColorComboBox = new JComboBox<>(linecolorOptions);
        JLabel backgroudColorChoose = new JLabel("Background color:");
        String[] backColorOptions = {"Black", "Green", "Blue", "White"};
        JComboBox<String> backColorComboBox = new JComboBox<>(backColorOptions);


        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mazeSize = (String) mazeSizeComboBox.getSelectedItem();
                cellSize = (String) cellSizeComboBox.getSelectedItem();
                lineColor = (String) lineColorComboBox.getSelectedItem();
                backColor = (String) backColorComboBox.getSelectedItem();
                time = (String) timeComboBox.getSelectedItem();
                dispose();
            }
        });

        add(mazeSizeLabel);
        add(mazeSizeComboBox);
        add(cellSizeLabel);
        add(cellSizeComboBox);
        add(timeLabel);
        add(timeComboBox);
        add(lineColorChoose);
        add(lineColorComboBox);
        add(backgroudColorChoose);
        add(backColorComboBox);

        add(okButton);

        setVisible(true);
    }

    public int getMazeSize() throws Exception {
        switch (mazeSize) {
            case "Small":
                return 30;
            case "Medium":
                return 40;
            case "Large":
                return 50;
            default:
                throw new Exception();
        }
    }

    public int getCellSize() throws Exception {
        switch (cellSize) {
            case "Small":
                return 10;
            case "Medium":
                return 15;
            case "Large":
                return 20;
            default:
                throw new Exception();
        }
    }

    public Color getLineColor() throws Exception {
        switch (lineColor) {
            case "White":
                return Color.WHITE;
            case "Blue":
                return Color.BLUE;
            case "Green":
                return Color.GREEN;
            case "Black":
                return Color.BLACK;
            default:
                throw new Exception();
        }

    }

    public Color getBackColor() throws Exception {
        switch (backColor) {
            case "White":
                return Color.WHITE;
            case "Blue":
                return Color.BLUE;
            case "Green":
                return Color.GREEN;
            case "Black":
                return Color.BLACK;
            default:
                throw new Exception();
        }
    }

    public int getTime() throws Exception {
        switch (time) {
            case "0.01":
                return 10;
            case "0.02":
                return 20;
            case "0.04":
                return 40;
            case "0.1":
                return 100;
            case "1":
                return 1000;
            case "2":
                return 2000;
            default:
                throw new Exception();
        }
    }

    public MazeSettings getMazeSettings() throws Exception {
        return new MazeSettings(getMazeSize(), getCellSize(), getLineColor(), getBackColor(), getTime());
    }

}
