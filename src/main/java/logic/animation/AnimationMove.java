package logic.animation;

import logic.map.Movement;
import logic.map.Point;
import logic.turn.TurnThread;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class AnimationMove extends Animation {
    /**
     * attribute
     */
    private Movement movement;

    /**
     * getter
     * @return Movement
     */
    public Movement getMovement() {
        return movement;
    }

    /**
     * setter
     * @param movement
     * @return AnimationMove
     */
    public AnimationMove setMovement(Movement movement) {
        this.movement = movement;
        return this;
    }

    /**
     * @override method to animate
     */
    @Override
    public void animate() {
        Point source = currentPlayer.getLocation();
        Point target;
        for (Point.Direction direction : movement) {
            target = source.add(direction);
            gameMap.moveCell(source, target);
            TurnThread.pause(TurnThread.PAUSE_FAST);
            source = target;
        }
    }
}
