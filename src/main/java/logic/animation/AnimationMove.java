package logic.animation;

import logic.map.Movement;
import logic.map.Point;
import logic.turn.TurnThread;

public class AnimationMove extends Animation {
    private Movement movement;

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public void execute() {
        Point source = player.getLocation();
        Point target;
        for (Point.Direction direction : movement) {
            target = source.add(direction);
            gameMap.moveCell(source, target);
            TurnThread.pause(TurnThread.PAUSE_FAST);
            source = target;
        }
    }
}
