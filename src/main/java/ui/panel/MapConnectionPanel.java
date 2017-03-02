package ui.panel;

import map.*;
import map.MapConnection;
import ui.controlView.ExitControlView;
import ui.view.ExitsConnectionView;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kai QI
 * @version 0.1
 */
public class MapConnectionPanel extends Panel {

    /**
     * property campaign and getter & setter
     */
    private Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    /**
     * property selectedMap and getter & setter
     */
    private List<String> selectedMap;

    public List<String> getSelectedMap() {
        return selectedMap;
    }

    public void setSelectedMap(List<String> selectedMap) {
        this.selectedMap = selectedMap;
    }

    /**
     * Layout
     */

    JPanel exitsConnetionPanel;

    /**
     * Title and size of the main panel
     */
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

        exitsConnetionPanel = new JPanel();
        exitsConnetionPanel.setLayout(null);
        exitsConnetionPanel.setSize(480, 440);
        exitsConnetionPanel.setLocation(0, 80);
        add(exitsConnetionPanel);

    }

    /**
     * This is a method makes data transfer to view
     */
    public void dataToView() {

        exitsConnetionPanel.removeAll();

        //for 添加“remove按钮 +ExitsConnectionView”组合
        //添加validate按钮

        int y = 0;
        int id = 1;

        if (campaign.getConnections() != null) {
            for (MapConnection mapConnection : campaign.getConnections()) {

                JButton removeButton = new JButton("Remove");
                removeButton.setSize(80, 40);
                removeButton.setLocation(10, y);
                exitsConnetionPanel.add(removeButton);


            }
        }

        for (String s : selectedMap) {

            JButton removeButton = new JButton("Remove");
            removeButton.setSize(80, 40);
            removeButton.setLocation(10, y);
            exitsConnetionPanel.add(removeButton);

            ExitsConnectionView exitsConnectionView = new ExitsConnectionView();
            exitsConnectionView.setLocation(100, y);
            exitsConnetionPanel.add(exitsConnectionView);
//            exitsConnectionView.



//            y += 50;

        }





    }
}
