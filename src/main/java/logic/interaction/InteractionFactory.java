package logic.interaction;

import logic.map.Cell;
import logic.map.Chest;
import logic.map.Exit;
import logic.player.Player;


/**
 * @author Kai QI
 * @version 0.3
 * The class is used to create a new interaction object
 */

public class InteractionFactory {

    /**
     * The method is used to interaction.
     * @param source Player
     * @param target Cell
     * @return Interaction 
     */
    public Interaction interaction(Player source, Cell target){

        Interaction interaction = null;

        if (target instanceof Player) {

            Player targetPlayer = (Player) target;

            if (targetPlayer.isDead()) {
                interaction = new InteractionDeadNPC();
                interaction.setTarget(targetPlayer);

            } else {
                if (targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_FRIENDLY)) {
                    interaction = new InteractionFriendlyNPC();
                    interaction.setTarget(targetPlayer);
                }
            }

        } else if (target instanceof Chest) {
            interaction = new InteractionChest();
            interaction.setTarget((Chest) target);

        } else if (target instanceof Exit) {
            interaction = new InteractionExit();
            interaction.setTarget((Exit) target);
        }

        if (interaction != null){
            interaction.setPlayer(source);
        }

        return interaction;
    }
}
