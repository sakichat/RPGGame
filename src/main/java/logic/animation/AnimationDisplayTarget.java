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
     * target getter
     * @return Point
     */
    public Point getTarget() {
        return target;
    }

    /**
     * target setter
     * @param target
     * @return AnimationDisplayTarget
     */
    public AnimationDisplayTarget setTarget(Point target) {
        this.target = target;
        return this;
    }

    /**
     * attribute
     */
    private Point target;

    /**
     * @override method to animate
     */
    @Override
    public void animate() {
        Play play = PlayRuntime.currentRuntime().getPlay();
        play.setTargetLocation(target);
        TurnThread.pause(TurnThread.PAUSE_FAST);
    }
}
