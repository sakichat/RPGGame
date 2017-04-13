package logic.effect;

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
     * This method
     */
    protected void willDetach(){

    }

    public String getImageName() {
        return imageName;
    }

    public Player getOnPlayer() {
        return onPlayer;
    }

    public int getTurns() {
        return turns;
    }

    public final void turn(){
        affect();
        turns--;
        detaching();
    }


}
