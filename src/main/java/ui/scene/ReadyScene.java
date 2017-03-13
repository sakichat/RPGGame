package ui.scene;

/**
 * @author Siyu Chen
 * @version 0.2
 */
public class ReadyScene extends Scene {
    @Override
    protected void init() {
        super.init();

        title = "Ready";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }
}
