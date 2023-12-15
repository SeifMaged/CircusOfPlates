package View;

import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Ahmed Mahmoud
 */
public class Menu extends JMenuBar implements ActionListener{
    private static final Menu instance = new Menu();
    
    private GameEngine.GameController controller;
    
    private final JMenu menu;
    private final JMenuItem pauseItem;
    private final JMenuItem resumeItem;
    
    private Menu(){
        menu = new JMenu("Options");
        
        pauseItem = new JMenuItem("Pause");
        resumeItem = new JMenuItem("Resume");
        
        pauseItem.addActionListener(this);
        resumeItem.addActionListener(this);
        
        menu.add(pauseItem);
        menu.add(resumeItem);
        
        this.add(menu);
    }
    
    public static Menu getInstance(){
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pauseItem){
            controller.pause();
        }
        else if(e.getSource() == resumeItem){
            controller.resume();
        }
    }
}
