package control;

import view.LevelsFrame;

/**
 * @author Ahmed Mahmoud
 */
public class DefaultMediumStrategy extends Medium {

    public void increaseDifficulty(Circus game) {
        if (game.getScore().getScore() >= 25) {
            game.setStrategy(new Hard());
            GameObjectContainer.movable.clear();
            game.Factory();
            LevelsFrame.getController().changeWorld(game);
        }
    }
}
