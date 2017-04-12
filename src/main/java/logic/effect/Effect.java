package logic.effect;

import logic.player.Player;

public class Effect {
    protected Player onPlayer;
    private int turns;
    private String imageName;

    public void setOnPlayer(Player onPlayer) {
        this.onPlayer = onPlayer;
        attaching();
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    private void attaching() {
        didAttach();
        detaching();
    }

    private void detaching() {
        if (turns == 0){
            willDetach();
            onPlayer.removeEffect(this);
        }
    }

    protected void didAttach(){

    }

    protected void affect(){

    }

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
