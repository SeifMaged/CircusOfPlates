package control;


/**
 *
 * @author Adham
 */
public class Score extends Subject{
    private int score=0;
    
    public void increaseScore(int increment){
        score +=increment;
        notifyAllSubscribers();
    }
    
    public int getScore(){
        return this.score;
    }

    @Override
    public void notifyAllSubscribers() {
        for(Observer observer: observers){
            observer.getStatus();
        }
    }
    
}
