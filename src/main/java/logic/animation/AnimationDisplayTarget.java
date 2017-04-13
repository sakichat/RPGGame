package logic.animation;

import logic.Play;
import logic.PlayRuntime;
import logic.map.Point;
import logic.turn.TurnThread;

/**
 * Created on 12/04/2017.
 */
public class AnimationDisplayTarget extends Animation {

    public Point getTarget() {
        return target;
    }

    public AnimationDisplayTarget setTarget(Point target) {
        this.target = target;
        return this;
    }

    private Point target;

    @Override
    public void animate() {
        Play play = PlayRuntime.currentRuntime().getPlay();
        play.setTargetLocation(target);
        TurnThread.pause(TurnThread.PAUSE_FAST);
    }
}
