package ui.scene;

/**
 * Created by Penelope on 17/2/28.
 */
public class CampaignEditingScene extends Scene {
    @Override
    protected void init() {
        super.init();

        title = "Edit Campaign";
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }
}
