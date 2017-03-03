package ui.controlView;

import ui.scene.MapEditingScene;
import ui.view.View;

/**
 * @author Siyu Chen
 * @version 0.1
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
}
