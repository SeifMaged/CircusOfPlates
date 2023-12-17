package view;

import control.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.*;

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
       
       Circus game = new Circus(800,600,new Easy());
       
       controller = GameEngine.start("Circus Of Plates", game, menubar, Color.WHITE);
        
//       if(game.getScore().getScore() > 5)
//       {
//           game.setStrategy(new Medium());
//       }
//       if(game.getScore().getScore() > 8)
//       {
//           game.setStrategy(new Hard());
//       }
       
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