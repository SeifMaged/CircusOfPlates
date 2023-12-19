package view;

import control.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

/**
 * @author Ahmed Mahmoud
 */
public class StartFrame extends JFrame {

    private GameEngine.GameController controller;

    private Image background;
    private JButton startGame;
    private JButton exitGame;

    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem pauseItem;
    private JMenuItem resumeItem;

    private final String starterImageFile = "src/resources/circus10.jpg";
    private final String soundFile = "src/resources/circus.wav";
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
        exitGame = new JButton("Exit");

        menubar = new JMenuBar();
        menu = new JMenu("Options");
        pauseItem = new JMenuItem("Pause");
        resumeItem = new JMenuItem("Resume");

        menu.add(pauseItem);
        menu.add(resumeItem);
        menubar.add(menu);

        pauseItem.addActionListener((ActionEvent e) -> {
            if (e.getSource() == pauseItem) {
                controller.pause();
            }
        });

        resumeItem.addActionListener((ActionEvent e) -> {
            if (e.getSource() == resumeItem) {
                controller.resume();
            }
        });
        menu.add(pauseItem);
        menu.add(resumeItem);

        setBackground();
        setStartButton();
        setExitButton();
    }

    public static void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);

            // Loop the sound
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error loading sound");
        }
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
        startGame.setBackground(new Color(39,48,76));

        startGame.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            Circus game = Circus.getInstance();
            controller = GameEngine.start("Circus Of Plates", game, menubar);
            playSound(soundFile);
        });

        this.add(startGame);
    }

    private void setExitButton() {
        exitGame.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        exitGame.setFont(new Font("Wide Latin", 0, 18)); // NOI18N
        exitGame.setForeground(new Color(204, 77, 8));
        exitGame.setBackground(new Color(39,48,76));

        exitGame.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        this.add(exitGame);
    }

    public static void main(String[] args) {
        new StartFrame();
    }
}
