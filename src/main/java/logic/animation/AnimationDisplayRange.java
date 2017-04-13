package logic.animation;

import logic.Play;
import logic.map.Point;
import logic.turn.TurnThread;

import java.util.List;

/**
 * Created on 12/04/2017.
 */
public class AnimationDisplayRange extends Animation {

    private Play.RangeIndicationMode rangeIndicationMode;

    public Play.RangeIndicationMode getRangeIndicationMode() {
        return rangeIndicationMode;
    }

    public AnimationDisplayRange setRangeIndicationMode(Play.RangeIndicationMode rangeIndicationMode) {
        this.rangeIndicationMode = rangeIndicationMode;
        return this;
    }

    @Override
    public void animate() {
        List<Point> locations = gameMap.getGraph().pointsInRange(currentPlayer.getLocation(), 3);
        play.setRangeIndication(locations, rangeIndicationMode);
        TurnThread.pause(TurnThread.PAUSE_NORMAL);
    }
}
