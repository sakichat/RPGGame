package ui.controlView;

import ui.scene.MapEditingScene;
import ui.scene.PlayScene;
import ui.view.View;

/**
 * This ControlView sets a template of other control views which extends View class
 * @author Siyu Chen
 * @version 0.3
 */
public class ControlView extends View {
    /**
     * This is a property of ControlView for MapEditingScene
     */
    protected MapEditingScene mapEditingScene;

    /**
     * This is a method for getting a MapEditingScene
     * @return mapEditingScene
     */
    public MapEditingScene getMapEditingScene() {
        return mapEditingScene;
    }

    /**
     * This is a method for setting a MapEditingScene
     * @param mapEditingScene
     */
    public void setMapEditingScene(MapEditingScene mapEditingScene) {
        this.mapEditingScene = mapEditingScene;
    }

    /**
     * property of playScene
     */
    protected PlayScene playScene;

    /**
     * The method of getPlayScene
     * @return PlayScene
     */
    public PlayScene getPlayScene() {
        return playScene;
    }

    /**
     * The method of setPlayScene
     * @param playScene
     */
    public void setPlayScene(PlayScene playScene) {
        this.playScene = playScene;
    }
}
