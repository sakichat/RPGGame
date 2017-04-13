package logic.animation;

import logic.turn.TurnThread;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class AnimationHideRange extends Animation {
    @Override
    public void animate() {
        play.setRangeIndicationEnabled(false);
        TurnThread.pause(TurnThread.PAUSE_FAST);
    }
}
