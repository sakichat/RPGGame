package ui.scene;

/**
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayScene extends Scene {
    @Override
    protected void init() {
        super.init();

        backButtonEnabled = true;
        saveButtonEnabled = false;
    }
}
