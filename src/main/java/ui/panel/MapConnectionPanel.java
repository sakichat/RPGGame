package ui.panel;

import map.Campaign;

import javax.swing.*;

/**
 * Created by Penelope on 17/2/28.
 */
public class MapConnectionPanel extends Panel {

    private Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @Override
    protected void init() {
        super.init();

        setSize(640, 500);
        title = "Map Connection";

        dataToView();
    }

    protected void initSubviews() {

        JLabel label;

        label = new JLabel("ID", JLabel.RIGHT);
        label.setSize(40, 40);
        label.setLocation(100, 30);
        add(label);

        label = new JLabel("Map Name", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 30);
        add(label);

        label = new JLabel("Exit Connection", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(320, 30);
        add(label);

        //for 添加“remove按钮 +ExitsConnectionView”组合
        //添加validate按钮


    }

    public void dataToView() {
        int x = 10;
        int y = 80;
    }
}
