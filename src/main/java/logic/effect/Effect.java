package logic.effect;

import logic.player.Player;

public class Effect {
    protected Player onPlayer;

    public Player getOnPlayer() {
        return onPlayer;
    }

    public void setOnPlayer(Player onPlayer) {
        this.onPlayer = onPlayer;
        attaching();
    }

    private int turns;

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }


    public final void turn(){
        affect();
        turns--;
        detaching();
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


}
