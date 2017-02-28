package ui.scene;

/**
 * Created by Penelope on 17/2/28.
 */
public class CampaignCreationScene extends Scene {
    @Override
    protected void init() {
        super.init();

        title = "Create Campaign";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    protected void initSubviews() {

    }
}
