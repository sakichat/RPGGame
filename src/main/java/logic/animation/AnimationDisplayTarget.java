package logic.animation;

import logic.Play;
import logic.PlayRuntime;
import logic.map.Point;
import logic.turn.TurnThread;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class AnimationDisplayTarget extends Animation {

    /**
     *
     * @return
     */
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
