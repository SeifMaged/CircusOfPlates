package view;

import control.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.Easy;

/**
 *
 * @author Ahmed Mahmoud
 */
public class Main {

    private static GameEngine.GameController controller;
    
    public static void main(String[] args) {
        // TODO code application logic here

        JMenuBar menubar = new JMenuBar();

        JMenu menu = new JMenu("Options");

        JMenuItem pauseItem = new JMenuItem("Pause");
        JMenuItem resumeItem = new JMenuItem("Resume");

       menu.add(pauseItem);
       menu.add(resumeItem);
       menubar.add(menu);
       
       controller = GameEngine.start("test", new Circus(800,600,new Easy()), menubar, Color.WHITE);
        
        pauseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == pauseItem) {
                    controller.pause();
                }
            }
        }
        );
        
        resumeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == resumeItem) {
                    controller.resume();
                }
            }
        }
        );
        menu.add(pauseItem);
        menu.add(resumeItem);

    }

}