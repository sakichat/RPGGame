package logic.animation;

import logic.turn.TurnThread;

/**
 * Created on 12/04/2017.
 */
public class AnimationHideRange extends Animation {
    @Override
    public void animate() {
        play.setRangeIndicationEnabled(false);
        TurnThread.pause(TurnThread.PAUSE_FAST);
    }
}
