/*
Villar, Alexandra Elyze
FA2.1 CSS124L FOPI01
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    private int shape; // Variable Shape

    public Main() {
        setTitle("Shapes");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int shapeWidth = 150; // Width of the shape
                int shapeHeight = 150; // Height of the shape
                int shapeX = (panelWidth - shapeWidth) / 2; // X position to center the shape
                int shapeY = (panelHeight - shapeHeight) / 2; // Y position to center the shape
                switch (shape) {
                    case 1: // Line
                        g.drawLine(shapeX, shapeY, shapeX + shapeWidth, shapeY + shapeHeight);
                        break;
                    case 2: // Circle
                        g.drawOval(shapeX, shapeY, shapeWidth, shapeHeight);
                        break;
                    case 3: // Rectangle
                        g.drawRect(shapeX, shapeY, shapeWidth, shapeHeight);
                        break;
                }
            }
        };

        JButton lineButton = new JButton("Line");
        JButton circleButton = new JButton("Circle");
        JButton rectangleButton = new JButton("Rectangle");

        // Adding MouseListener to the drawing panel
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Determine the shape based on the mouse position
                int mouseX = e.getX();
                int mouseY = e.getY();
                int panelWidth = drawingPanel.getWidth();
                int panelHeight = drawingPanel.getHeight();
                int shapeWidth = 150; // Width of the shape
                int shapeHeight = 150; // Height of the shape
                int shapeX = (panelWidth - shapeWidth) / 2; // X position to center the shape
                int shapeY = (panelHeight - shapeHeight) / 2; // Y position to center the shape

                if (mouseX >= shapeX && mouseX <= shapeX + shapeWidth &&
                        mouseY >= shapeY && mouseY <= shapeY + shapeHeight) {
                    // Mouse clicked inside the shape area
                    if (mouseY - shapeY <= shapeHeight / 2) {
                        // Clicked in upper half of the shape
                        shape = 1; // Set shape to Line (1)
                    } else {
                        // Clicked in lower half of the shape
                        if (mouseX - shapeX <= shapeWidth / 2) {
                            // Clicked in left half of the shape
                            shape = 2; // Set shape to Circle (2)
                        } else {
                            // Clicked in right half of the shape
                            shape = 3; // Set shape to Rectangle (3)
                        }
                    }
                }

                drawingPanel.repaint(); // Redraw the shape
            }
        });

        // Add action listeners to the buttons
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = 1; // Set shape to Line (1)
                drawingPanel.repaint(); // Redraw the panel
            }
        });

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = 2; // Set shape to Circle (2)
                drawingPanel.repaint(); // Redraw the panel
            }
        });

        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = 3; // Set shape to Rectangle (3)
                drawingPanel.repaint(); // Redraw the panel
            }
        });

        // Add buttons to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(lineButton);
        buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
