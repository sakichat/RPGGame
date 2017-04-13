package logic.animation;

import logic.Play;
import logic.PlayRuntime;
import logic.turn.TurnThread;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class AnimationHideTarget extends Animation {
    @Override
    public void animate() {
        Play play = PlayRuntime.currentRuntime().getPlay();
        play.setTargetLocationEnabled(false);
        TurnThread.pause(TurnThread.PAUSE_FAST);
    }
}
