package view;

import control.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.function.Supplier;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.Easy;
import model.Hard;
import model.Medium;

/**
 * @author Ahmed Mahmoud
 */
public class LevelsFrame extends JFrame {
    
    private Image background;
    private JButton easy;
    private JButton medium;
    private JButton hard;

    private final String imageFile = "src//Images//images.jpg";
    private final int buttonWidth = 150;
    private final int buttonHeight = 50;

    public LevelsFrame() {
        initalizeComponents();

        this.setTitle("Levels");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 240));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initalizeComponents() {
        background = new ImageIcon(imageFile).getImage();
        easy = new JButton("Easy");
        medium = new JButton("Medium");
        hard = new JButton("Hard");
        setBackground();
        setEasyButton();
        setMediumButton();
        setHardButton();
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

    private void setEasyButton() {
        easy.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        easy.setFont(new Font("Wide Latin", 0, 18));
        easy.setForeground(new Color(153, 0, 0));

        easy.addActionListener((ActionEvent e) -> {
            // Easy Implementaion
            Easy easyLevel = new Easy();
            Supplier<World> supplier = () -> new Circus(800, 600, easyLevel);
            World game = supplier.get();
            GameEngine.start("Circus Of Plates", game);
        });

        this.add(easy);
    }

    private void setMediumButton() {
        medium.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        medium.setFont(new Font("Wide Latin", 0, 18));
        medium.setForeground(new Color(153, 0, 0));

        medium.addActionListener((ActionEvent e) -> {
            // Medium Implementaion
            Medium mediumLevel = new Medium();
            Supplier<World> supplier = () -> new Circus(800, 600, mediumLevel);
            World game = supplier.get();
            GameEngine.start("Circus Of Plates", game);
        });

        this.add(medium);
    }

    private void setHardButton() {
        hard.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        hard.setFont(new Font("Wide Latin", 0, 18));
        hard.setForeground(new Color(153, 0, 0));

        hard.addActionListener((ActionEvent e) -> {
            // Hard Implementaion
            Hard hardLevel = new Hard();
            Supplier<World> supplier = () -> new Circus(800, 600, hardLevel);
            World game = supplier.get();
            GameEngine.start("Circus Of Plates", game);
        });

        this.add(hard);
    }
}
