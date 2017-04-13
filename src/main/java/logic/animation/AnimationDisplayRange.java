package logic.animation;

import logic.Play;
import logic.map.Point;
import logic.turn.TurnThread;

import java.util.List;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class AnimationDisplayRange extends Animation {

    /**
     * attribute
     */
    private Play.RangeIndicationMode rangeIndicationMode;

    /**
     * getter
     * @return Play.RangeIndicationMode
     */
    public Play.RangeIndicationMode getRangeIndicationMode() {
        return rangeIndicationMode;
    }

    /**
     * setter
     * @param rangeIndicationMode
     * @return AnimationDisplayRange
     */
    public AnimationDisplayRange setRangeIndicationMode(Play.RangeIndicationMode rangeIndicationMode) {
        this.rangeIndicationMode = rangeIndicationMode;
        return this;
    }


    private List<Point> locations;

    /**
     * this method is to set Location
     * @param locations List<Point>
     * @return AnimationDisplayRange
     */

    public AnimationDisplayRange setLocations(List<Point> locations) {
        this.locations = locations;
        return this;
    }


    /**
     * this method is the animate
     * @override method for animate
     */
    @Override
    public void animate() {
        play.setRangeIndication(locations, rangeIndicationMode);
        TurnThread.pause(TurnThread.PAUSE_NORMAL);
    }
}
