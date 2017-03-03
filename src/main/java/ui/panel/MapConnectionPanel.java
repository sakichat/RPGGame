package ui.panel;

import logic.Campaign;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel messageLabel;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
        dataToView();
    }

    Panel mapSequencePanel;

    /**
     * Constructor
     */
    @Override
    protected void init() {
        super.init();

        setSize(640, 500);
        title = "Map Connection";

        initSubviews();

    }

    /**
     * Layout
     */
    protected void initSubviews() {

        JLabel label;

        label = new JLabel("Start", JLabel.LEFT);
        label.setSize(100, 40);
        label.setLocation(140, 30);
        add(label);

        mapSequencePanel = new Panel();
        mapSequencePanel.setLayout(null);
        mapSequencePanel.setSize(640, 420);
        mapSequencePanel.setLocation(0, 80);
        add(mapSequencePanel);

    }

    /**
     * This is a method makes data transfer to view
     */
    public void dataToView() {

        mapSequencePanel.removeAll();

        JButton button;
        JLabel label;

        int y = 0;

        List<String> names = campaign.getMapNames();

        for (int i = 0; i < names.size(); i++) {
            final int index = i;
            String s = names.get(i);

            button = new JButton("Remove");
            button.setSize(100, 40);
            button.setLocation(20, y);
            mapSequencePanel.add(button);
            JButton removeButton = button;

            label = new JLabel("", JLabel.LEFT);
            label.setSize(180, 40);
            label.setLocation(140, y);
            mapSequencePanel.add(label);
            label.setText(s);
            JLabel mapNameLabel = label;

            y += 50;

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    campaign.removeMapName(index);
                    dataToView();
                }
            });

        }

        label = new JLabel("End", JLabel.LEFT);
        label.setSize(100, 40);
        label.setLocation(140, y);
        mapSequencePanel.add(label);
        JLabel endNameLabel = label;
        y += 50;

        button = new JButton("Validate");
        button.setSize(160, 40);
        button.setLocation(140, y);
        mapSequencePanel.add(button);
        JButton validateButton = button;
        y += 50;

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateCampaign();
            }
        });

        label = new JLabel();
        label.setSize(200, 40);
        label.setLocation(140, y);
        mapSequencePanel.add(label);
        messageLabel = label;

    }

    /**
     * this method is used to validate the campaign
     */
    private void validateCampaign(){
        String result = campaign.validate();
        messageLabel.setText(result);
    }
}
