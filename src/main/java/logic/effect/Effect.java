package logic.effect;

import logic.Logger;
import logic.player.Player;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class Effect {
    /**
     * attributes
     */
    protected Player onPlayer;
    private int turns;
    private String imageName;

    /**
     * onPlayer setter
     * @param onPlayer
     */
    public void setOnPlayer(Player onPlayer) {
        this.onPlayer = onPlayer;
        attaching();
    }

    /**
     * turns setter
     * @param turns
     */
    public void setTurns(int turns) {
        this.turns = turns;
    }

    /**
     * imageName setter
     * @param imageName
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * This method is used to put on and detach effect
     */
    private void attaching() {
        Logger.getInstance().log(this + " attached on " + onPlayer);
        didAttach();
        detaching();
    }

    /**
     * This method is used to detaching effect on player
     */
    private void detaching() {
        if (turns == 0){
            willDetach();
            onPlayer.removeEffect(this);
            Logger.getInstance().log(this + " left from " + onPlayer);
        }
    }

    /**
     * This method is used to attach effect on player
     */
    protected void didAttach(){

    }

    /**
     * This method is used to set player's hp
     */
    protected void affect(){

    }

    /**
     * This method is used to detach effect once
     */
    protected void willDetach(){

    }

    /**
     * imageName getter
     * @return String
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * onPlayer getter
     * @return Player
     */
    public Player getOnPlayer() {
        return onPlayer;
    }

    /**
     * turns getter
     * @return Integer
     */
    public int getTurns() {
        return turns;
    }

    /**
     * This is the method for a turn
     */
    public final void turn(){
        affect();
        turns--;
        detaching();
    }

    /**
     * this method is to override the toString
     * @return String
     */

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
