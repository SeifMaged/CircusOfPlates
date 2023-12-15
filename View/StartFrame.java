package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Ahmed Mahmoud
 */
public class StartFrame extends JFrame {

    private Image background;
    private JButton startGame;
    private JButton exitGame;
    
    private final String imageFile = "room10.jpg";
    private final int buttonWidth = 150;
    private final int buttonHeight = 50;

    public StartFrame() {
        initalizeComponents();
        
        this.setTitle("Circus Of Plates");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(800,600));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 240));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initalizeComponents() {
        background = new ImageIcon(imageFile).getImage();
        startGame = new JButton("Start");
        exitGame = new JButton("Exit");
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
        startGame.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        startGame.setFont(new Font("Wide Latin", 0, 18));
        startGame.setForeground(new Color(153, 0, 0));
        
        startGame.addActionListener((ActionEvent e) -> {
            // Strategy menu
        });

        
        this.add(startGame);
    }

    private void setExitButton() {
        exitGame.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        exitGame.setFont(new Font("Wide Latin", 0, 18)); // NOI18N
        exitGame.setForeground(new Color(153, 0, 0));
        
        exitGame.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        this.add(exitGame);
    }

    public static void main(String[] args) {
        new StartFrame();
    }
}
