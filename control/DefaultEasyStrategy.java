package control;

import view.LevelsFrame;

/**
 * @author Ahmed Mahmoud
 */
public class DefaultEasyStrategy extends Easy{
    public void increaseDifficulty(Circus game){
        if(game.getScore().getScore() >= 15){
            game.setStrategy(new DefaultMediumStrategy());
            GameObjectContainer.movable.clear();
            game.Factory();
            LevelsFrame.getController().changeWorld(game);
        }
    }
}
