package ui.controlView;

import ui.scene.MapEditingScene;
import ui.view.View;

/**
 * Created by Penelope on 17/3/2.
 */
public class ControlView extends View {
    protected MapEditingScene mapEditingScene;

    public MapEditingScene getMapEditingScene() {
        return mapEditingScene;
    }

    public void setMapEditingScene(MapEditingScene mapEditingScene) {
        this.mapEditingScene = mapEditingScene;
    }
}
