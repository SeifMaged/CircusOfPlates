package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * @author Ahmed Mahmoud
 */
public class StartFrame extends JFrame {

    private Image background;
    private JButton startGame;
    private JButton exitGame;

    private final String starterImageFile = "src/resources/circus10.jpg";
    private final int buttonWidth = 150;
    private final int buttonHeight = 50;

    public StartFrame() {
        initalizeComponents();

        this.setTitle("Circus Of Plates");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 140));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initalizeComponents() {
        background = new ImageIcon(starterImageFile).getImage();
        startGame = new JButton("Start");
        startGame.setFocusable(false);
        exitGame = new JButton("Exit");
        exitGame.setFocusable(false);

        setBackground();
        setStartButton();
        setExitButton();
    }


    private void setBackground() {
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        });
    }

    private void setStartButton() {
        startGame.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        startGame.setFont(new Font("Wide Latin", 0, 18));
        startGame.setForeground(new Color(204, 77, 8));
        startGame.setBackground(new Color(39, 48, 76));

        startGame.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            new LevelsFrame();
        });

        this.add(startGame);
    }

    private void setExitButton() {
        exitGame.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        exitGame.setFont(new Font("Wide Latin", 0, 18)); // NOI18N
        exitGame.setForeground(new Color(204, 77, 8));
        exitGame.setBackground(new Color(39, 48, 76));

        exitGame.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        this.add(exitGame);
    }

    public static void main(String[] args) {
        new StartFrame();
    }
}
