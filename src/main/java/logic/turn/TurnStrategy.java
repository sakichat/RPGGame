package logic.turn;

import logic.Play;
import logic.map.Cell;
import logic.player.Player;

public class TurnStrategy {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void turn(){

    }
    
    private boolean attackTargetsInNear(){
        // TODO: 08/04/2017
        return false;
    }

    protected boolean couldAttack(Player targetPlayer) {
        return true;
    }

    private boolean interactTargetsInNear(){
        // TODO: 08/04/2017
        return false;
    }

    protected boolean couldInteract(Cell cell) {
        return true;
    }
}
