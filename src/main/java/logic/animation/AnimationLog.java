package logic.animation;

import logic.Logger;
import logic.turn.TurnThread;

/**
 * Created on 13/04/2017.
 */
public class AnimationLog extends Animation {

    private String message;

    public AnimationLog setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public void animate() {
        Logger.getInstance().log(message);
        TurnThread.pause(TurnThread.PAUSE_FAST);
    }
}
