package view;

import control.*;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 * @author Ahmed Mahmoud
 */
public class LevelsFrame extends JFrame{

    private static GameEngine.GameController controller;

    private JPanel panel;
    private Image background;
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    

    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem pauseItem;
    private JMenuItem resumeItem;
    
    private final String backgroundFile = "src/resources/levels.png";
    private final String sound = "src/resources/circus.wav";
    private final int buttonWidth = 200;
    private final int buttonHeight = 50;
    
    public LevelsFrame() {
        initalizeComponents();

        this.setTitle("Circus Of Plates");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 230));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initalizeComponents() {
        background = new ImageIcon(backgroundFile).getImage();
        
        panel = new JPanel();
        GridLayout layout = new GridLayout();
        layout.setRows(3);
        layout.setColumns(1);
        layout.setVgap(20);
        panel.setOpaque(false);
        panel.setLayout(layout);
        
        easyButton = new JButton("Easy");
        easyButton.setFocusable(false);
        mediumButton = new JButton("Medium");
        mediumButton.setFocusable(false);
        hardButton = new JButton("Hard");
        hardButton.setFocusable(false);

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
        setEasyButton();
        setMediumButton();
        setHardButton();
        this.add(panel);
    }

    public void playSound(String soundFilePath) {
        
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

    private void setEasyButton() {
        setButton(easyButton);

        easyButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            Circus game = new Circus(new Easy());
            controller = GameEngine.start("Circus Of Plates", game, menubar);
            playSound(sound);
        });
        
//        this.add(easyButton);
    }

    private void setMediumButton() {
        setButton(mediumButton);

        mediumButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            Circus game = new Circus(new Medium());
            controller = GameEngine.start("Circus Of Plates", game, menubar);
            playSound(sound);
        });
        
//        this.add(mediumButton);
    }
    
    private void setHardButton() {
        setButton(hardButton);

        hardButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            Circus game = new Circus(new Hard());
            controller = GameEngine.start("Circus Of Plates", game, menubar);
            playSound(sound);
        });
        
//        this.add(hardButton);
    }
    
    
    private void setButton(JButton button) {
        button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button.setFont(new Font("Wide Latin", 0, 18));
        button.setBackground(new Color(12, 55, 36));
        button.setForeground(new Color(188, 230, 211));
        panel.add(button);
    }

    public static GameEngine.GameController getController() {
        return controller;
    }
}
